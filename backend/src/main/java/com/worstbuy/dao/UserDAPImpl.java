package com.worstbuy.dao;

import com.worstbuy.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAPImpl implements UserDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public UserDAPImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public long save(User user) {
        sessionFactory.getCurrentSession().save(user);
        return user.getId();
    }

    @Override
    public void update(long id, User user) {
        Session session = sessionFactory.getCurrentSession();
        User oldUser = session.byId(User.class).load(id);
        oldUser.setAddress(user.getAddress());
        oldUser.setUserName(user.getUserName());
        oldUser.setEmail(user.getEmail());
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setPassword(user.getPassword());
        session.flush();
    }

    @Override
    public User get(long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User getByName(String username) {
        String hql = "from User u where u.userName = :userName";
        return (User)sessionFactory.getCurrentSession().createQuery(hql).setParameter("userName", username).uniqueResult();
    }

    @Override
    public List<User> list() {
        List<User> list = sessionFactory.getCurrentSession().createQuery("from User").list();
        return list;
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.byId(User.class).load(id);
        session.delete(user);

    }

    @Override
    public User findUserByEmail(String email) {
        String hql = "from User u where u.email = :email";
        User user = (User) sessionFactory.getCurrentSession().createQuery(hql).setParameter("email", email).uniqueResult();
        return user;
    }

    @Override
    public boolean checkBeforeSignup(User user){
        if(this.findUserByEmail(user.getEmail()) != null)
            return false;
        return true;
    }
}
