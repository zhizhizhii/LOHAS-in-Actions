package com.lohas.dao;

import com.lohas.model.ForsaleProduct;
import com.lohas.model.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ForsaleProductDAO  extends CrudRepository<ForsaleProduct,Integer>{
    ForsaleProduct findByProductId(Integer productId);
    Page<ForsaleProduct> findAllByShop(Shop shop, Pageable pageable);
}
