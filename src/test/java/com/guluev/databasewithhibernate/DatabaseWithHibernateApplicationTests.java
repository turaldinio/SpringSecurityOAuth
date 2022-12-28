package com.guluev.databasewithhibernate;

import com.guluev.databasewithhibernate.model.Persons;
import com.guluev.databasewithhibernate.model.PersonsPrimaryKey;
import com.guluev.databasewithhibernate.repository.DataBaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
class DatabaseWithHibernateApplicationTests {

    @Autowired
    private DataBaseRepository dataBaseRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @BeforeEach
    public void initDatabase() {
        List<String> nameList = List.of("James", "Niki", "Floria", "Georgiy", "Vladimir");
        List<String> surName = List.of("Sergeev", "Romanov", "Zhukov");
        Persons.builder().personsPrimaryKey(PersonsPrimaryKey.
                builder().
                name(nameList.get(new Random().nextInt(nameList.size()))).
                surname(surName.get(new Random().nextInt(surName.size()))).
                age(new Random().nextInt() * 78).build()).build();
    }

    @Test
    void contextLoads() {
        dataBaseRepository.getPersonsByCity("");
    }

}
