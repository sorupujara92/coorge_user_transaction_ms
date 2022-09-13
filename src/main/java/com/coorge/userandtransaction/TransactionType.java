package com.coorge.userandtransaction;

/** the TransactionType. */
public enum TransactionType {

  EXPENSE(1),
  INCOME(2);

  /** the instance type. */
  private final int type;

  /**
   * Ctor.
   *
   * @param type the instance type
   */
  TransactionType(final int type) {
    this.type = type;
  }

  /**
   * get TransactionType from a type (int).
   *
   * @param type the type to lookup
   * @return TransactionType based on the int type
   */
  public static TransactionType valueOf(final int type) {

    for (final TransactionType transactionType :
        TransactionType.values()) {
      if (transactionType.getType() == type) {
        return transactionType;
      }
    }

    throw new IllegalArgumentException("no type found for " + type);
  }

  /**
   * get the instance type.
   *
   * @return the instance type
   */
  public int getType() {
    return type;
  }
}
