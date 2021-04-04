package com.lohas.dao;

import com.lohas.model.DDLProduct;
import com.lohas.model.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface DDLProductDAO extends CrudRepository<DDLProduct,Integer> {
    DDLProduct findByProductId(Integer productId);
    Page<DDLProduct> findAllByShop(Shop shop, Pageable pageable);
}
