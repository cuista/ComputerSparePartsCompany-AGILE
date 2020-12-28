package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.data.dao.CategoryDao;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.CustomerDao;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.EmployeeDao;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.*;
import it.unical.asd.group6.computerSparePartsCompany.core.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private CategoryDao categoryDao;

    /*
    Ritorna TRUE se l'employee, con le rispettive credenziali, è presente nel db
     */
    @Override
    public boolean checkLogin(String username, String password) {
        Optional<Employee> opt = employeeDao.findEmployeeByUsernameAndPassword(username, password);
        return opt.isPresent();
    }

    @Override
    public Optional<Employee> getEmployeeByUsername(String username)
    {
        Optional<Employee> employee = employeeDao.findEmployeeByUsername(username);
        return employee;
    }

    @Override
    public Integer getReportTotalPurchases() {
        int totalPurchases = 0;
        List<Customer> customers = customerDao.findAll();
        for(Customer c: customers){
            totalPurchases += customerService.getReportTotalPurchases(c.getUsername());
        }
        return totalPurchases;
    }

    @Override
    public Double getReportTotalAmountSpent() {
        double totalSpent = 0.0;
        List<Customer> customers = customerDao.findAll();
        for(Customer c: customers){
            totalSpent += customerService.getReportTotalAmountSpent(c.getUsername());
        }
        return totalSpent;
    }

    @Override
    public Long getReportFavoriteCategory() {
        List<Customer> customers = customerDao.findAll();
        HashMap<Long, Integer> countCategory = initializeHashMapCategory();
        for(Customer c: customers) {
            List<Purchase> purchases = c.getPurchases();
            for(Purchase p: purchases){
                List<Product> products = p.getProducts();
                for(Product pr: products){
                    countCategory.put(pr.getCategory().getId(), countCategory.get(pr.getCategory().getId()) + 1);
                }
            }
            return countCategory.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
        }
        return null;
    }

    private HashMap<Long, Integer> initializeHashMapCategory() {
        HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
        List<Category> categories = categoryDao.findAll();
        for(Category c: categories)
            hm.put(c.getId(), 0);
        return hm;
    }

    @Transactional
    public Boolean updateEmployee(String username,String password)
    {
        employeeDao.updateEmployeePassword(username,password);
        return true;
    }
}
