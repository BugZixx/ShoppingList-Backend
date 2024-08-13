package com.example.shopping_list.services;

import java.util.List;
import java.util.Optional;

import com.example.shopping_list.models.ProductDTO;
import com.example.shopping_list.models.ProductEntity;
import com.example.shopping_list.models.ShopEntity;
import com.example.shopping_list.repositories.ProductRepository;
import com.example.shopping_list.repositories.ShopRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShopRepository shopRepository;

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<ProductEntity> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<ProductEntity> getProductsByShopName(String shop_name) {
        return productRepository.findByShop_ShopNameContainingIgnoreCase(shop_name);
    }

    public ProductEntity createProduct(ProductDTO productDTO) {
        ProductEntity product = new ProductEntity();
        product.setProduct_name(productDTO.getProduct_name());
        product.setChecked(productDTO.isChecked());
        product.setRow_num(productDTO.getRow_num());

        if (productDTO.getShop_id() != null) {
            Optional<ShopEntity> shop = shopRepository.findById(productDTO.getShop_id());
            shop.ifPresent(product::setShop);
        }

        return productRepository.save(product);
    }

    public ProductEntity updateProduct(Long id, ProductDTO productDTO) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setProduct_name(productDTO.getProduct_name());
        product.setChecked(productDTO.isChecked());
        product.setRow_num(productDTO.getRow_num());

        if (productDTO.getShop_id() != null) {
            Optional<ShopEntity> shop = shopRepository.findById(productDTO.getShop_id());
            shop.ifPresent(product::setShop);
        }

        return productRepository.save(product);
    }

    public List<ProductEntity> updateProducts(List<ProductEntity> products) {
        return productRepository.saveAll(products);
    }

    public void deleteProduct(Long id) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
    }

}
