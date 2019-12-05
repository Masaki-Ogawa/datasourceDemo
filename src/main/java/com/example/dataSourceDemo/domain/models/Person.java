package com.example.dataSourceDemo.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * PersonテーブルをマッピングしたEntity.
 */
@Entity
@Getter
@Setter
@Table(name = "person")
public class Person {

  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "age")
  private Integer age;
}
