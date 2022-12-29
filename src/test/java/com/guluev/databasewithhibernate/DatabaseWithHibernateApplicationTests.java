package com.guluev.databasewithhibernate;

import com.guluev.databasewithhibernate.model.Persons;
import com.guluev.databasewithhibernate.model.PersonsPrimaryKey;
import com.guluev.databasewithhibernate.repository.DataBaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
class DatabaseWithHibernateApplicationTests {

    @Autowired
    private DataBaseRepository dataBaseRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Test
    void contextLoads() {
        List<String> nameList = List.of("James", "Niki", "Floria", "Georgiy", "Vladimir");
        List<String> surName = List.of("Sergeev", "Romanov", "Zhukov");
        List<String> city = List.of("Saint-Petersburg", "Moscow", "Krasnodar", "Omsk", "Tumen", "Tver");
        IntStream.range(0, 15).forEach(x -> {
            var person = Persons.builder().personsPrimaryKey(PersonsPrimaryKey.
                            builder().
                            name(nameList.get(new Random().nextInt(nameList.size()))).
                            surname(surName.get(new Random().nextInt(surName.size()))).
                            age(new Random().nextInt(89)).build())
                    .phoneNumber("74928347291").
                    cityOfLiving(city.get(new Random().nextInt(city.size())))
                    .build();
            entityManager.persist(person);
        });

        dataBaseRepository.getPersonsByCity("Saint-Petersburg");
    }

}
