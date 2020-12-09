package com.worstbuy.service;

import com.worstbuy.model.Transaction;

import java.util.List;

public interface TransactionService {
    /**
     * get the transaction
     * @param id the id of the transaction to be found
     * @return the transaction
     */
    Transaction get(long id);

    /**
     * save the given transaction
     * @param transaction the transaction to be saved
     * @return the id the transaction saved
     */
    long save(Transaction transaction);

    /**
     * Get all of the transactions
     * @return All the transactions
     */
    List<Transaction> list();

    /**
     * Update Transaction
     * @param id
     * @param transaction The Transaction to be updated
     */
    void update(long id, Transaction transaction);

    /**
     * Delete the transaction
     * @param id the id of the transaction to be deleted
     */
    void delete(long id);
}
