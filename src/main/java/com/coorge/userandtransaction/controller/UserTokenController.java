package com.coorge.userandtransaction.controller;

import com.coorge.userandtransaction.entity.UserToken;
import com.coorge.userandtransaction.entity.Users;
import com.coorge.userandtransaction.models.UsersResponse;
import com.coorge.userandtransaction.repository.UsersRepository;
import com.coorge.userandtransaction.repository.UsersTokenRepository;
import com.coorge.userandtransaction.service.UserTokenService;
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
  UserTokenService userTokenService;
  @PostMapping
  public ResponseEntity<Object> getUserToken(@RequestBody Users users) {
    UsersResponse usersResponse = userTokenService.getUserToken(users);
    if(users!=null) {
      return ResponseEntity.ok(usersResponse);
    } else {
      return ResponseEntity.badRequest().build();
    }
  }

//  @PostMapping("/logout")
//  public ResponseEntity<Object> logoutUser(@RequestBody Users users) {
//    usersTokenRepository.deleteAllByEmail(users.getEmail());
//    return ResponseEntity.ok("");
//  }
}
