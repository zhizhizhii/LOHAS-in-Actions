package com.lohas.dao;

import com.lohas.model.Shop;
import org.springframework.data.repository.CrudRepository;

public interface ShopDAO extends CrudRepository<Shop,Integer> {

    Shop findShopByUsername(String userName);
    Shop findShopByShopId(Integer shopId);

}
