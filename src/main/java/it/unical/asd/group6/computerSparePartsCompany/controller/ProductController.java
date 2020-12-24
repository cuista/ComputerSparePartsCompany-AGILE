package it.unical.asd.group6.computerSparePartsCompany.controller;

import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.CategoryServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.WarehouseServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Category;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.OrderRequest;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import it.unical.asd.group6.computerSparePartsCompany.core.services.implemented.ProductServiceImpl;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    WarehouseServiceImpl warehouseService;

    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping("/all-products")
    public ResponseEntity<List<Product>> showAll(){
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("/all-products/brand={brand}")
    public ResponseEntity<List<Product>> showAllByBrand(@PathVariable("brand") String brand){
        return ResponseEntity.ok(productService.getAllProductByBrand(brand));
    }

    @GetMapping("/all-products/brand={brand}/model={model}")
    public ResponseEntity<List<Product>> showAllByBrandAndModel(@PathVariable("brand") String brand, @PathVariable("model") String model){
        return ResponseEntity.ok(productService.getAllProductByBrandAndModel(brand, model));
    }

    @GetMapping("/all-products/price={price}")
    public ResponseEntity<List<Product>> showAllByByPriceIsLessThan(@PathVariable("price") Double price){
        return ResponseEntity.ok(productService.getAllProductByPriceIsLessThan(price));
    }

    @GetMapping("/all-products/mod={model}")
    public ResponseEntity<List<Product>> showAllByModel(@PathVariable("model") String model){
        return ResponseEntity.ok(productService.getProductsByModel(model));
    }

    @GetMapping("/all-products/categ={category}")
    public ResponseEntity<List<Product>> showAllByCategory(@PathVariable("category") String category) {
        return ResponseEntity.ok(productService.getProductsByCategory(category));
    }

    @GetMapping("/all-products/min={min}&&max={max}")
    public ResponseEntity<List<Product>> showProductsByPriceRange(
            @PathVariable("min") Double min, @PathVariable("max") Double max) {
        return ResponseEntity.ok(productService.getProductsInPriceRange(min,max));
    }

    @GetMapping("/all-products/distinct")
    public ResponseEntity<List<Product>> getDistinctProducts() {
        return ResponseEntity.ok(productService.getProductDistinct());
    }

    @GetMapping("/all-products/distinct/{category}")
    public ResponseEntity<List<Product>> getDistinctProducts(@PathVariable String category) {
        return ResponseEntity.ok(productService.getProductsByCategory(category));
    }

    @PostMapping("/add-product")
    public ResponseEntity<Boolean> add(
            @RequestParam Double price, @RequestParam String brand,
            @RequestParam String model, @RequestParam String description, @RequestParam String url,
            @RequestParam Long idWarehouse, @RequestParam Long idCategory) {
        Product p = new Product();
        p.setPrice(price);
        p.setBrand(brand);
        p.setModel(model);
        p.setDescription(description);
        p.setImageUrl(url);
        Warehouse wh = warehouseService.getWarehouseById(idWarehouse);
        p.setWarehouse(wh);
        Category category = categoryService.getCategoryById(idCategory);
        p.setCategory(category);
        return ResponseEntity.ok(productService.addProduct(p));
    }

    @PostMapping("/del-product")
    public ResponseEntity<Boolean> del(@RequestParam String brand, @RequestParam String model) {
        return ResponseEntity.ok(productService.deleteProduct(brand, model));
    }

    @PostMapping("/update-product-by-all")
    public ResponseEntity<Boolean> updatePrice(
            @RequestParam String brand, @RequestParam String model, @RequestParam Double price,
            @RequestParam String description, @RequestParam String url, @RequestParam Long idCategory) {
        List<Product> temp = productService.getAllProductByBrandAndModel(brand, model);
        if(temp == null) {
            return  ResponseEntity.ok(false);
        }
        productService.deleteProduct(brand,model);
        for(Product p: temp) {
            p.setPrice(price);
            p.setDescription(description);
            p.setImageUrl(url);
            p.setCategory(categoryService.getCategoryById(idCategory));
            productService.addProduct(p);
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping("/update-product-by-price")
    public ResponseEntity<Boolean> updatePrice(
            @RequestParam String brand, @RequestParam String model, @RequestParam Double price) {
        List<Product> temp = productService.getAllProductByBrandAndModel(brand, model);
        if(temp == null) {
            return  ResponseEntity.ok(false);
        }
        productService.deleteProduct(brand,model);
        for(Product p: temp) {
            p.setPrice(price);
            productService.addProduct(p);
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping("/update-product-by-description")
    public ResponseEntity<Boolean> updateDescription(
            @RequestParam String brand, @RequestParam String model, @RequestParam String description) {
        List<Product> temp = productService.getAllProductByBrandAndModel(brand, model);
        if(temp == null) {
            return  ResponseEntity.ok(false);
        }
        productService.deleteProduct(brand,model);
        for(Product p: temp) {
            p.setDescription(description);
            productService.addProduct(p);
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping("/update-product-by-url")
    public ResponseEntity<Boolean> updateUrl(
            @RequestParam String brand, @RequestParam String model, @RequestParam String url) {
        List<Product> temp = productService.getAllProductByBrandAndModel(brand, model);
        if(temp == null) {
            return  ResponseEntity.ok(false);
        }
        productService.deleteProduct(brand,model);
        for(Product p: temp) {
            p.setImageUrl(url);
            productService.addProduct(p);
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping("/update-product-by-category")
    public ResponseEntity<Boolean> updateUrl(
            @RequestParam String brand, @RequestParam String model, @RequestParam Long idCategory) {
        List<Product> temp = productService.getAllProductByBrandAndModel(brand, model);
        if(temp == null) {
            return  ResponseEntity.ok(false);
        }
        productService.deleteProduct(brand,model);
        for(Product p: temp) {
            p.setCategory(categoryService.getCategoryById(idCategory));
            productService.addProduct(p);
        }
        return ResponseEntity.ok(true);
    }
}
