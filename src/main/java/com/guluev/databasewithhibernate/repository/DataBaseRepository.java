package com.guluev.databasewithhibernate.repository;

import com.guluev.databasewithhibernate.model.Persons;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DataBaseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Persons getPersonsByCity(String city) {
        entityManager.
    }

}
