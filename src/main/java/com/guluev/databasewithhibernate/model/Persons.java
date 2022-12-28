package com.guluev.databasewithhibernate.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Persons {
    @EmbeddedId
    private PersonsPrimatyKey personsPrimatyKey;
    private String name;
    private String surname;
    private int age;
    private String phone_number;
    private String city_of_living;


}
