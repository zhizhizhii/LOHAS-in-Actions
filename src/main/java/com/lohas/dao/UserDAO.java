package com.lohas.dao;

import com.lohas.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User,Integer> {

    User findUserByOpenId(String openId);
}
