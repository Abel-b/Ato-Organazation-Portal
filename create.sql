CREATE DATABASE ato_org;
\c ato_org;

CREATE TABLE IF NOT EXISTS departments(
    id serial PRIMARY KEY,
    userName VARCHAR,
    description VARCHAR,
    numberOfEmployees int);

CREATE TABLE IF NOT EXISTS news(
    id serial PRIMARY KEY,
    title VARCHAR,
    newsContent VARCHAR,
    writtenBy VARCHAR,
    department int
 );

CREATE TABLE IF NOT EXISTS departments_users(
    id serial PRIMARY KEY,
    departmentId int,
    usersId int
    );

CREATE TABLE IF NOT EXISTS users(
    id serial PRIMARY KEY,
    title VARCHAR,
    userName VARCHAR,
    userRole VARCHAR,
    departmentId int);

CREATE DATABASE ato_org_test WITH TEMPLATE ato_org;