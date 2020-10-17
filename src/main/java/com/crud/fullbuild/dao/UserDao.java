package com.crud.fullbuild.dao;

import java.util.List;
import com.crud.fullbuild.entity.User;

public interface UserDao {
    public List<User> getAllUser();
    public User addUser(User user);
    public User deleteUserById(long id);
    public User updateUserById(long id, User user);
    public User getUserById(long id);
    public User getUserByName(String name);
    public List<User> getUserByNameLike(String name);
}
