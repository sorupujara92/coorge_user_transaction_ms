package com.coorge.userandtransaction.controller;

import com.coorge.userandtransaction.entity.UserToken;
import com.coorge.userandtransaction.entity.Users;
import com.coorge.userandtransaction.models.UsersResponse;
import com.coorge.userandtransaction.repository.UsersRepository;
import com.coorge.userandtransaction.repository.UsersTokenRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * UserTokenController : Handles operations related to authentication token.
 */
@RestController
@CrossOrigin
@RequestMapping("/api/v1/users-token")
public class UserTokenController {

  @Autowired
  UsersRepository usersRepository;

  @Autowired
  UsersTokenRepository usersTokenRepository;

  @PostMapping
  public ResponseEntity<Object> getUserToken(@RequestBody Users users) {
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
        return ResponseEntity.ok(usersResponse);
      }
    }
    return ResponseEntity.badRequest().build();
  }

  @PostMapping("/logout")
  public ResponseEntity<Object> logoutUser(@RequestBody Users users) {
    usersTokenRepository.deleteAllByEmail(users.getEmail());
    return ResponseEntity.ok("");
  }
}
