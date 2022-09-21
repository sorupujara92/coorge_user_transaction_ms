package com.coorge.userandtransaction.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTransaction {

  private String description;

  private Double amount;

  private String transaction;
}
