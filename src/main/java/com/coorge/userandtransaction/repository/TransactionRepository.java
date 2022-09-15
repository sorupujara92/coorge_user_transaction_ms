package com.coorge.userandtransaction.repository;

import com.coorge.userandtransaction.entity.UserTransactions;
import com.coorge.userandtransaction.entity.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * the UsersRepository.
 */
public interface TransactionRepository extends
    CrudRepository<UserTransactions, String> {


}