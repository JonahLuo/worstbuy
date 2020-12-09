package com.worstbuy.dao;

import com.worstbuy.model.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDAOImpl implements TransactionDAO{
    private SessionFactory sessionFactory;

    @Autowired
    public TransactionDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Transaction get(long id) {
        return sessionFactory.getCurrentSession().get(Transaction.class, id);
    }

    @Override
    public long save(Transaction transaction) {
        sessionFactory.getCurrentSession().save(transaction);
        return transaction.getId();
    }

    @Override
    public List<Transaction> list() {
        List<Transaction> list = sessionFactory.getCurrentSession().createQuery("from transaction").list();
        return list;
    }

    @Override
    public void update(long id, Transaction transaction) {
        Session session = sessionFactory.getCurrentSession();
        Transaction oldTransaction = session.byId(Transaction.class).load(id);
        oldTransaction.setDate(transaction.getDate());
        oldTransaction.setPosterId(transaction.getPosterId());
        session.flush();
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.byId(Transaction.class).load(id);
        session.delete(transaction);
    }
}
