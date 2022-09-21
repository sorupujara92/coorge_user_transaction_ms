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
