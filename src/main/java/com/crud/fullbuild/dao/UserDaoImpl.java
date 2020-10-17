package com.crud.fullbuild.dao;

import com.crud.fullbuild.entity.User;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;


@Repository
@Transactional
public class UserDaoImpl implements UserDao{
    @Autowired
    private EntityManager entityManager;

    public Session getCurrentSession(){
        Session session=(Session)this.entityManager.unwrap(Session.class);
        return session;
    }

    @Override
    public List<User> getAllUser(){
        return getCurrentSession().createQuery("from User").list();
    }


    @Override
    public User addUser(User user) {
        getCurrentSession().save(user);
        return user;
    }


    @Override
    public User deleteUserById(long id) {
        User newuser;
        newuser=getUserById(id);
        getCurrentSession().delete(newuser);
        return newuser;
    }

    @Override
    public User updateUserById(long id, User user) {
        User newupuser;
        newupuser=getUserById(id);
        newupuser.setEmail(user.getEmail());
        newupuser.setPassword(user.getPassword());
        newupuser.setName(user.getName());
        return newupuser;
    }

    @Override
    public User getUserById(long id) {
        return (User)getCurrentSession().createQuery("from User u where u.id= :id").setParameter("id",id).uniqueResult();
    }

    @Override
    public User getUserByName(String name) {

        return (User)getCurrentSession().createQuery("from User u where u.name= :name").setParameter("name",name).uniqueResult();
    }

    @Override
    public List<User> getUserByNameLike(String name) {
        return  (List<User>)getCurrentSession().createQuery("from User u where u.name like concat('%',:name,'%')").setParameter("name", name).list();
    }
}
