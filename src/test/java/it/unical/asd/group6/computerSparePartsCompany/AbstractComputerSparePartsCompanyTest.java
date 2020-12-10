package it.unical.asd.group6.computerSparePartsCompany;

import it.unical.asd.group6.computerSparePartsCompany.data.dao.CustomerDao;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.EmployeeDao;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Employee;
import org.apache.commons.csv.CSVRecord;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AbstractComputerSparePartsCompanyTest {

    @Value("classpath:data/employees.csv")
    private Resource employeesRes;

    @Value("classpath:data/customers.csv")
    private Resource customersRes;

    @Autowired
    protected EmployeeDao employeeDao;

    @Autowired
    protected CustomerDao customerDao;

    private static boolean isInitialized = false;

    @Before
    public void createDbTest() throws IOException{

        if (!isInitialized) {

            CSVParser employeesCsv = CSVFormat.DEFAULT.withDelimiter(',')
                    .parse(new InputStreamReader(employeesRes.getInputStream()));
            for (CSVRecord record : employeesCsv) {
                insertEmployee(record.get(0), record.get(1), record.get(2), record.get(3),
                        LocalDate.parse(record.get(4), DateTimeFormatter.ISO_LOCAL_DATE),
                        record.get(5), record.get(6));
            }

            CSVParser customersCsv = CSVFormat.DEFAULT.withDelimiter(',')
                    .parse(new InputStreamReader(customersRes.getInputStream()));
            for (CSVRecord record : customersCsv) {
                insertCustomer(record.get(0), record.get(1), record.get(2), record.get(3),
                        record.get(4), record.get(5),Long.parseLong(record.get(6)));
            }

            isInitialized=true;
        }
    }

    private void insertEmployee(String username, String password, String firstname, String lastname,
                                LocalDate hiringDate, String email, String telephoneNumber){
        Employee emp=new Employee();
        emp.setUsername(username);
        emp.setPassword(password);
        emp.setFirstname(firstname);
        emp.setLastname(lastname);
        emp.setHiringDate(hiringDate);
        emp.setEmail(email);
        emp.setTelephoneNumber(telephoneNumber);

        employeeDao.save(emp);
    }

    private void insertCustomer(String name, String surname, String phoneNumber, String email,
                                String username, String password, Long VATIdentificationNumber){
        Customer cust=new Customer();
        cust.setName(name);
        cust.setSurname(surname);
        cust.setPhoneNumber(phoneNumber);
        cust.setEmail(email);
        cust.setUsername(username);
        cust.setPassword(password);
        cust.setVATIdentificationNumber(VATIdentificationNumber);

        customerDao.save(cust);

    }
}
