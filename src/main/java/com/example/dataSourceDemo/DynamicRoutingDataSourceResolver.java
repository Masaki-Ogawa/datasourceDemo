package com.example.dataSourceDemo;

import com.example.dataSourceDemo.annotations.DataSource.DataSourceType;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 条件に応じてdataSourceを切り替えるクラス.
 */
public class DynamicRoutingDataSourceResolver extends AbstractRoutingDataSource {

  /**
   * 使用するdataSourceのキーを設定するメソッド.
   *
   * @return String 接続先のdataSourceを表す文字列
   */
  @Override
  protected Object determineCurrentLookupKey() {

    if (DataSourceContextHolder.getDataSourceType() == DataSourceType.STG) {
      return "stg";
    } else if (DataSourceContextHolder.getDataSourceType() == DataSourceType.PROD) {
      return "prod";
    }

    // デフォルトはstgを返却
    return "stg";
  }
}
