package com.guluev.databasewithhibernate.repository;

import com.guluev.databasewithhibernate.model.Persons;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DataBaseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void getPersonsByCity(String city) {
        var request = entityManager.createQuery("select p from Persons p where p.city_of_living= :city ", Persons.class);
        request.setParameter("city", city);
        request.getResultList().forEach(System.out::println);

    }

}
