package com.coorge.userandtransaction.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * UserTransactions entity.
 */
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "user_transactions")
public class UserTransactions {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "user_id")
  private String userId;

  @Column(name = "description")
  private String description;

  @Column(name = "amount")
  private Double amount;

  @Column(name = "transaction_type_id")
  private Integer transactionTypeId;

  @Version
  @Column(name = "version")
  private Integer version;
}
