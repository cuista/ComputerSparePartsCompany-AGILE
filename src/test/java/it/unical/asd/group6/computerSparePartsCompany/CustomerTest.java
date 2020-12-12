package it.unical.asd.group6.computerSparePartsCompany;

import it.unical.asd.group6.computerSparePartsCompany.data.dao.CustomerDao;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.services.implemented.CustomerServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.data.services.implemented.EmployeeServiceImpl;
import org.apache.catalina.util.CustomObjectInputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest extends AbstractComputerSparePartsCompanyTest{

    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    CustomerDao customerDao;

    @Test
    public void loginServiceTest() {
        assert(customerService.checkLogin("Tilly", "Pelagias"));
        //DA FARE
    }

    @Test
    public void registrationTest(){
        Customer cust = new Customer();
        Customer cust2 = new Customer();

        cust.setEmail("ciao@virgilio.it");
        cust.setUsername("BimboCiao");

        cust2.setEmail("Tilly.Pelagias@mail.com");
        cust2.setUsername("Tilly");

        assert(customerService.registerNewCustomer(cust));
        assert(customerService.registerNewCustomer(cust2));

    }

    @Test
    public void testFindAllByUsernameIsNotNull_OK(){

        Optional<List<Customer>> customers= customerDao.findAllByUsernameIsNotNull();

        assert(customers.get()!=null);
        assert(customers.get().size()==10);

    }

    @Test
    public void testFindCustomerByNameAndSurname_OK(){

        Optional<Customer> customer = customerDao.findCustomerByNameAndSurname("Tilly","Pelagias");

        assert(customer.get()!=null);
        assert(customer.get().getEmail().equals("Tilly.Pelagias@mail.com"));
        assert(customer.get().getPassword().equals("Pelagias"));
        assert(customer.get().getUsername().equals("Tilly"));
        assert(customer.get().getPhoneNumber().equals("1306200590"));
        assert(customer.get().getVATIdentificationNumber().equals(39128838671L));
    }

    @Test
    public void testFindCustomerByVATIdentificationNumber(){

        Optional<Customer> customer=customerDao.findCustomerByVATIdentificationNumber(20780218656L);

        assert(customer.get()!=null);
        assert(customer.get().getPhoneNumber().equals("1815289551"));
        assert(customer.get().getUsername().equals("Donnie"));
        assert(customer.get().getPassword().equals("Cristi"));
        assert(customer.get().getEmail().equals("Donnie.Cristi@mail.com"));
        assert(customer.get().getName().equals("Donnie"));
        assert(customer.get().getSurname().equals("Cristi"));

    }

}
