create table persons
(
    name           char(20) not null,
    surname        char(20) not null,
    age            int      not null,
    phone_number   char(15) not null,
    city_of_living char(20) not null,
    primary key (name,surname,age)
)