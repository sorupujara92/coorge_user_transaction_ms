/*
 Could have used it as a migration script. 
 */

create table users_token
(
    id    VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);


create table users
(
    email           VARCHAR(100) NOT NULL,
    password        VARCHAR(100) NOT NULL,
    firstname       VARCHAR(40)  NOT NULL,
    lastname        VARCHAR(100) NOT NULL,
    PRIMARY KEY (email)
);

create table user_transactions
(
    id                      VARCHAR(100) NOT NULL,
    user_id                 VARCHAR(100) NOT NULL,
    description             VARCHAR(40)  NOT NULL,
    amount                  DOUBLE NOT NULL,
    transaction_type_id     INTEGER NOT NULL
    PRIMARY KEY (id)
);
