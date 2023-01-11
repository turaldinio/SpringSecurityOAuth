package com.guluev.databasewithhibernate.service;

import com.guluev.databasewithhibernate.model.Persons;
import com.guluev.databasewithhibernate.repository.DataBaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseService {
    private final DataBaseRepository dataBaseRepository;

    public DatabaseService(DataBaseRepository dataBaseRepository) {
        this.dataBaseRepository = dataBaseRepository;
    }

    public List<Persons> getAllPersons() {
        return dataBaseRepository.getAllPersons();
    }

    public void deletePersonByNameAndSurname(String name, String surname) {
        dataBaseRepository.deleteByPersonsPrimaryKey_NameAndPersonsPrimaryKey_Surname(name, surname);
    }


}
