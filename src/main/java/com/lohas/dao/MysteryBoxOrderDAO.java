package com.lohas.dao;

import com.lohas.dao.inter.MysteryBoxOrderOfShopInterface;
import com.lohas.dao.inter.MysteryBoxOrderOfUserInterface;
import com.lohas.model.MysteryBoxOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MysteryBoxOrderDAO extends CrudRepository<MysteryBoxOrder,Integer> {
    MysteryBoxOrder findByOrderId(Integer orderId);

    @Query(value="select user_id,order_id,user_name,avatar,order_time,is_taken,product_id, product_pic, product_name " +
            "from user_info natural join mystery_box_order natural join mystery_box " +
            "where shop_id = ?",
            countQuery = "select\n" +
                    "        count(*) \n" +
                    "    from user_info natural join mystery_box_order natural join mystery_box" +
                    "    where\n" +
                    "        shop_id = ?"
            ,nativeQuery = true)
    Page<MysteryBoxOrderOfShopInterface> findMysteryBoxOrderByShop(Integer shopId, Pageable pageable);

    @Query(value="select shop_id,order_id,shop_name,avatar,is_taken,order_time,product_id, product_pic, product_name " +
            "from shop_info natural join mystery_box_order natural join mystery_box " +
            "where user_id = ?",
            countQuery = "select\n" +
                    "        count(*) \n" +
                    "    from shop_info natural join mystery_box_order natural join mystery_box" +
                    "    where\n" +
                    "        user_id = ?"
            ,nativeQuery = true)
    Page<MysteryBoxOrderOfUserInterface> findMysteryBoxOrderByUser(Integer userId, Pageable pageable);

    @Query(value="select count(*) " +
            "from mystery_box_order " +
            "where DateDiff(order_time,now())=0 " +
            "and user_id = ? "
            ,nativeQuery = true)
    Integer findOrderCountByUserAndDate(Integer userId);
}
