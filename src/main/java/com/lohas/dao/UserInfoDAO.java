package com.lohas.dao;

import com.lohas.model.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoDAO extends CrudRepository<UserInfo,Integer> {

    UserInfo getUserInfoByUserId(Integer userId);

}
