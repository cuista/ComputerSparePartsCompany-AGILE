package it.unical.asd.group6.computerSparePartsCompany;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.OrderRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRequestTest extends AbstractComputerSparePartsCompanyTest{

    /*
    Test DAO
    */
    @Test
    public void testFindAllByProductionHouse_OK(){
        Optional<List<OrderRequest>> orderRequests=orderRequestDao.findAllByProductionHouse(productionHouseDao.findByName("Intel").get());

        assert(orderRequests.get().size()==2);
    }

    @Test
    public void testFindAllByWarehouse_OK(){
        Optional<List<OrderRequest>> orderRequests=orderRequestDao.findAllByWarehouse(warehouseDao.findById(21L).get());

        assert(orderRequests.get().size()==2);
    }

    @Test
    public void testFindAllByProductionHouseAndWarehouse_OK(){

        Optional<List<OrderRequest>> orderRequests=orderRequestDao.findAllByProductionHouseAndWarehouse(productionHouseDao.findByName("Intel").get(),warehouseDao.findById(23L).get());

        assert(orderRequests.get().size()==1);
    }
}
