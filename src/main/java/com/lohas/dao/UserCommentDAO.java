package com.lohas.dao;

import com.lohas.dao.inter.CommentforUserInterface;
import com.lohas.dao.inter.UserCommentInterface;
import com.lohas.model.Shop;
import com.lohas.model.UserComment;
import com.lohas.view.CommentItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface UserCommentDAO extends CrudRepository<UserComment,Integer> {

    UserComment findByCommentId(Integer commentId);

    @Query(value="select u.user_id user_id,comment_id,user_name,avatar,content,comment_time " +
            "from user_info as u join user_comment as c on u.user_id = c.user_id " +
            "where shop_id = ?",
            countQuery = "select\n" +
                    "        count(*) \n" +
                    "    from\n" +
                    "        user_info as u \n" +
                    "    join\n" +
                    "        user_comment as c \n" +
                    "            on u.user_id = c.user_id \n" +
                    "    where\n" +
                    "        shop_id = ?"
            ,nativeQuery = true)
    Page<UserCommentInterface> findCommentByShop(Integer shopId, Pageable pageable);

    @Query(value="select s.shop_id shop_id,comment_id,shop_name,avatar,content,comment_time " +
            "from shop_info as s join user_comment as c on s.shop_id = c.shop_id " +
            "where user_id = ?",
            countQuery = "select\n" +
                    "        count(*) \n" +
                    "    from\n" +
                    "        user_info as u \n" +
                    "    join\n" +
                    "        user_comment as c \n" +
                    "            on s.shop_id = c.shop_id \n" +
                    "    where\n" +
                    "        user_id = ?"
            ,nativeQuery = true)
    Page<CommentforUserInterface> findCommentByUser(Integer userId, Pageable pageable);
}
