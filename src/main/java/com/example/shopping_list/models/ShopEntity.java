package com.example.shopping_list.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "shops")
public class ShopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shop_id;
    @Column(name = "shop_name")
    private String shopName;

    @OneToMany(mappedBy = "shop")
    private Set<ProductEntity> products;


    public Long getShop_id() {
        return shop_id;
    }
    public void setShop_id(Long shop_id) {
        this.shop_id = shop_id;
    }
    public String getShop_name() {
        return shopName;
    }
    public void setShop_name(String shop_name) {
        this.shopName = shop_name;
    }
    public Set<ProductEntity> getProducts() {
        return products;
    }
    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }

    
}
