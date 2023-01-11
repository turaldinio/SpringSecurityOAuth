package com.guluev.databasewithhibernate.controller;

import com.guluev.databasewithhibernate.model.Persons;
import com.guluev.databasewithhibernate.service.DatabaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class DatabaseController {

    private final DatabaseService databaseService;

    public DatabaseController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @GetMapping("/all")
    public List<Persons> getAllPersons() {
        return databaseService.getAllPersons();
    }

    @DeleteMapping("/delete")
    public void deletePersonByNameAndSurname(String name, String surname) {
        databaseService.deletePersonByNameAndSurname(name, surname);
    }

    @PostMapping("/add")
    public Persons addNewPerson(@RequestBody Persons persons) {
        return databaseService.addNewPersons(persons);
    }

}
