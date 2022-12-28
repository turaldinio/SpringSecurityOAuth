package com.guluev.databasewithhibernate.controller;

import com.guluev.databasewithhibernate.model.Persons;
import org.hibernate.dialect.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class DatabaseController {

    @Autowired
    DatabaseService databaseService;

    @GetMapping("by-city")
    public List<Persons> getPersonsByCity(String city) {
        return databaseService.getPernonsByCity(city);
    }

}
