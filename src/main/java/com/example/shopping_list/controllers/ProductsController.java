package com.example.shopping_list.controllers;

import java.util.List;

import com.example.shopping_list.models.ProductEntity;
import com.example.shopping_list.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductEntity> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getById(@PathVariable Long id) {
        ProductEntity product = productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return ResponseEntity.ok(product);
    }

    @GetMapping("/shop")
    public List<ProductEntity> getProductsByShopName(@RequestParam String shop_name) {
        return productService.getProductsByShopName(shop_name);
    }

    @PostMapping
    public ProductEntity create(@RequestBody ProductEntity product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long id, @RequestBody ProductEntity productDetails) {
        ProductEntity updatedProduct = productService.updateProduct(id, productDetails);
        return ResponseEntity.ok(updatedProduct);
    }

    @PutMapping()
    public ResponseEntity<List<ProductEntity>> updateProducts(@RequestBody List<ProductEntity> products) {
        List<ProductEntity> updatedProducts = productService.updateProducts(products);
        return ResponseEntity.ok(updatedProducts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
