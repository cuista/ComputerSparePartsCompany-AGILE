package it.unical.asd.group6.computerSparePartsCompany;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FAQTest extends AbstractComputerSparePartsCompanyTest{

    //DAO TESTs

    @Test
    public void testGetByTitle(){
        assert(faqDao.getByTitle("GenericTitle").get().getId()==126L);
    }

    @Test
    public void testGetByDescription(){
        assert (faqDao.getByDescription("blablabla").get().getTitle().equals("GenericTitle"));
    }

    @Test
    public void testGetById(){
        assert (faqDao.getById(126L).get().getTitle().equals("GenericTitle"));
    }

    @Test
    public void testGetAll(){
        assert (faqDao.getAll().get().size()==1);
    }

}
