package com.example.dataSourceDemo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * dataSourceを変更するときに用いるアノテーション.
 */
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {

  /**
   * defaultはSTG.
   *
   * @return enumで定義したdatasource
   */
  DataSourceType value() default DataSourceType.STG;
  enum DataSourceType {
    STG,
    PROD
  }
}