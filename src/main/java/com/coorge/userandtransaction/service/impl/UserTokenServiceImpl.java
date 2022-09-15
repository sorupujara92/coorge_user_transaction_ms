package com.coorge.userandtransaction.service.impl;

import com.coorge.userandtransaction.entity.UserToken;
import com.coorge.userandtransaction.entity.Users;
import com.coorge.userandtransaction.models.GetUserToken;
import com.coorge.userandtransaction.models.UsersResponse;
import com.coorge.userandtransaction.repository.UsersRepository;
import com.coorge.userandtransaction.repository.UsersTokenRepository;
import com.coorge.userandtransaction.service.UserTokenService;
import com.coorge.userandtransaction.service.EncryptionDecryptionService;
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

  @Autowired EncryptionDecryptionService encryptionDecryptionService;


  @Override
  public UsersResponse getUserToken(GetUserToken users) {
    try {
      Optional<Users> dbUser = usersRepository.findById(users.getEmail());
      if (dbUser.isPresent()) {
        String encPassword = encryptionDecryptionService.encrypt(users.getPassword());
        if (encPassword!=null && dbUser.get().getPassword()
            .equals(encPassword)) {
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
    }catch (Exception e){
      return null;
    }
  }
}
