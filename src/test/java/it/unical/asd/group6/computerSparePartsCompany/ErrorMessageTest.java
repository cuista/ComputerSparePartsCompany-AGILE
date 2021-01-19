package it.unical.asd.group6.computerSparePartsCompany;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ErrorMessageTest extends AbstractComputerSparePartsCompanyTest{

    //DAO TESTs

    @Test
    public void testGetAll(){
        assert(errorMessageDAO.getAll().get().size()==1);
    }

    @Test
    public void testGetAllByUsername(){
        assert(errorMessageDAO.getAllByUsername("Marti").get().getTitle().equals("Something"));
    }
}
