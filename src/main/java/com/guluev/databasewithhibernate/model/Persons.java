package com.guluev.databasewithhibernate.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
}
