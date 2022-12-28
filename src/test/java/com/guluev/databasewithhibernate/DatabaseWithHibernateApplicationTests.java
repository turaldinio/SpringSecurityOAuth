package com.guluev.databasewithhibernate;

import com.guluev.databasewithhibernate.model.Persons;
import com.guluev.databasewithhibernate.repository.DataBaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DatabaseWithHibernateApplicationTests {

    @Autowired
    private DataBaseRepository dataBaseRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @BeforeEach
    public void initDatabase(){
    }

    @Test
    void contextLoads() {
        dataBaseRepository.getPersonsByCity("");
    }

}
