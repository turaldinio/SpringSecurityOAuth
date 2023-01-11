package com.guluev.databasewithhibernate.controller;

import com.guluev.databasewithhibernate.model.Persons;
import com.guluev.databasewithhibernate.service.DatabaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String deletePersonByNameAndSurname(String name, String surname) {
        return databaseService.deletePersonByNameAndSurname(name, surname);

    }

    @PostMapping("/add")
    public String addNewPerson(@RequestBody Persons persons) {
        return databaseService.addNewPersons(persons);
    }

}
