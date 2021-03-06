package com.nwafu.bingo.dao;

import com.nwafu.bingo.entity.User;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.nwafu.bingo.utils.Search;



import java.util.List;

/**
 * Date: 2020/8/20
 * Description: optional describe the class
 */
@Repository
public interface UserDao {

    int add(User user) throws Exception;
    List<User> getByName(String name) throws Exception;
    User getById(Integer id) throws Exception;
    List<User> getAll() throws Exception;
    void update(User user) throws Exception;

    List<User> getUserPage(@Param("current_index") Integer current_index, @Param("size") Integer size) throws Exception;

    Integer getUserCount(Search search);
}
