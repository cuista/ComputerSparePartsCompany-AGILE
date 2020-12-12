package it.unical.asd.group6.computerSparePartsCompany;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Employee;
import it.unical.asd.group6.computerSparePartsCompany.data.services.implemented.EmployeeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTest extends AbstractComputerSparePartsCompanyTest{

    @Autowired
    EmployeeServiceImpl employeeService;

    @Test
    public void loginServiceTest() {
        assert(employeeService.checkLogin("Rubie", "Mitzi"));
    }

    @Test
    public void testFindEmployeeByUsernameAndPassword_OK(){
        Optional<Employee> e=employeeDao.findEmployeeByUsernameAndPassword("Rubie","Mitzi");

        assert(e.get()!=null);
        assert(e.get().getFirstname().equals("Rubie"));
        assert(e.get().getLastname().equals("Mitzi"));
        assert(e.get().getEmail().equals("Rubie.Mitzi@mail.com"));
        assert(e.get().getTelephoneNumber().equals("1796853502"));
    }

    @Test
    public void testFindEmployeeByTelephoneNumber_OK(){
        Optional<Employee> emp=employeeDao.findEmployeeByTelephoneNumberEquals("1614827388");

        assert(emp.get()!=null);
        assert(emp.get().getUsername().equals("Kial"));
        assert(emp.get().getPassword().equals("Byrne"));
        assert(emp.get().getFirstname().equals("Kial"));
        assert(emp.get().getLastname().equals("Byrne"));
        assert(emp.get().getEmail().equals("Kial.Byrne@mail.com"));
    }

    @Test
    public void testFindEmployeesByHiringDateIsLowerThan_OK(){

        LocalDate date=LocalDate.now();

        Optional<List<Employee>> employees = employeeDao.findAllByHiringDateIsLessThan(date);

        assert(employees.get().size()==10);

    }

}
