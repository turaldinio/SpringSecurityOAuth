package com.guluev.databasewithhibernate.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Persons {
    @EmbeddedId
    private PersonsPrimaryKey personsPrimaryKey;
    private String phone_number;
    private String city_of_living;

    @Override
    public String toString() {
        return personsPrimaryKey.getName() + " " + personsPrimaryKey.getSurname() + " " + personsPrimaryKey.getAge();
    }

    public PersonsPrimaryKey getPersonsPrimaryKey() {
        return personsPrimaryKey;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getCity_of_living() {
        return city_of_living;
    }
}
