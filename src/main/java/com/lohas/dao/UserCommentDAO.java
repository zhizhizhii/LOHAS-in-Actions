package com.lohas.dao;

import com.lohas.model.UserComment;
import org.springframework.data.repository.CrudRepository;

public interface UserCommentDAO extends CrudRepository<UserComment,Integer> {
}
