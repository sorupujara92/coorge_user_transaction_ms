package com.coorge.userandtransaction.controller;


import com.coorge.userandtransaction.entity.Users;
import com.coorge.userandtransaction.models.UsersResponse;
import com.coorge.userandtransaction.service.UserService;
import com.coorge.userandtransaction.service.UserTokenService;
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
@RequestMapping("/api/v1/users")
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping
    public ResponseEntity<Object> registerUser(@RequestBody Users users) {
    String response = userService.registerUser(users);
    if(response!=null && response.equals("success")){
      return ResponseEntity.ok("User created successfully");
    } else{
      return ResponseEntity.badRequest().body("User already exist");
    }
  }
}
