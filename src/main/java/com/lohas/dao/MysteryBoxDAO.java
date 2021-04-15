package com.lohas.dao;

import com.lohas.model.MysteryBox;
import com.lohas.model.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface MysteryBoxDAO extends CrudRepository<MysteryBox,Integer> {
    MysteryBox findByProductId(Integer productId);
    Page<MysteryBox> findAllByShop(Shop shop, Pageable pageable);
}
