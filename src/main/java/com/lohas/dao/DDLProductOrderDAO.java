package com.lohas.dao;

import com.lohas.dao.inter.GreenPointInterface;
import com.lohas.dao.inter.MysteryBoxOrderOfShopInterface;
import com.lohas.dao.inter.MysteryBoxOrderOfUserInterface;
import com.lohas.model.DDLProductOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DDLProductOrderDAO extends CrudRepository<DDLProductOrder,Integer> {
    DDLProductOrder findByOrderId(Integer orderId);

    @Query(value="select user_id,order_id,user_name,avatar,order_time,is_taken,product_id, product_pic, product_name " +
            "from user_info natural join ddl_product_order natural join ddl_product " +
            "where shop_id = ?",
            countQuery = "select\n" +
                    "        count(*) \n" +
                    "    from user_info natural join ddl_product_order natural join ddl_product" +
                    "    where\n" +
                    "        shop_id = ?"
            ,nativeQuery = true)
    Page<MysteryBoxOrderOfShopInterface> findDDLProductOrderByShop(Integer shopId, Pageable pageable);

    @Query(value="select shop_id,order_id,shop_name,avatar,is_taken,order_time,product_id, product_pic, product_name " +
            "from shop_info natural join ddl_product_order natural join ddl_product " +
            "where user_id = ?",
            countQuery = "select\n" +
                    "        count(*) \n" +
                    "    from shop_info natural join ddl_product_order natural join ddl_product" +
                    "    where\n" +
                    "        user_id = ?"
            ,nativeQuery = true)
    Page<MysteryBoxOrderOfUserInterface> findDDLProductOrderByUser(Integer userId, Pageable pageable);

    @Query(value="select count(*) " +
            "from ddl_product_order " +
            "where DateDiff(order_time,now())=0 " +
            "and user_id = ? "
            ,nativeQuery = true)
    Integer findOrderCountByUserAndDate(Integer userId);

    @Query(value="select count(*) as point, date_format(order_time,'%Y-%m-%d') as order_date " +
            "from ddl_product_order " +
            "where DateDiff(order_time,now())<=7 " +
            "and user_id = ? " +
            "group by date_format(order_time,'%Y-%m-%d') "
            ,nativeQuery = true)
    List<GreenPointInterface> getGreenPointOfUser(Integer userId);

    @Query(value="select count(*) " +
            "from ddl_product_order " +
            "where user_id = ? "
            ,nativeQuery = true)
    Integer getTotalPoint(Integer userId);
}
