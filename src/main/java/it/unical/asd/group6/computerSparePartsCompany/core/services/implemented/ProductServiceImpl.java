package it.unical.asd.group6.computerSparePartsCompany.core.services.implemented;

import it.unical.asd.group6.computerSparePartsCompany.core.exception.product.ProductByBrandAndModelNotFoundException;
import it.unical.asd.group6.computerSparePartsCompany.core.exception.product.ProductByBrandNotFoundException;
import it.unical.asd.group6.computerSparePartsCompany.core.exception.product.ProductByModelNotFoundException;
import it.unical.asd.group6.computerSparePartsCompany.core.exception.product.ProductLessThanACertainPriceNotFoundException;
import it.unical.asd.group6.computerSparePartsCompany.data.dao.ProductDao;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.OrderRequestDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.ProductDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.dto.ReviewDTO;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Category;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Product;
import it.unical.asd.group6.computerSparePartsCompany.core.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ProductDTO> getAllProduct(){
        List<Product> products = productDao.findAll();
        return products.stream().map(p -> modelMapper.map(p, ProductDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getAllProductByBrand(String brand){
        List<Product> productOptional = productDao.findAllByBrand(brand).orElseThrow(() -> new ProductByBrandNotFoundException(brand));
        /*if(!productOptional.isPresent())
            return null;*/
        return productOptional.stream().map(p -> modelMapper.map(p, ProductDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getAllProductByBrandAndModel(String brand, String model){
        List<Product> productOptional = productDao.findAllByBrandAndModel(brand, model).orElseThrow(() -> new ProductByBrandAndModelNotFoundException(brand, model));
        /*if(!productOptional.isPresent())
            return null;*/
        return productOptional.stream().map(p -> modelMapper.map(p, ProductDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getAllProductByPriceIsLessThan(Double price){
        List<Product> productOptional = productDao.findAllByPriceIsLessThan(price).orElseThrow(() -> new ProductLessThanACertainPriceNotFoundException(price));
        /*if (!productOptional.isPresent())
            return null;*/
        return productOptional.stream().map(p -> modelMapper.map(p, ProductDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductsByModel(String model){
        List<Product> productOptional = productDao.findAllByModel(model).orElseThrow(() -> new ProductByModelNotFoundException(model));
        /*if(!productOptional.isPresent())
            return null;*/
        return productOptional.stream().map(p -> modelMapper.map(p, ProductDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String category){
        /*Optional<List<Product>> productOptional = productDao.findAllByCategory(category);
        return productOptional.orElse(null);*/
        return null;
    }

    @Override
    public List<ProductDTO> getProductsInPriceRange(Double p1, Double p2) {
        Optional<List<Product>> products = productDao.findAllByPriceBetween(p1,p2);
        if(!products.isPresent())
            return null;
        return products.get().stream().map(p -> modelMapper.map(p, ProductDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductDistinct() {
        List<Product> products = productDao.findAll().stream().distinct().collect(Collectors.toList());
        if(products.isEmpty()) {
            return null;
        }
        return products.stream().map(p -> modelMapper.map(p, ProductDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductDistinctByCategory(String category) {
        /*List<Product> products = productDao.findAllByCategory(category).get().stream().distinct().collect(Collectors.toList());
        if(products.isEmpty()) {
            return null;
        }
        return products;*/
        return null;
    }

    @Override
    public Boolean addProduct(Product p) {
        Optional<List<Product>> productOptional = productDao.findAllByBrandAndModel(p.getBrand(), p.getModel());
        if (!productOptional.isPresent()){
            productDao.save(p);
            return true;
        }
        else{
            List<Product> products = productOptional.get();
            if(p.equals(products.get(0))){
                productDao.save(p);
                return true;
            }else
                return false;
        }

    }

    @Override
    public List<ProductDTO> getProductByBrandAndModel(String brand, String model) {
        return null;
    }

    @Override
    public Product getProductById(Long id) {

        Optional<Product> product=productDao.findById(id);

        if (!product.isPresent()){
            return null;
        }

        return product.get();
    }

    @Override
    public List<ProductDTO> getAllProductsForAPurchase(Long id) {

        Optional<List<Product>> productsByPurchase = productDao.productsByPurchase(id);

        if (!productsByPurchase.isPresent()){
            return null;
        }

        List<ProductDTO> productDTOS = productsByPurchase.get().stream().map(p -> modelMapper.map(p, ProductDTO.class)).collect(Collectors.toList());
        return productDTOS;
    }

    @Override
    public List<ProductDTO> getAllPurchasedProducts() {
        Optional<List<Product>> products = productDao.findAllByPurchase_IdIsNotNull();
        if (!products.isPresent()){
            return null;
        }
        List<ProductDTO> productDTOS = products.get().stream().map(p -> modelMapper.map(p, ProductDTO.class)).collect(Collectors.toList());
        return productDTOS;
    }

    @Transactional
    public Boolean deleteProduct(String brand, String model){
        productDao.deleteAllByBrandAndModel(brand, model);
        Optional<List<Product>> productOptional = productDao.findAllByBrandAndModel(brand, model);
        return !productOptional.isPresent();
    }

    @Override
    @Transactional
    public void updateProductAll(Long id, Double price, String desc, String url, Category cat){
        productDao.updateProductAll(id, desc, price, url, cat);
    }

    @Override
    @Transactional
    public void updateProductPrice(Long id, Double price){
        productDao.updateProductPrice(id, price);
    }

    @Override
    @Transactional
    public void updateProductDescription(Long id, String desc){
        productDao.updateProductDescription(id, desc);
    }

    @Override
    @Transactional
    public void updateProductUrl(Long id, String url){
        productDao.updateProductURL(id, url);
    }

    @Override
    @Transactional
    public void updateProductCategory(Long id, Category cat){
        productDao.updateProductCategory(id, cat);
    }

    @Override
    public List<Product> distinctProductByCategory(Category category, double min, double max) {
        List<Product> temp = productDao.findAllByCategoryIdAndPriceBetween(category.getId(), min, max);
        return  temp.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<Product> distinctProductByCategoryAndBrandCollection(Category category, Collection<String> brands, double min, double max) {
        List<Product> temp = productDao.findAllByCategoryIdAndBrandInAndPriceBetween(category.getId(), brands, min, max);
        return  temp.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> distinctProductFiltered(
            Collection<Category> categories,
            Collection<String> brands, Collection<String> models, Double min, Double max) {
        List<Product> toDistinct = productDao.findProductByBrandInAndModelInAndPriceBetween(categories,brands,models,min,max)
                .stream().distinct().collect(Collectors.toList());;
        return toDistinct.stream().map(p -> modelMapper.map(p, ProductDTO.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<Product> getById(Long id)
    {
        return productDao.findById(id);
    }

    @Override
    public List<String> getAllBrands() {
        return productDao.getAllBrands();
    }

    @Override
    public List<String> getAllBrandsForCategory(Category category) {
        return productDao.getAllBrandsByCategory(category);
    }

    @Override
    public List<ProductDTO> getProductsByFilters(Category c, String brand, Double min, Double max) {
        List<Product> products =  productDao.findByFilters(c,brand,min,max).stream().distinct().collect(Collectors.toList());
        return  products.stream().map(p -> modelMapper.map(p, ProductDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductByRegex(String s) {
        List<Product> products = productDao.findProductByBrandOrModelOrDescription(s)
                .stream().distinct().collect(Collectors.toList());
        return products.stream().map(p -> modelMapper.map(p, ProductDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getAllEntityProductByBrandAndModel(String brand, String model){
        Optional<List<Product>> productOptional = productDao.findAllByBrandAndModel(brand, model);
        return productOptional.orElse(null);
    }
}
