package com.worstbuy.service;

import com.worstbuy.dao.TransactionDAO;
import com.worstbuy.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    private TransactionDAO transactionDAO;

    @Autowired
    public TransactionServiceImpl(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

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
