package com.sprhib.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sprhib.model.User;


@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {

        return sessionFactory.getCurrentSession();
    }



    public void addUser(User user) {

        getCurrentSession().save(user);
    }


    public void updateUser(User user) {
        User userUpdate = getUser(user.getId());
        userUpdate.setName(user.getName());
        userUpdate.setAge(user.getAge());
        userUpdate.setAdmin(user.getAdmin());
        userUpdate.setCreatedDate(user.getCreatedDate());
        getCurrentSession().update(userUpdate);
    }


    public User getUser(int id) {

        return (User)getCurrentSession().get(User.class,id);
    }


    public void deleteUser(int id) {
        User user = getUser(id);
        if (user!=null)
            getCurrentSession().delete(user);

    }


    public List<User> getUsers() {

        return getCurrentSession().createQuery("FROM User").list();
    }
}
