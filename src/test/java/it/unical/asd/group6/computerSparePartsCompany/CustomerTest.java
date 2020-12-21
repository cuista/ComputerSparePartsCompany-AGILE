package it.unical.asd.group6.computerSparePartsCompany;

import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.CustomerServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
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
    private CustomerServiceImpl customerService;

    /*
    Service test a seguire
     */
    @Test
    public void checkUser() {
        assert(customerService.searchByUsername("Marti"));
    }

    @Test
    public void checkEmail() {
        assert(customerService.searchByEmail("Marti.Brunell@mail.com"));
    }

    @Test
    public void testRegistration() {
        Customer c = new Customer();
        c.setEmail("mvspod");
        c.setVATIdentificationNumber(123L);
        c.setPassword("password");
        c.setUsername("username");
        c.setPhoneNumber("13534634");
        c.setSurname("aaaa");
        c.setName("bbb");
        customerDao.save(c);
        assert(customerService.checkLogin("username","password"));
        for(Customer customer: customerDao.findAll()) {
            System.out.println(customer.toString());
        }
    }

    @Test
    public void testLoginWithService() {
        assert(customerService.checkLogin("Marti","Brunell"));
    }

    @Test
    public void testSignUpWithService() {
        //controllo che non faccia registrare un utente già presente sul db
        Customer c = new Customer();
        c.setName("Ciccio");
        c.setSurname("Brunell");
        c.setPhoneNumber("2103761416");
        c.setEmail("Marti.Brunell@mail.com");
        c.setUsername("Marti");
        c.setPassword("Brunell");
        c.setVATIdentificationNumber(28765246203L);
        assert(!customerService.registerNewCustomer(c));
    }

    /*
    Test dao a seguire
     */
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

    @Test
    public void testFindCustomerByUsernameAndPassword_OK() {
        Optional<Customer> customer=customerDao.findCustomerByUsernameAndPassword("Donnie","Cristi");
        assert(customer.get()!=null);
        assert(customer.get().getPhoneNumber().equals("1815289551"));
        assert(customer.get().getUsername().equals("Donnie"));
        assert(customer.get().getPassword().equals("Cristi"));
        assert(customer.get().getEmail().equals("Donnie.Cristi@mail.com"));
        assert(customer.get().getName().equals("Donnie"));
        assert(customer.get().getSurname().equals("Cristi"));
    }

    @Test
    public void testFindAllCustomers_OK(){
        List<Customer> customers=customerDao.findAll();

        for (Customer c: customers) {
            System.out.println(c.getId());
        }
    }

}
