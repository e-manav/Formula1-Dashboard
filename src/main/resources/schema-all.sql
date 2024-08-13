CREATE TABLE circuit
(
    circuitId  VARCHAR(20) NOT NULL PRIMARY KEY,
    circuitRef VARCHAR(20),
    name       VARCHAR(50),
    location   VARCHAR(50),
    country    VARCHAR(20),
    lat        VARCHAR(10),
    lng        VARCHAR(10),
    alt        VARCHAR(9),
    url        VARCHAR(100)
);