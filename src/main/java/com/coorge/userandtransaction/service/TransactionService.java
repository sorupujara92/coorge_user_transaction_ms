package com.coorge.userandtransaction.service;

import com.coorge.userandtransaction.entity.UserTransactions;
import com.coorge.userandtransaction.models.CreateTransaction;
import com.coorge.userandtransaction.models.UpdateTransaction;

public interface TransactionService {

  UserTransactions createTransaction(CreateTransaction createTransaction,String userId);

  UserTransactions updateTransaction(UpdateTransaction updateTransaction,Integer id,String userId);

  UserTransactions getTransaction(Integer id,String userId);

  void deleteTransaction(Integer id,String userId);


}
