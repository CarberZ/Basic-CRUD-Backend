package com.crud.fullbuild.service;

import com.crud.fullbuild.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();
    public User addUser(User user);
    public List<User> addUserList(List<User> userList);
    public User deleteUserById(long id);
    public User updateUserById(long id, User user);
    public User getUserById(long id);
    public User getUserByName(String name);
    public List<User> getUserByNameLike(String name);
}
