package com.lohas.dao;

import com.lohas.model.Shop;
import com.lohas.model.User;
import com.lohas.model.UserComment;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;

public interface UserCommentDAO extends CrudRepository<UserComment,Integer> {

    UserComment findByCommentId(Integer commentId);

    Page<UserComment> findAllByShop(Shop shop, Pageable pageable);

    Page<UserComment> findAllByUser(User user, Pageable pageable);
}
