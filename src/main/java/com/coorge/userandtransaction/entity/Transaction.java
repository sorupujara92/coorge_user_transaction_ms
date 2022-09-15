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
@Table(name = "user_transactions")
public class Transaction {

  @Id
  @Column(name = "id")
  private String id;

  @Id
  @Column(name = "user_id")
  private String userId;

  @Column(name = "description")
  private String description;

  @Column(name = "amount")
  private Double amount;

  @Column(name = "transaction_type_id")
  private Integer transaction_type_id;

}
