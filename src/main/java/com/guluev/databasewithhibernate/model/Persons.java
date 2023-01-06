package com.guluev.databasewithhibernate.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
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
