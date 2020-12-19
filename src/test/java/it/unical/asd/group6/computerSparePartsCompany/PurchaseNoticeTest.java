package it.unical.asd.group6.computerSparePartsCompany;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.PurchaseNotice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PurchaseNoticeTest extends AbstractComputerSparePartsCompanyTest {

    @Test
    public void testFindAllByWarehouseId(){

        Optional<List<PurchaseNotice>> purchaseNotices=purchaseNoticeDao.findAllByWarehouseId(25L);

        assert(purchaseNotices.get()!=null);
        assert(purchaseNotices.get().size()==6);


    }

    @Test
    public void testFindAllByCustomerId(){
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

}
