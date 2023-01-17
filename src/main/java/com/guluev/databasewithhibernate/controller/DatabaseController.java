package com.guluev.databasewithhibernate.controller;

import com.guluev.databasewithhibernate.model.Persons;
import com.guluev.databasewithhibernate.service.DatabaseService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DatabaseController {

    private final DatabaseService databaseService;

    public DatabaseController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @Secured("ROLE_READ")
    @GetMapping("/all")
    public List<Persons> getAllPersons() {
        return databaseService.getAllPersons();
    }

    @DeleteMapping("/delete")
    public String deletePersonByNameAndSurname(String name, String surname) {
        return databaseService.deletePersonByNameAndSurname(name, surname);

    }

    @RolesAllowed("ROLE_WRITE")
    @PostMapping("/add")
    public String addNewPerson(@RequestBody Persons persons) {
        return databaseService.addNewPersons(persons);
    }

    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_READ')")
    @GetMapping("/something")
    public String doSomething() {
        return "cool";
    }

    @PreAuthorize("#userName == authentication.name")
    @GetMapping("/hello")
    public String sayHello(String userName) {
        return userName + " hello!";
    }
}
