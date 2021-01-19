package it.unical.asd.group6.computerSparePartsCompany;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.internal.util.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest extends AbstractComputerSparePartsCompanyTest{

    /*
    Service Tests
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
    }

    @Test
    public void testLoginWithService() {
        assert(customerService.checkLogin("Marti","Brunell"));
    }

    /*
    DAO Tests
     */
    @Test
    public void testGetAllUsernames(){
        assert(customerDao.getAllUsernames().size()==10);
    }

    @Test
    public void testFindAllByUsernameIsNotNull_OK(){
        assert(customerDao.findAllByUsernameIsNotNull().get().size()==10);
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
    public void testFindCustomerByEmailAndUsername(){
        Assert.notNull(customerDao.findCustomerByEmailAndUsername("Marti.Brunell@mail.com", "Marti"));
    }

    @Test
    public void testFindCustomerByUsername(){
        Assert.notNull(customerDao.findCustomerByUsername("Marti"));
    }

    @Test
    public void testFindCustomerByEmail(){
        Assert.notNull(customerDao.findCustomerByEmail("Marti.Brunell@mail.com"));
    }

    @Test
    public void testFindCustomerById(){
        Assert.notNull(customerDao.findCustomerById(11L));
    }

    @Test
    public void testDeleteByUsername(){
        Assert.notNull(customerDao.findCustomerByUsername("Arlina"));
        customerDao.deleteByUsername("Arlina");
        assert (!customerDao.findCustomerByUsername("Arlina").isPresent());
    }

    @Test
    public void testUpdateCustomerPassword(){
        customerDao.updateCustomerPassword("Tilly","TettoDegliIlluminati");
        assert(customerDao.findCustomerByUsername("Tilly").get().getPassword().equals("TettoDegliIlluminati"));
    }

    @Test
    public void testUpdateCustomerData(){
        customerDao.updateCustomerData("Tomasina","Tomasina","Charmine","6666666666",28938763185L);
        assert(customerDao.findCustomerByUsername("Tomasina").get().getPhoneNumber()=="6666666666");
    }

}
