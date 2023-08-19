CREATE TABLE car
(
    id          BIGSERIAL NOT NULL,
    name        VARCHAR(255),
    description VARCHAR(255),
    length      INTEGER,
    CONSTRAINT pk_car PRIMARY KEY (id)
);