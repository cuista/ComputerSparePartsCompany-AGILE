package it.unical.asd.group6.computerSparePartsCompany;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Purchase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PurchaseTest extends AbstractComputerSparePartsCompanyTest{

    /*
    Test Service a seguire
    */
    @Test
    public void TestAddNewPurchase() {
        Purchase purchase = new Purchase();
        purchase.setDate(LocalDate.of(1997, Month.JULY,4));
        purchase.setTotalPrice(487.0);
        assert(purchaseService.registerNewPurchase(purchase));
    }

    /*
    Test DAO a seguire
     */
    @Test
    public void testFindById_OK(){
        Optional<List<Purchase>> purchases=purchaseDao.findAllByDateBetween(LocalDate.of(2006,01,01)
                , LocalDate.of(2016,01,01));

        assert(purchases.get()!=null);
        assert(purchases.get().size()==10);

    }

    @Test
    public void testFindAllByCustomerId_OK(){

        Optional<List<Purchase>> purchases = purchaseDao.findAllByCustomerId(11L);

        assert(purchases.get()!=null);
        assert(purchases.get().size()==2);
    }

    @Test
    public void testFindAllByTotalPriceBetween(){

        Optional<List<Purchase>> purchases = purchaseDao.findAllByTotalPriceBetween(300.00,600.00);

        assert(purchases.get()!=null);
        assert(purchases.get().size()==5);
    }
}
