package com.worstbuy.dao;

import com.worstbuy.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDAOImpl implements TransactionDAO{
    @Override
    public Transaction get(long id) {
        return null;
    }

    @Override
    public long save(Transaction transaction) {
        return 0;
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
