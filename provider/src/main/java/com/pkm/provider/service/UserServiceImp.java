package com.pkm.provider.service;


import com.pkm.provider.dao.UserDao;
import com.pkm.service.object.User;
import com.pkm.service.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
@Service(version = "1.0.0" ,timeout = 2000,interfaceClass = UserService.class)
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;
    public User getUserById(String id){
        return userDao.getUserById(id);
    }
    public User getUserByName(String name){
        return userDao.getUserByName(name);
    }
    public List<User> getAllUser(){
        return userDao.getAllUser();
    }
    public List<User> searchUser(String keyword){
        return userDao.searchUser("%"+keyword+"%");
    }
    public Boolean addUser(User object){
        return userDao.addUser(object);
    }
    public Boolean delUser(String id){
        return userDao.delUser(id);
    }
    public Boolean upUser(User object){
        return userDao.upUser(object);
    }
}
