package com.worstbuy.dao;

import com.worstbuy.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDAOImpl implements TransactionDAO{
    @Override
    public Transaction get(Long id) {
        return null;
    }

    @Override
    public Long save(Transaction transaction) {
        return null;
    }

    @Override
    public List<Transaction> list() {
        return null;
    }

    @Override
    public void update(Transaction transaction) {

    }

    @Override
    public void delete(long id) {

    }
}
