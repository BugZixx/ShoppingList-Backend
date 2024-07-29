package com.example.shopping_list.services;

import java.util.List;
import java.util.Optional;

import com.example.shopping_list.models.ProductEntity;
import com.example.shopping_list.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<ProductEntity> getProductById(Long id){
        return productRepository.findById(id);
    }

    public List<ProductEntity> getProductsByShopName(String shop_name){
        return productRepository.findByShop_ShopNameContainingIgnoreCase(shop_name);
    }

    public ProductEntity createProduct(ProductEntity product){
        return productRepository.save(product);
    }

    public ProductEntity updateProduct(Long id, ProductEntity productDetails) {
        ProductEntity product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setProduct_name(productDetails.getProduct_name());
        product.setChecked(productDetails.isChecked());
        product.setRow_num(productDetails.getRow_num());
        product.setShop(productDetails.getShop());
        return productRepository.save(product);
    }

    public List<ProductEntity> updateProducts(List<ProductEntity> products) {
        return productRepository.saveAll(products);
    }

    public void deleteProduct(Long id) {
        ProductEntity product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
    }

    
}
