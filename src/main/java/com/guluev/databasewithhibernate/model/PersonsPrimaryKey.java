package com.guluev.databasewithhibernate.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class PersonsPrimaryKey implements Serializable {
    private static final long serialVersionUID = 4988863510763090924L;
    private String name;
    private String surname;
    private int age;
}
