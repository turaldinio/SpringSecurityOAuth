package com.guluev.databasewithhibernate.repository;

import com.guluev.databasewithhibernate.model.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DataBaseRepository extends JpaRepository<Persons, Integer> {

    @Query("select p from Persons p where p.cityOfLiving= :cityName")
    List<Persons> getAllByCityOfLiving(String cityName);

    @Query("select p from Persons p where p.personsPrimaryKey.age< :age order by p.personsPrimaryKey.age")
    List<Persons> getPersonsByPersonsPrimaryKey_AgeLessThanOrderByPersonsPrimaryKey(int age);

    @Query("select p from Persons p where p.personsPrimaryKey.name= :name and p.personsPrimaryKey.surname= :surname")
    Optional<Persons> findByPersonsPrimaryKey_NameAndPersonsPrimaryKey_Surname(String name, String surname);

}
