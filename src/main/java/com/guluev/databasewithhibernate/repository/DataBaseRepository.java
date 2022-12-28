package com.guluev.databasewithhibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DataBaseRepository {

    @PersistenceContext
    private EntityManager entityManager;


}
