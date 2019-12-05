package com.example.dataSourceDemo.domain.repositories;

import com.example.dataSourceDemo.domain.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
