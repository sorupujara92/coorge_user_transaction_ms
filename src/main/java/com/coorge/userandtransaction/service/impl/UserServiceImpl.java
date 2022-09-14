package com.coorge.userandtransaction.service.impl;

import com.coorge.userandtransaction.entity.Users;
import com.coorge.userandtransaction.repository.UsersRepository;
import com.coorge.userandtransaction.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UsersRepository usersRepository;

  @Override
  public String registerUser(Users user) {
    try {
      Optional<Users> checkExistingUser = usersRepository.findById(user.getEmail());
      if (!checkExistingUser.isPresent()) {
        usersRepository.save(user);
        return "success";
      }
      return null;
    } catch (Exception e) {
      return null;
    }
  }
}
