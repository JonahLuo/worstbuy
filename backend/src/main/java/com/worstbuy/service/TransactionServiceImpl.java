package com.worstbuy.service;

import com.worstbuy.dao.TransactionDAO;
import com.worstbuy.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TransactionServiceImpl implements TransactionService{

    private TransactionDAO transactionDAO;

    @Autowired
    public TransactionServiceImpl(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

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
