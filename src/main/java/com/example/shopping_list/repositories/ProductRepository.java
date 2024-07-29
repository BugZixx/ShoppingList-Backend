package com.example.shopping_list.repositories;

import com.example.shopping_list.models.ProductEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByShop_ShopNameContainingIgnoreCase(String shop_name);
}