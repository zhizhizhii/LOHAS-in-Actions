package com.lohas.dao;

import com.lohas.model.Shop;
import com.lohas.model.ShopInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ShopInfoDAO extends CrudRepository<ShopInfo,Integer> {
    Page<ShopInfo> findAll(Pageable pageable);
    ShopInfo findShopInfoByShop(Shop shop);

    @Query(value="select * from shop_info s join user_collect c on c.shop_id = s.shop_id " +
            "where user_id =?"
            ,nativeQuery = true)
    Page<ShopInfo> findCollectInfo(Integer userId,Pageable pageable);


}
