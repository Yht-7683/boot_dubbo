package com.pkm.provider.dao;

import com.pkm.service.object.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    User getUserById(String id);
    User getUserByName(String name);
    List<User> getAllUser();
    List<User> searchUser(String keyword);
    Boolean addUser(User object);
    Boolean delUser(String id);
    Boolean upUser(User object);
}
