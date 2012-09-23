drop database portfolio;
create database portfolio DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
use portfolio
create table comments (name text, email text, text text, timestamp datetime key);

