package it.unical.asd.group6.computerSparePartsCompany;

import it.unical.asd.group6.computerSparePartsCompany.data.dao.*;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
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

    @Value("classpath:data/products.csv")
    private Resource productsRes;

    @Value("classpath:data/purchases.csv")
    private Resource purchasesRes;

    @Value("classpath:data/warehouses.csv")
    private Resource warehousesRes;

    @Value("classpath:data/purchasenotices.csv")
    private Resource purchaseNoticesRes;

    @Autowired
    protected EmployeeDao employeeDao;

    @Autowired
    protected CustomerDao customerDao;

    @Autowired
    protected ProductDao productDao;

    @Autowired
    protected PurchaseDao purchaseDao;

    @Autowired
    protected WarehouseDao warehouseDao;

    @Autowired
    protected PurchaseNoticeDao purchaseNoticeDao;

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

            CSVParser warehousesCsv = CSVFormat.DEFAULT.withDelimiter(',')
                    .parse(new InputStreamReader(warehousesRes.getInputStream()));
            for (CSVRecord record: warehousesCsv){
                insertWarehouse(record.get(0),record.get(1),record.get(2),record.get(3),record.get(4));
            }

            CSVParser purchasesCsv= CSVFormat.DEFAULT.withDelimiter(',')
                    .parse(new InputStreamReader(purchasesRes.getInputStream()));
            for (CSVRecord record: purchasesCsv) {
                insertPurchase(LocalDate.parse(record.get(0), DateTimeFormatter.ISO_LOCAL_DATE),
                        Long.parseLong(record.get(1)),Double.parseDouble(record.get(2)));
            }

            CSVParser productsCsv = CSVFormat.DEFAULT.withDelimiter(',')
                    .parse(new InputStreamReader(productsRes.getInputStream()));
            for (CSVRecord record : productsCsv) {
                insertProduct(Double.parseDouble(record.get(0)), record.get(1), record.get(2), record.get(3));
            }

            CSVParser purchaseNoticesCsv= CSVFormat.DEFAULT.withDelimiter(',')
                    .parse(new InputStreamReader(purchaseNoticesRes.getInputStream()));
            for (CSVRecord record: purchaseNoticesCsv){
                insertPurchaseNotice(LocalDate.parse(record.get(0), DateTimeFormatter.ISO_LOCAL_DATE),
                        Long.parseLong(record.get(1)),Long.parseLong(record.get(2)),record.get(3),record.get(4),
                                Integer.parseInt(record.get(5)));
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

        customerDao.saveAndFlush(cust);

    }

    private void insertProduct(Double price, String brand, String model, String description){
        Product prod=new Product();
        prod.setPrice(price);
        prod.setBrand(brand);
        prod.setModel(model);
        prod.setDescription(description);

        productDao.save(prod);

    }

    private void insertPurchase(LocalDate date, Long customer_id, Double totalPrice){
        Purchase purchase=new Purchase();
        purchase.setDate(date);
        Customer customer=customerDao.findById(customer_id).get();
        purchase.setCustomer(customer);
        purchase.setTotalPrice(totalPrice);

        purchaseDao.save(purchase);
    }

    private void insertWarehouse(String street, String province, String city, String region, String opening_hours) {
        Warehouse warehouse = new Warehouse();
        warehouse.setStreet(street);
        warehouse.setProvince(province);
        warehouse.setCity(city);
        warehouse.setRegion(region);
        warehouse.setOpeningHours(opening_hours);

        warehouseDao.saveAndFlush(warehouse);
    }

    private void insertPurchaseNotice(LocalDate collectionDate,  Long customerId, Long warehouseId, String productBrand,
                                      String productModel, Integer quantity){

        PurchaseNotice purchaseNotice=new PurchaseNotice();
        purchaseNotice.setCollectionDate(collectionDate);

        Customer customer=customerDao.findById(customerId).get();

        purchaseNotice.setCustomer(customer);

        Warehouse warehouse=warehouseDao.findById(warehouseId).get();

        purchaseNotice.setWarehouseId(warehouse);
        purchaseNotice.setProductBrand(productBrand);
        purchaseNotice.setProductModel(productModel);
        purchaseNotice.setQuantity(quantity);

        purchaseNoticeDao.save(purchaseNotice);

    }


}
