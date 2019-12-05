package com.example.dataSourceDemo;

import com.example.dataSourceDemo.annotations.DataSource.DataSourceType;

/**
 * アプリケーションのスレッドごとにdataSourceの情報を持つクラス.
 */
public class DataSourceContextHolder {
  private static ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<>();

  public static void setDataSourceType(DataSourceType dataSourceType) {
    contextHolder.set(dataSourceType);
  }

  public static DataSourceType getDataSourceType() {
    return contextHolder.get();
  }

  public static void clear() {
    contextHolder.remove();
  }
}