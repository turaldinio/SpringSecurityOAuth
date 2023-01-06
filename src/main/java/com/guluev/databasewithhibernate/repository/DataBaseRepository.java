package com.guluev.databasewithhibernate.repository;

import com.guluev.databasewithhibernate.model.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataBaseRepository extends JpaRepository<Persons, Integer> {

//    @Transactional
//    public List<Persons> getPersonsByCity(String city) {
//        var request = entityManager.createQuery("select p from Persons p where p.cityOfLiving= :city ", Persons.class);
//        request.setParameter("city", city);
//        return request.getResultList();
//
//    }

}
