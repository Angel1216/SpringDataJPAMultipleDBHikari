### DataBase
## Table 1
Select * from clients
delete clients

CREATE TABLE clients (
clientId INT PRIMARY KEY,
clientName VARCHAR(80),
firstName VARCHAR(80),
lastName VARCHAR(80)
);

insert into clients values (1,'Ricardo', 'Perez', 'Palomino');
insert into clients values (2,'Ernesto', 'hernandez', 'perez');
insert into clients values (3,'Griselda', 'Alarcon', 'Bernal');

## Table2
Select * from customersmds
delete customersmds

CREATE TABLE customersmds (
clientId INT PRIMARY KEY,
clientName VARCHAR(80),
firstName VARCHAR(80),
lastName VARCHAR(80)
);

insert into customersmds values (1,'Pedro', 'Rodriguez', 'Palacio');
insert into customersmds values (2,'Esther', 'De la Torre', 'Roxa');
insert into customersmds values (3,'Berenice', 'Mendez', 'Francisca');

