package com.guluev.databasewithhibernate.repository;

import com.guluev.databasewithhibernate.model.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DataBaseRepository extends JpaRepository<Persons, Integer> {

    List<Persons> getAllByCityOfLiving(String cityName);


    List<Persons> getPersonsByPersonsPrimaryKey_AgeLessThanOrderByPersonsPrimaryKey(int age);

    Optional<Persons> findByPersonsPrimaryKey_NameAndPersonsPrimaryKey_Surname(String name, String surname);

}
