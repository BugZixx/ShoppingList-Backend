package com.example.shopping_list.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopping_list.models.ShopEntity;
import com.example.shopping_list.repositories.ShopRepository;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public List<ShopEntity> getAllShops() {
        return shopRepository.findAll();
    }

    public Optional<ShopEntity> getShopById(Long id) {
        return shopRepository.findById(id);
    }

    public ShopEntity createShop(ShopEntity shop) {
        return shopRepository.save(shop);
    }

    public ShopEntity updateShop(Long id, ShopEntity shopDetails) {
        ShopEntity shop = shopRepository.findById(id).orElseThrow(() -> new RuntimeException("Shop not found"));
        shop.setShop_name(shopDetails.getShop_name());
        return shopRepository.save(shop);
    }

    public void deleteShop(Long id) {
        ShopEntity shop = shopRepository.findById(id).orElseThrow(() -> new RuntimeException("Shop not found"));
        shopRepository.delete(shop);
    }

}
