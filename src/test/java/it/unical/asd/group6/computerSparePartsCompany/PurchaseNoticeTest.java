package it.unical.asd.group6.computerSparePartsCompany;

import it.unical.asd.group6.computerSparePartsCompany.data.dto.PurchaseNoticeDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.PurchaseNotice;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PurchaseNoticeTest extends AbstractComputerSparePartsCompanyTest {

    /*
    Test service a seguire
     */
    @Test
    public void testGetView_OK() {
        for(PurchaseNoticeDTO purchaseNotice : purchaseNoticeService.getView()) {
            System.out.println(purchaseNotice.toString());
        }
        assert(!purchaseNoticeService.getView().isEmpty());
    }

    /*
    Test Dao a seguire
     */
    @Test
    public void testFindAllByWarehouseId_OK(){

        Optional<List<PurchaseNotice>> purchaseNotices=purchaseNoticeDao.findAllByWarehouseId(25L);

        assert(purchaseNotices.get()!=null);
        assert(purchaseNotices.get().size()==6);


    }

    @Test
    public void testFindAllByCustomerId_OK(){
        Optional<List<PurchaseNotice>> purchaseNotices=purchaseNoticeDao.findAllByCustomerId(20L);

        assert(purchaseNotices!=null);
        assert(purchaseNotices.get().size()==4);

    }


    @Test
    public void testFindAllByQuantityGreaterThan_OK(){

        List<PurchaseNotice> purchaseNotices = purchaseNoticeDao.findAllByQuantityGreaterThan(40).get();

        assert(purchaseNotices!=null);
        assert(purchaseNotices.size()==18);

    }

    @Test
    public void testFindAll_OK(){

        List<PurchaseNotice> purchaseNotices = purchaseNoticeDao.findAll();

        System.out.println(purchaseNotices.size());

        assert purchaseNotices.size()==25;

    }

    @Test
    public void testFindAllByCustomer_OK(){

        Optional<Customer> c=customerDao.findCustomerById(20L);

        List<PurchaseNotice> purchaseNotices=purchaseNoticeDao.findAllByCustomer(c.get());

        assert purchaseNotices.size()==4;

    }


    @Test
    public void testGetByFilters_OK(){

        LocalDate date = LocalDate.of(2020,02,03);

        List<PurchaseNotice> purchaseNotice = purchaseNoticeDao.getByFilters("Arlina",date);

        assert !purchaseNotice.isEmpty();
        PurchaseNotice pn1=purchaseNotice.get(0);
        assert pn1.getId().equals(96L);

    }

}
