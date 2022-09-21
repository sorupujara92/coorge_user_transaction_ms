package com.coorge.userandtransaction.repository;

import com.coorge.userandtransaction.entity.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * the UsersRepository.
 */
public interface UsersRepository extends
    CrudRepository<Users, String> {


}