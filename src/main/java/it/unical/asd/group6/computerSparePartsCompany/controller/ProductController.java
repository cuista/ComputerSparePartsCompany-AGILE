package it.unical.asd.group6.computerSparePartsCompany.controller;

import it.unical.asd.group6.computerSparePartsCompany.core.services.CategoryService;
import it.unical.asd.group6.computerSparePartsCompany.core.services.ProductService;
import it.unical.asd.group6.computerSparePartsCompany.core.services.WarehouseService;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.ProductDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Category;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all-products")
    public ResponseEntity<List<ProductDTO>> showAll(){
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("/all-products/brand={brand}")
    public ResponseEntity<List<ProductDTO>> showAllByBrand(@PathVariable("brand") String brand){
        return ResponseEntity.ok(productService.getAllProductByBrand(brand));
    }

    @GetMapping("/all-products/brand={brand}/model={model}")
    public ResponseEntity<List<ProductDTO>> showAllByBrandAndModel(@PathVariable("brand") String brand, @PathVariable("model") String model){
        return ResponseEntity.ok(productService.getAllProductByBrandAndModel(brand, model));
    }

    @GetMapping("/all-products/price={price}")
    public ResponseEntity<List<ProductDTO>> showAllByByPriceIsLessThan(@PathVariable("price") Double price){
        return ResponseEntity.ok(productService.getAllProductByPriceIsLessThan(price));
    }

    @GetMapping("/all-products/mod={model}")
    public ResponseEntity<List<ProductDTO>> showAllByModel(@PathVariable("model") String model){
        return ResponseEntity.ok(productService.getProductsByModel(model));
    }

    @GetMapping("/all-products/categ={category}")
    public ResponseEntity<List<ProductDTO>> showAllByCategory(@PathVariable("category") String category) {
        return ResponseEntity.ok(productService.getProductsByCategory(category));
    }

    @GetMapping("/all-products/min={min}&&max={max}")
    public ResponseEntity<List<ProductDTO>> showProductsByPriceRange(
            @PathVariable("min") String min, @PathVariable("max") String max) {
        return ResponseEntity.ok(productService.getProductsInPriceRange(Double.valueOf(min),Double.valueOf(max)));
    }

    @GetMapping("/all-products/distinct")
    public ResponseEntity<List<ProductDTO>> getDistinctProducts() {
        return ResponseEntity.ok(productService.getProductDistinct());
    }

    @GetMapping("/all-products/distinct/{category}")
    public ResponseEntity<List<ProductDTO>> getDistinctProducts(@PathVariable String category) {
        return ResponseEntity.ok(productService.getProductsByCategory(category));
    }

    @PostMapping("/add-product")
    public ResponseEntity<Boolean> add(
            @RequestParam String price, @RequestParam String brand,
            @RequestParam String model, @RequestParam String description, @RequestParam String url,
            @RequestParam String idWarehouse, @RequestParam String categoryName, @RequestParam String idOrder) {
        Product p = new Product();
        p.setPrice(Double.parseDouble(price));
        p.setBrand(brand);
        p.setModel(model);
        p.setDescription(description);
        p.setImageUrl(url);
        Warehouse wh = warehouseService.getWarehouseById(Long.parseLong(idWarehouse));
        p.setWarehouse(wh);
        Category category = categoryService.getCategoryByName(categoryName);
        p.setCategory(category);
        return ResponseEntity.ok(productService.addProduct(p));
    }

    @PostMapping("/del-product")
    public ResponseEntity<Boolean> del(@RequestParam String brand, @RequestParam String model) {
        return ResponseEntity.ok(productService.deleteProduct(brand, model));
    }

    @PostMapping("/update-product-by-all")
    public ResponseEntity<Boolean> updateAll(
            @RequestParam String brand, @RequestParam String model, @RequestParam String price,
            @RequestParam String description, @RequestParam String url, @RequestParam String categoryName) {
        List<Product> temp = productService.getAllEntityProductByBrandAndModel(brand, model);
        Category cat = categoryService.getCategoryByName(categoryName);
        if(temp == null) {
            return  ResponseEntity.ok(false);
        }
        for(Product p: temp) {
            if (p.getPurchase() == null){
                productService.updateProductAll(p.getId(), Double.parseDouble(price), description, url, cat);
            }
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping("/update-product-by-price")
    public ResponseEntity<Boolean> updatePrice(
            @RequestParam String brand, @RequestParam String model, @RequestParam Double price) {
        List<Product> temp = productService.getAllEntityProductByBrandAndModel(brand, model);
        if(temp == null) {
            return  ResponseEntity.ok(false);
        }
        for(Product p: temp) {
            if (p.getPurchase() == null) {
                productService.updateProductPrice(p.getId(), price);
            }
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping("/update-product-by-description")
    public ResponseEntity<Boolean> updateDescription(
            @RequestParam String brand, @RequestParam String model, @RequestParam String description) {
        List<Product> temp = productService.getAllEntityProductByBrandAndModel(brand, model);
        if(temp == null) {
            return  ResponseEntity.ok(false);
        }
        for(Product p: temp) {
            if (p.getPurchase() == null) {
               productService.updateProductDescription(p.getId(), description);
            }
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping("/update-product-by-url")
    public ResponseEntity<Boolean> updateUrl(
            @RequestParam String brand, @RequestParam String model, @RequestParam String url) {
        List<Product> temp = productService.getAllEntityProductByBrandAndModel(brand, model);
        if(temp == null) {
            return  ResponseEntity.ok(false);
        }
        for(Product p: temp) {
            if (p.getPurchase() == null) {
                productService.updateProductUrl(p.getId(), url);
            }
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping("/update-product-by-category")
    public ResponseEntity<Boolean> updateCategory(
            @RequestParam String brand, @RequestParam String model, @RequestParam String category) {
        List<Product> temp = productService.getAllEntityProductByBrandAndModel(brand, model);
        Category cat = categoryService.getCategoryByName(category);
        if(temp == null) {
            return  ResponseEntity.ok(false);
        }
        for(Product p: temp) {
            if (p.getPurchase() == null) {
                productService.updateProductCategory(p.getId(), cat);
            }
        }
        return ResponseEntity.ok(true);
    }

    @GetMapping("/filter-product-by-vars")
    public ResponseEntity<List<ProductDTO>> filterProducts(
            @RequestParam(required = false) List<String> category, @RequestParam(required = false) List<String> brands,
            @RequestParam(required = false) List<String> models,
            @RequestParam String min, @RequestParam String max) {
        //return null;

        List<Category> my_categories = null;
        if(category != null) {
            my_categories = categoryService.getCategoryByList(category);
        }
        return ResponseEntity.ok(productService.distinctProductFiltered(my_categories,brands,models,Double.valueOf(min),Double.valueOf(max)));
        /*Category my_category = categoryService.getCategoryByName(category);
        List<Product> temp = productService.getAllProduct();
        if (brands == null) {
            return ResponseEntity.ok(productService.distinctProductByCategory(my_category, Double.parseDouble(min),Double.parseDouble(max)));
        }
        return ResponseEntity.ok(productService.distinctProductByCategoryAndBrandCollection(my_category, brands, Double.parseDouble(min),Double.parseDouble(max)));
        */
    }

    @GetMapping("/get-brands")
    public ResponseEntity<List<String>> getBrands() {
        return ResponseEntity.ok(productService.getAllBrands());
    }

    @GetMapping("/get-brands-by-category")
    public ResponseEntity<List<String>> getBrandsByCategory(@RequestParam String category) {
        Category c = categoryService.getCategoryByName(category);
        return ResponseEntity.ok(productService.getAllBrandsForCategory(c));
    }

    @GetMapping("/get-products-by-filters")
    public ResponseEntity<List<ProductDTO>> getByFilters(@RequestParam(required = false) String category,@RequestParam(required = false) String brand, @RequestParam(required = false) String min, @RequestParam(required = false) String max) {
        Category c = null;
        if(categoryService.getCategoryByName(category) != null)
            c = categoryService.getCategoryByName(category);
        Double minP = null;
        if(min != null)
            minP = Double.parseDouble(min);
        Double maxP = null;
        if(max != null)
            maxP = Double.parseDouble(max);
        return ResponseEntity.ok(productService.getProductsByFilters(c,brand,minP,maxP));
    }

    @GetMapping("/get-product-by-regex")
    public ResponseEntity<List<ProductDTO>> productsByRegex (@RequestParam String s) {
        String regex = "%" + s.toLowerCase() + "%";
        return ResponseEntity.ok(productService.getProductByRegex(regex));
    }
}
