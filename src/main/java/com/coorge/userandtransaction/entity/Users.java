package com.coorge.userandtransaction.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Users entity.
 */
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "users")
public class Users {


  @Id
  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "firs_tname")
  private String firstname;

  @Column(name = "last_name")
  private String lastname;

  //Not keeping repeat_password as ideally it should be checked at the UI level.
}
