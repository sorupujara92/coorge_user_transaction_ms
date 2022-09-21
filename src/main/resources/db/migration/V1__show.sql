
create table user_transactions
(
    id                      INTEGER  AUTO_INCREMENT,
    user_id                 VARCHAR(100) NOT NULL,
    description             VARCHAR(40)  NOT NULL,
    amount                  DOUBLE NOT NULL,
    transaction_type_id     INTEGER NOT NULL,
    version                INTEGER NOT NULL,
    PRIMARY KEY (id)
);
