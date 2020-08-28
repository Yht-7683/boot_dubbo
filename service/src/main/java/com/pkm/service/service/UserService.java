package com.pkm.service.service;


import com.pkm.service.object.User;


import java.util.List;

public interface UserService {


    User getUserById(String id);
    User getUserByName(String name);
    List<User> getAllUser();
    List<User> searchUser(String keyword);
    Boolean addUser(User object);
    Boolean delUser(String id);
    Boolean upUser(User object);
}
