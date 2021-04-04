package com.lohas.dao;

import com.lohas.model.Shop;
import com.lohas.model.User;
import com.lohas.model.UserCollect;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;

public interface UserCollectDAO extends CrudRepository<UserCollect,Integer> {

    UserCollect findByUserAndShop(User user, Shop shop);
    Page<UserCollect> findAllByUser(User user, Pageable pageable);
}
