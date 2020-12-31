package it.unical.asd.group6.computerSparePartsCompany;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.ProductionHouse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductionHouseTest extends AbstractComputerSparePartsCompanyTest{


    /*
    Test DAO
     */
    @Test
    public void testFindByName_OK(){
        Optional<ProductionHouse> productionHouse=productionHouseDao.findByName("Intel");

        assert(productionHouse.get().getName().equals("Intel"));
    }

}
