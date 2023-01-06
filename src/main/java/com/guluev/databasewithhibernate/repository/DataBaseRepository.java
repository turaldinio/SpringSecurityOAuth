package com.guluev.databasewithhibernate.repository;

import com.guluev.databasewithhibernate.model.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataBaseRepository extends JpaRepository<Persons, Integer> {

    List<Persons> getAllByCityOfLiving(String cityName);


    List<Persons> getPersonsByPersonsPrimaryKey_AgeLessThanOrderByPersonsPrimaryKey(int age);

}
