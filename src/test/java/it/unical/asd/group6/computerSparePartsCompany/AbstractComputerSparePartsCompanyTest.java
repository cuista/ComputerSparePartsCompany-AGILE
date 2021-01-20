package it.unical.asd.group6.computerSparePartsCompany;

import it.unical.asd.group6.computerSparePartsCompany.core.services.*;
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
import java.util.Optional;

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

    @Value("classpath:data/categories.csv")
    private Resource categoriesRes;

    @Value("classpath:data/orderRequests.csv")
    private Resource orderRequestsRes;

    @Value("classpath:data/productionHouses.csv")
    private Resource productionHousesRes;

    @Value("classpath:data/errorMessages.csv")
    private Resource errorMessagesRes;

    @Value("classpath:data/faqs.csv")
    private Resource faqsRes;

    @Value("classpath:data/jobRequests.csv")
    private Resource jobRequestsRes;

    @Value("classpath:data/reviews.csv")
    private Resource reviewsRes;

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

    @Autowired
    protected CategoryDao categoriesDao;

    @Autowired
    protected ErrorMessageDAO errorMessageDAO;

    @Autowired
    protected FAQDao faqDao;

    @Autowired
    protected JobRequestDAO jobRequestDAO;

    @Autowired
    protected OrderRequestDao orderRequestDao;

    @Autowired
    protected ProductionHouseDao productionHouseDao;

    @Autowired
    protected ReviewDao reviewDao;

    @Autowired
    protected PurchaseService purchaseService;

    @Autowired
    protected PurchaseNoticeService purchaseNoticeService;

    @Autowired
    protected ProductService productService;

    @Autowired
    protected EmployeeService employeeService;

    @Autowired
    protected CustomerService customerService;

    @Autowired
    protected ProductionHouseService productionHouseService;

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


            CSVParser categoryCSV = CSVFormat.DEFAULT.withDelimiter(',')
                    .parse(new InputStreamReader(categoriesRes.getInputStream()));
            for (CSVRecord record: categoryCSV){
                insertCategory(record.get(0));
            }

            CSVParser productsCsv = CSVFormat.DEFAULT.withDelimiter(',')
                    .parse(new InputStreamReader(productsRes.getInputStream()));
            for (CSVRecord record : productsCsv) {
                insertProduct(Double.parseDouble(record.get(0)), record.get(1), record.get(2), record.get(3),record.get(4),(record.get(5)));
            }

            CSVParser purchaseNoticesCsv= CSVFormat.DEFAULT.withDelimiter(',')
                    .parse(new InputStreamReader(purchaseNoticesRes.getInputStream()));
            for (CSVRecord record: purchaseNoticesCsv){
                insertPurchaseNotice(LocalDate.parse(record.get(0), DateTimeFormatter.ISO_LOCAL_DATE),
                        Long.parseLong(record.get(1)),Long.parseLong(record.get(2)),record.get(3),record.get(4),
                                Integer.parseInt(record.get(5)));
            }

            CSVParser productionHousesCsv = CSVFormat.DEFAULT.withDelimiter(',')
                    .parse(new InputStreamReader(productionHousesRes.getInputStream()));
            for (CSVRecord record: productionHousesCsv){
                insertProductionHouse(record.get(0));
            }

            CSVParser orderRequestsCsv = CSVFormat.DEFAULT.withDelimiter(',')
                    .parse(new InputStreamReader(orderRequestsRes.getInputStream()));
            for (CSVRecord record: orderRequestsCsv){
                insertOrderRequest(Long.parseLong(record.get(0)),Long.parseLong(record.get(1)),record.get(2),record.get(3),
                        Integer.parseInt(record.get(4)));
            }

            CSVParser errorMessagesCsv = CSVFormat.DEFAULT.withDelimiter(',')
                    .parse(new InputStreamReader(errorMessagesRes.getInputStream()));
            for (CSVRecord record: errorMessagesCsv){
                insertErrorMessageRequest(record.get(0),record.get(1),record.get(2),record.get(3));
            }

            CSVParser faqsCsv = CSVFormat.DEFAULT.withDelimiter(',')
                    .parse(new InputStreamReader(faqsRes.getInputStream()));
            for (CSVRecord record: faqsCsv){
                insertFAQRequest(record.get(0),record.get(1));
            }

            CSVParser jobRequestsCsv = CSVFormat.DEFAULT.withDelimiter(',')
                    .parse(new InputStreamReader(jobRequestsRes.getInputStream()));
            for (CSVRecord record: jobRequestsCsv){
                insertJobRequestRequest(record.get(0),record.get(1),record.get(2),record.get(3),record.get(4),LocalDate.parse(record.get(5), DateTimeFormatter.ISO_LOCAL_DATE));
            }

            CSVParser reviewsCsv = CSVFormat.DEFAULT.withDelimiter(',')
                    .parse(new InputStreamReader(reviewsRes.getInputStream()));
            for (CSVRecord record: reviewsCsv){
                insertReview(Long.valueOf(record.get(0)),record.get(1),record.get(2),Long.parseLong(record.get(3)),record.get(4),record.get(5));
            }

            isInitialized=true;
        }
    }

    private void insertCategory(String category) {
        Category category1 = new Category();
        category1.setCategoryName(category);

        categoriesDao.save(category1);
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

    private void insertProduct(Double price, String brand, String model, String description, String url, String categoryName){
        Product prod=new Product();
        prod.setPrice(price);
        prod.setBrand(brand);
        prod.setModel(model);
        prod.setDescription(description);
        prod.setImageUrl(url);

        Category c= categoriesDao.findCategoryByCategoryName(categoryName);

        if (c!=null) {
            prod.setCategory(c);
        }

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

        purchaseNotice.setWarehouse(warehouse);
        purchaseNotice.setProductBrand(productBrand);
        purchaseNotice.setProductModel(productModel);
        purchaseNotice.setQuantity(quantity);

        purchaseNoticeDao.save(purchaseNotice);

    }

    private void insertOrderRequest(Long productionHouse_id, Long warehouse_id, String productBrand, String productModel, Integer productQuantity) {
        OrderRequest orderRequest = new OrderRequest();

        ProductionHouse productionHouse=productionHouseDao.findById(productionHouse_id).get();
        orderRequest.setProductionHouse(productionHouse);

        Warehouse warehouse=warehouseDao.findById(warehouse_id).get();
        orderRequest.setWarehouse(warehouse);

        orderRequest.setProductBrand(productBrand);
        orderRequest.setProductModel(productModel);
        orderRequest.setProductQuantity(productQuantity);

        orderRequestDao.saveAndFlush(orderRequest);
    }

    private void insertProductionHouse(String name) {
        ProductionHouse productionHouse=new ProductionHouse();

        productionHouse.setName(name);

        productionHouseDao.saveAndFlush(productionHouse);
    }

    private void insertErrorMessageRequest(String title,String description,String username,String email) {
        ErrorMessage errorMessage=new ErrorMessage();

        errorMessage.setTitle(title);
        errorMessage.setDescription(description);
        errorMessage.setUsername(username);
        errorMessage.setEmail(email);

        errorMessageDAO.saveAndFlush(errorMessage);
    }

    private void insertFAQRequest(String title,String description) {
        FAQ faq=new FAQ();

        faq.setTitle(title);
        faq.setDescription(description);

        faqDao.saveAndFlush(faq);
    }

    private void insertJobRequestRequest(String title,String position,String email,String username,String description,LocalDate date) {
        JobRequest jobRequest=new JobRequest();

        jobRequest.setTitle(title);
        jobRequest.setPosition(position);
        jobRequest.setEmail(email);
        jobRequest.setUsername(username);
        jobRequest.setDescription(description);
        jobRequest.setDate(date);

        jobRequestDAO.saveAndFlush(jobRequest);
    }

    private void insertReview(Long rate, String title, String text, Long custId, String brand, String model){

        Review review = new Review();

        review.setRate(rate);
        review.setTitle(title);
        review.setText(text);

        Optional<Customer> c=customerDao.findCustomerById(custId);

        if (c.isPresent()){
            review.setCustomer(c.get());
        }

        review.setBrand(brand);
        review.setModel(model);

        reviewDao.saveAndFlush(review);

    }


}
