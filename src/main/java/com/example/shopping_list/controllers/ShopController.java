package com.example.shopping_list.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping_list.models.ShopEntity;
import com.example.shopping_list.services.ShopService;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping
    public List<ShopEntity> getAll() {
        return shopService.getAllShops();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopEntity> getById(@PathVariable Long id) {
        ShopEntity shop = shopService.getShopById(id).orElseThrow(() -> new RuntimeException("Shop not found"));
        return ResponseEntity.ok(shop);
    }

    @PostMapping
    public ShopEntity create(@RequestBody ShopEntity shop) {
        return shopService.createShop(shop);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShopEntity> updateShop(@PathVariable Long id, @RequestBody ShopEntity shopDetails) {
        ShopEntity updatedShop = shopService.updateShop(id, shopDetails);
        return ResponseEntity.ok(updatedShop);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShop(@PathVariable Long id){
        shopService.deleteShop(id);
        return ResponseEntity.noContent().build();
    }

}
