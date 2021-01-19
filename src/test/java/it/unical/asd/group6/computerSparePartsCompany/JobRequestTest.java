package it.unical.asd.group6.computerSparePartsCompany;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.JobRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobRequestTest extends AbstractComputerSparePartsCompanyTest{

    //DAO TESTs

    @Test
    public void testGetAll(){
        assert(jobRequestDAO.getAll().get().size()==1);
    }

    @Test
    public void testGetAllByTitle(){
        assert(jobRequestDAO.getAllByTitle("JobTitle").get().size()==1);
    }

    @Test
    public void testGetAllByPosition(){
        assert(jobRequestDAO.getAllByPosition("X").get().size()==1);
    }

    @Test
    public void testGetAllByEmail(){
        assert(jobRequestDAO.getAllByEmail("job@email.com").get().size()==1);
    }

    @Test
    public void testGetByUsername(){
        assert(jobRequestDAO.getByUsername("Yyy").get().getTitle().equals("JobTitle"));
    }

}
