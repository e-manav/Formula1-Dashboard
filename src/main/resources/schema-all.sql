DROP TABLE circuits IF EXISTS;

CREATE TABLE circuits
(
    circuitId  INT NOT NULL PRIMARY KEY,
    circuitRef VARCHAR(20),
    name       VARCHAR(50),
    location   VARCHAR(50),
    country    VARCHAR(20),
    lat        DOUBLE,
    lng        DOUBLE,
    alt        INT,
    url        VARCHAR(100)
);