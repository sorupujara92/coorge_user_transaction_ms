package com.coorge.userandtransaction.service;

import com.coorge.userandtransaction.entity.Users;
import com.coorge.userandtransaction.models.UsersResponse;

public interface UserTokenService {

  /**
   * getUserToken.
   *
   * @return UsersResponse
   */
  UsersResponse getUserToken(Users users);
}
