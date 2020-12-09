package com.worstbuy.controller;


import com.worstbuy.model.Transaction;
import com.worstbuy.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {
    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/trans/{id}")
    public ResponseEntity<Transaction> get(@PathVariable("id") long id){
        Transaction transaction = transactionService.get(id);
        return ResponseEntity.ok().body(transaction);
    }

    @GetMapping("/trans")
    public ResponseEntity<List<Transaction>> list(){
        List<Transaction> list = transactionService.list();
        return ResponseEntity.ok().body(list);
    }

    @PutMapping("/trans/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Transaction transaction){
        transactionService.update(id, transaction);
        return ResponseEntity.ok().body("Transaction updated with id: " + id);
    }

    @PostMapping("/trans")
    public ResponseEntity<?> save(@RequestBody Transaction transaction){
        long id = transactionService.save(transaction);
        return ResponseEntity.ok().body("Transaction created with id: " + id);
    }

    @DeleteMapping("/trans/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        transactionService.delete(id);
        return ResponseEntity.ok().body("Transaction deleted with id: " + id);
    }
}
