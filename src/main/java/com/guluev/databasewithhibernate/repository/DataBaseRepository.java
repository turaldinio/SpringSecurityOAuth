package com.guluev.databasewithhibernate.repository;

import com.guluev.databasewithhibernate.model.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DataBaseRepository extends JpaRepository<Persons, Integer> {
@Query(value = "select * from Persons",nativeQuery = true)
    List<Persons> getAllPersons();

    void deleteByPersonsPrimaryKey_NameAndPersonsPrimaryKey_Surname(String name, String surname);


}
