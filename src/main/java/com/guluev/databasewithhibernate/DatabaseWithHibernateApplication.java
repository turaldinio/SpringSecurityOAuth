package com.guluev.databasewithhibernate;

import com.guluev.databasewithhibernate.model.Persons;
import com.guluev.databasewithhibernate.model.PersonsPrimaryKey;
import com.guluev.databasewithhibernate.repository.DataBaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootApplication
public class DatabaseWithHibernateApplication  {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private DataBaseRepository dataBaseRepository;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseWithHibernateApplication.class, args);

    }
}
