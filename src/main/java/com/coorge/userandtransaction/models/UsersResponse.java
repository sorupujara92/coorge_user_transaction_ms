package com.coorge.userandtransaction.models;

import com.coorge.userandtransaction.entity.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersResponse {

  String token;
  Users user;
}