package com.lohas.dao;

import com.lohas.model.Shop;
import com.lohas.model.ShopAnnouncement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Page;

public interface ShopAnnouncementDAO extends CrudRepository<ShopAnnouncement,Integer> {

    ShopAnnouncement findShopAnnouncementByAnnouncementId(Integer announcementId);
    Page<ShopAnnouncement> findAllByShop(Shop shop);
}
