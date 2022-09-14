package com.coorge.userandtransaction.service.impl;

import com.coorge.userandtransaction.entity.UserToken;
import com.coorge.userandtransaction.entity.Users;
import com.coorge.userandtransaction.models.UsersResponse;
import com.coorge.userandtransaction.repository.UsersRepository;
import com.coorge.userandtransaction.repository.UsersTokenRepository;
import com.coorge.userandtransaction.service.UserTokenService;
import java.util.Optional;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserTokenServiceImpl implements UserTokenService {

  @Autowired
  UsersRepository usersRepository;

  @Autowired
  UsersTokenRepository usersTokenRepository;


  @Override
  public UsersResponse getUserToken(Users users) {
    Optional<Users> dbUser  = usersRepository.findById(users.getEmail());
    if(dbUser.isPresent()){
      if(dbUser.get().getPassword().equals(users.getPassword())){
        UUID uuid = UUID.randomUUID();
        UserToken userToken = new UserToken();
        userToken.setId(uuid.toString());
        userToken.setEmail(dbUser.get().getEmail());
        usersTokenRepository.save(userToken);
        UsersResponse usersResponse = new UsersResponse();
        usersResponse.setToken(uuid.toString());
        dbUser.get().setPassword("");
        usersResponse.setUser(dbUser.get());
        return usersResponse;
      }
    }
    return null;
  }
}
