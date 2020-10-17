package com.crud.fullbuild.service;

import com.crud.fullbuild.dao.UserDao;
import com.crud.fullbuild.dao.UserDaoImpl;
import com.crud.fullbuild.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUser() {
        List<User> userList= userDao.getAllUser();
        return userList;
    }

    @Override
    public User addUser(User user) {
        User newuser = userDao.addUser(user);
        return newuser;
    }

    @Override
    public List<User> addUserList(List<User> userList) {
        for (User user:userList){
            addUser(user);
        }
        return userList;
    }

    @Override
    public User deleteUserById(long id) {
        User newuser =userDao.getUserById(id);
        userDao.deleteUserById(id);
        return newuser;
    }

    @Override
    public User updateUserById(long id, User user) {
        User newuser = userDao.updateUserById(id, user);
        return newuser;
    }

    @Override
    public User getUserById(long id) {
        User newuser = userDao.getUserById(id);
        return newuser;
    }

    @Override
    public User getUserByName(String name) {
        User newuser=userDao.getUserByName(name);
        return newuser;
    }

    @Override
    public List<User> getUserByNameLike(String name) {
        List<User> userList = userDao.getUserByNameLike(name);
        return userList;
    }
}
