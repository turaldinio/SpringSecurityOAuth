package com.guluev.databasewithhibernate.repository;

import com.guluev.databasewithhibernate.model.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataBaseRepository extends JpaRepository<Persons, Integer> {

    Persons getAllByCityOfLiving(String cityName);


}
