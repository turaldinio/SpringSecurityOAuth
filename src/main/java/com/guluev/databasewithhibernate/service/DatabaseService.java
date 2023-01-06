package com.guluev.databasewithhibernate.service;

import com.guluev.databasewithhibernate.model.Persons;
import com.guluev.databasewithhibernate.repository.DataBaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatabaseService {
    private final DataBaseRepository dataBaseRepository;

    public DatabaseService(DataBaseRepository dataBaseRepository) {
        this.dataBaseRepository = dataBaseRepository;
    }

    public List<Persons> getPersonsByCity(String city) {
        return dataBaseRepository.getAllByCityOfLiving(city);
    }

    public List<Persons> getPersonsByAgeSortByCity(int age) {
        return dataBaseRepository.getPersonsByPersonsPrimaryKey_AgeLessThanOrderByPersonsPrimaryKey(age);

    }

    public Optional<Persons> getPersonByNameAndSurname(String name, String surname) {
        return dataBaseRepository.findByPersonsPrimaryKey_NameAndPersonsPrimaryKey_Surname(name, surname);
    }
}
