package com.example.dataSourceDemo.domain.services;

import com.example.dataSourceDemo.domain.models.Person;
import java.util.List;

public interface PersonService {

  List<Person> findAllPersonInStg();

  List<Person> findAllPersonInProd();
}
