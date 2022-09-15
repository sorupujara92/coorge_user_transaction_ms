package com.coorge.userandtransaction.controller;

import com.coorge.userandtransaction.entity.UserTransactions;
import com.coorge.userandtransaction.models.CreateTransaction;
import com.coorge.userandtransaction.models.UpdateTransaction;
import com.coorge.userandtransaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserTokenController : Handles operations related to authentication token.
 */
@RestController
@CrossOrigin
@RequestMapping("/api/v1/transaction")
public class TransactionController {

  @Autowired
  TransactionService transactionService;

  @PostMapping
  public ResponseEntity<UserTransactions> createTransaction(@RequestBody CreateTransaction createTransaction) {
    String userId = SecurityContextHolder.getContext().getAuthentication().getName();
    UserTransactions userTransactions = transactionService.createTransaction(createTransaction,userId);
    return ResponseEntity.created(null).body(userTransactions);
  }

  @PatchMapping(path = "/{id}")
  public ResponseEntity<Object> updateTransaction(@PathVariable Integer id,@RequestBody UpdateTransaction updateTransaction) {
    String userId = SecurityContextHolder.getContext().getAuthentication().getName();
    UserTransactions userTransactions = transactionService.updateTransaction(updateTransaction,id,userId);
    if(userTransactions!=null) {
      return ResponseEntity.ok(userTransactions);
    }else {
      return ResponseEntity.badRequest().body("");
    }
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Object> getTransaction(@PathVariable Integer id) {
    String userId = SecurityContextHolder.getContext().getAuthentication().getName();
    UserTransactions userTransactions = transactionService.getTransaction(id,userId);
    if(userTransactions!=null) {
      return ResponseEntity.ok(userTransactions);
    }else {
      return ResponseEntity.badRequest().body("");
    }
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Object> deleteTransaction(@PathVariable Integer id) {
    try {
      String userId = SecurityContextHolder.getContext().getAuthentication().getName();
      transactionService.deleteTransaction(id, userId);
      return ResponseEntity.ok().body("");
    }catch (Exception e){
      ResponseEntity.badRequest();
    }
    return ResponseEntity.badRequest().body("");
  }
}
