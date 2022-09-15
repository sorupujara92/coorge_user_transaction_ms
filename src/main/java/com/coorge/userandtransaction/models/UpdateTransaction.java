package com.coorge.userandtransaction.models;

import java.util.Optional;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTransaction {

  private Optional<String> description;

  private Optional<Double> amount;

  private Optional<String> transaction;
}
