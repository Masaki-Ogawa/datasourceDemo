package com.example.dataSourceDemo.domain.services;

import com.example.dataSourceDemo.annotations.DataSource;
import com.example.dataSourceDemo.annotations.DataSource.DataSourceType;
import com.example.dataSourceDemo.domain.models.Person;
import com.example.dataSourceDemo.domain.repositories.PersonRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

  private final PersonRepository personRepository;

  public PersonServiceImpl(
      PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  /**
   * stgのDBからPersonテーブルのレコードを取得するメソッド
   * @return Personテーブルのレコード
   */
  @Override
  public List<Person> findAllPersonInStg() {
    return personRepository.findAll();
  }

  /**
   * stgのDBからPersonテーブルのレコードを取得するメソッド
   * @return Personテーブルのレコード
   */
  @DataSource(value = DataSourceType.PROD)
  @Override
  public List<Person> findAllPersonInProd() {
    return personRepository.findAll();
  }
}
