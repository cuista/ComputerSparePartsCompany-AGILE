package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.customer.CustomerByUsernameNotFoundOnRetrieveException;
import it.unical.asd.group6.computerSparePartsCompany.core.exception.customer.CustomerSearchByEmailNotFoundException;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.CategoryDao;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.CustomerDao;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.CustomerDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Category;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.core.services.CustomerService;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Purchase;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Boolean registerNewCustomer(Customer customer) {
        if (true) {
            customerDao.save(customer);
            return true;
        } else
            return false;

    }

    @Override
    public Boolean createNewCustomer(String name, String surname, String phoneNumber, String email, String username, String password, Long vatID) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setSurname(surname);
        customer.setPhoneNumber(phoneNumber);
        customer.setEmail(email);
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setVATIdentificationNumber(vatID);
        if (true) {
            customerDao.save(customer);
            return true;
        } else
            return false;
    }

    @Override
    public Boolean checkLogin(String username, String password) {
        Optional<Customer> opt = customerDao.findCustomerByUsernameAndPassword(username, password);
        return opt.isPresent();
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return customerDao.findAll().stream().map(c -> modelMapper.map(c, CustomerDTO.class)).collect(Collectors.toList());
    }

    @Override
    public Customer deleteUser(Customer customer) {
        customerDao.delete(customer);
        return customer;
    }

    @Override
    public Boolean searchByUsername(String username) {
        Customer customer = customerDao.findCustomerByUsername(username).orElseThrow(() -> new CustomerByUsernameNotFoundOnRetrieveException(username));
        return true;
    }

    @Override
    public Boolean searchByEmail(String email) {
        Customer customer = customerDao.findCustomerByEmail(email).orElseThrow(() -> new CustomerSearchByEmailNotFoundException(email));
        return true;
    }

    @Override
    public Optional<CustomerDTO> getCustomerByUsername(String username) {
        Optional<Customer> customer = customerDao.findCustomerByUsername(username);
        Optional<CustomerDTO> customerDTO = Optional.of(modelMapper.map(customer.get(), CustomerDTO.class));
        return customerDTO;
    }

    @Override
    public Integer getReportTotalPurchases(String username) {
        int totalPurchases;
        Optional<Customer> optCust = customerDao.findCustomerByUsername(username);
        if (optCust.isPresent()) {
            Customer customer = optCust.get();
            totalPurchases = customer.getPurchases().size();
            return totalPurchases;
        }
        return 0;
    }

    @Override
    public Double getReportTotalAmountSpent(String username) {
        double sum = 0.0;
        Optional<Customer> optCust = customerDao.findCustomerByUsername(username);
        if (optCust.isPresent()) {
            Customer customer = optCust.get();
            List<Purchase> purchases = customer.getPurchases();
            for (Purchase p : purchases) {
                sum += p.getTotalPrice();
            }
            return sum;
        }
        return 0.0;
    }

    @Override
    public String getReportFavoriteCategory(String username) {
        Optional<Customer> optCust = customerDao.findCustomerByUsername(username);
        if (optCust.isPresent()) {
            Customer customer = optCust.get();
            List<Purchase> purchases = customer.getPurchases();
            HashMap<Long, Integer> countCategory = initializeHashMapCategory();
            for (Purchase p : purchases) {
                List<Product> products = p.getProducts();
                for (Product pr : products) {
                    countCategory.put(pr.getCategory().getId(), countCategory.get(pr.getCategory().getId()) + 1);
                }
            }

            Long favId = null;
            int maxCount = -1;

            for (Long id: countCategory.keySet()){
                if (countCategory.get(id) > maxCount){
                    favId = id;
                    maxCount = countCategory.get(id);
                }
            }

            return categoryDao.findCategoryById(favId).getCategoryName();
        }
        return null;
    }

    private HashMap<Long, Integer> initializeHashMapCategory() {
        HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
        List<Category> categories = categoryDao.findAll();
        for (Category c : categories)
            hm.put(c.getId(), 0);
        return hm;
    }


    @Transactional
    public Boolean deleteCustomer(String username) {
        customerDao.deleteByUsername(username);
        Optional<Customer> customerOptional = customerDao.findCustomerByUsername(username);
        return !customerOptional.isPresent();
    }

    @Transactional
    public Boolean updateCustomer(String username,String password) {
        customerDao.updateCustomerPassword(username,password);
        return true;
    }

    @Transactional
    public Boolean updateDataCustomer(String username,String name,String surname,String phoneNumber,Long iva) {
        customerDao.updateCustomerData(username,name,surname,phoneNumber,iva);
        return true;
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(Long id) {
        Optional<Customer> customer = customerDao.findCustomerById(id);
        Optional<CustomerDTO> customerDTO = Optional.of(modelMapper.map(customer.get(), CustomerDTO.class));
        return customerDTO;
    }

    @Override
    public List<String> getAllUsernames() {
        return customerDao.getAllUsernames();
    }

    @Override
    public void updateCustomerInfos(CustomerDTO customerDTO, CustomerDTO newCustomerDTO) {
        customerDTO.setPassword(newCustomerDTO.getPassword());
        customerDTO.setVATIdentificationNumber(newCustomerDTO.getVATIdentificationNumber());
        customerDTO.setPhoneNumber(newCustomerDTO.getPhoneNumber());
        customerDTO.setName(newCustomerDTO.getName());
        customerDTO.setSurname(newCustomerDTO.getSurname());
        customerDTO.setEmail(newCustomerDTO.getEmail());
        customerDao.save(modelMapper.map(customerDTO, Customer.class));
    }

    @Override
    public Optional<Customer> getCustomerEntityByUsername(String username) {
        return customerDao.findCustomerByUsername(username);
    }

    @Override
    public Optional<Customer> getCustomerEntityById(Long customerId) {
        return customerDao.findCustomerById(customerId);
    }

}
