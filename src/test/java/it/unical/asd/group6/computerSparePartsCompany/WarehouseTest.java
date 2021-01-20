package it.unical.asd.group6.computerSparePartsCompany;

import it.unical.asd.group6.computerSparePartsCompany.data.entities.Warehouse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WarehouseTest extends AbstractComputerSparePartsCompanyTest{

    @Test
    public void testFindWarehouseById_OK(){

        Optional<Warehouse> warehouse = warehouseDao.findWarehouseById(21L);

        assert warehouse.isPresent();
        assert warehouse.get().getCity().equals("Siem Reap");
        assert warehouse.get().getRegion().equals("Bahamas");
    }

    @Test
    public void testFindAllByOpeningHoursBetween_OK(){

        List<Warehouse> warehouses= warehouseDao.findAllByOpeningHours("4").get();

        assert(warehouses!=null);
        assert(!warehouses.isEmpty());
        assert(warehouses.size()==1);
        assert(warehouses.get(0).getCity().equals("Mandurah"));
    }

    @Test
    public void testFindAllByRegion_OK(){
        List<Warehouse> warehouses= warehouseDao.findAllByRegion("Faroe Islands").get();

        assert(warehouses!=null);
        assert(!warehouses.isEmpty());
        assert(warehouses.size()==1);
        assert(warehouses.get(0).getCity().equals("Birkirkara"));
    }

    @Test
    public void testFindAllByCity_OK(){
        List<Warehouse> warehouses=warehouseDao.findAllByCity("Charlotte").get();

        assert(warehouses!=null);
        assert(!warehouses.isEmpty());
        assert(warehouses.size()==1);
        assert(warehouses.get(0).getRegion().equals("Angola"));
    }

}
