package com.guluev.databasewithhibernate.service;

import com.guluev.databasewithhibernate.model.Persons;
import com.guluev.databasewithhibernate.repository.DataBaseRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public String deletePersonByNameAndSurname(String name, String surname) {
        try {
            dataBaseRepository.deleteByPersonsPrimaryKey_NameAndPersonsPrimaryKey_Surname(name, surname);
        } catch (Exception e) {
            return "an error occurred while deleting the client " + e.getMessage();
        }
        return String.format("The person (%s %s) has been deleted", name, surname);
    }


    public String addNewPersons(Persons persons) {
        var person = dataBaseRepository.save(persons);
return person.getPersonsPrimaryKey().getName()+" "+person.getPersonsPrimaryKey().getSurname()+" successfully added";

    }
}
