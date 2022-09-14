package com.coorge.userandtransaction.service;

import com.coorge.userandtransaction.entity.Users;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {

  String registerUser(@RequestBody Users users);
}
