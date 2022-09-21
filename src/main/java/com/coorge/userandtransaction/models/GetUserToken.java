package com.coorge.userandtransaction.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserToken {

  private String email;

  private String password;
}
