package com.coorge.userandtransaction.service.impl;

import com.coorge.userandtransaction.TransactionType;
import com.coorge.userandtransaction.entity.UserTransactions;
import com.coorge.userandtransaction.models.CreateTransaction;
import com.coorge.userandtransaction.models.UpdateTransaction;
import com.coorge.userandtransaction.repository.TransactionRepository;
import com.coorge.userandtransaction.service.TransactionService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

  @Autowired
  TransactionRepository transactionRepository;

  @Override
  public UserTransactions createTransaction(CreateTransaction createTransaction, String userId) {

    UserTransactions transaction = new UserTransactions();
    transaction.setTransactionTypeId(
        TransactionType.valueOf(createTransaction.getTransaction()).getType());
    transaction.setAmount(createTransaction.getAmount());
    transaction.setUserId(userId);
    transaction.setDescription(createTransaction.getDescription());
    UserTransactions t = transactionRepository.save(transaction);
    return t;
  }

  @Override
  public UserTransactions updateTransaction(UpdateTransaction updateTransaction, String id,
      String userId) {
    Optional<UserTransactions> userTransactions = transactionRepository.findById(id);
    if (userTransactions.isPresent() && userTransactions.get().getUserId().equals(userId)) {
      UserTransactions update = getUserTransaction(userTransactions.get(), updateTransaction);
      return transactionRepository.save(update);
    } else {
      //Forbidden excepion
      return null;
    }
  }

  @Override
  public UserTransactions getTransaction(String id, String userId) {
    Optional<UserTransactions> userTransactions = transactionRepository.findById(id);
    if (userTransactions.isPresent() && userTransactions.get().getUserId().equals(userId)) {
      return userTransactions.get();
    } else {
      //Forbidden excepion
      return null;
    }
  }

  @Override
  public void deleteTransaction(String id, String userId) {
    Optional<UserTransactions> userTransactions = transactionRepository.findById(id);
    if (userTransactions.isPresent() && userTransactions.get().getUserId().equals(userId)) {
      transactionRepository.deleteById(id);
    } else {
      //Forbidden excepion
    }
  }

  private UserTransactions getUserTransaction(UserTransactions userTransactions,
      UpdateTransaction updateTransaction) {
    UserTransactions tobeUpdated = new UserTransactions();
    tobeUpdated.setUserId(userTransactions.getId());
    tobeUpdated.setDescription(
        updateTransaction.getDescription().isPresent() ? updateTransaction.getDescription().get()
            : userTransactions.getDescription());
    tobeUpdated.setAmount(
        updateTransaction.getAmount().isPresent() ? updateTransaction.getAmount().get()
            : userTransactions.getAmount());
    tobeUpdated.setTransactionTypeId(
        updateTransaction.getTransaction().isPresent() ? TransactionType.valueOf(
            updateTransaction.getTransaction().get()).getType()
            : userTransactions.getTransactionTypeId());
    tobeUpdated.setUserId(userTransactions.getUserId());
    return tobeUpdated;

  }
}