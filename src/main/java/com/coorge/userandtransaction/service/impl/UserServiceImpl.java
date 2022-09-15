package com.coorge.userandtransaction.service.impl;

import com.coorge.userandtransaction.entity.Users;
import com.coorge.userandtransaction.repository.UsersRepository;
import com.coorge.userandtransaction.service.UserService;
import com.coorge.userandtransaction.service.EncryptionDecryptionService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UsersRepository usersRepository;

  @Autowired EncryptionDecryptionService encryptionDecryptionService;

  @Override
  public String registerUser(Users user) {
    try {
      Optional<Users> checkExistingUser = usersRepository.findById(user.getEmail());
      if (!checkExistingUser.isPresent()) {
        String password = user.getPassword();
        String encPassword = encryptionDecryptionService.encrypt(password);
        if(encPassword!=null) {
          user.setPassword(encPassword);
          usersRepository.save(user);
          return "success";
        }else {
          throw new IllegalArgumentException("");
        }
      }
      return null;
    } catch (Exception e) {
      return null;
    }
  }
}
