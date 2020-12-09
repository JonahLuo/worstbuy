package com.worstbuy.service;

import com.worstbuy.dao.TransactionDAO;
import com.worstbuy.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    private TransactionDAO transactionDAO;

    @Autowired
    public TransactionServiceImpl(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    @Override
    @Transactional
    public Transaction get(long id) {
        return transactionDAO.get(id);
    }

    @Override
    @Transactional
    public long save(Transaction transaction) {
        return transactionDAO.save(transaction);
    }

    @Override
    @Transactional
    public List<Transaction> list() {
        return transactionDAO.list();
    }

    @Override
    @Transactional
    public void update(long id, Transaction transaction) {
        transactionDAO.update(id, transaction);
    }

    @Override
    @Transactional
    public void delete(long id) {
        transactionDAO.delete(id);
    }
}
