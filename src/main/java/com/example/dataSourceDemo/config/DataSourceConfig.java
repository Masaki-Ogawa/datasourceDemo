package com.example.dataSourceDemo.config;

import com.example.dataSourceDemo.DynamicRoutingDataSourceResolver;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class DataSourceConfig {

  private final Environment environment;

  public DataSourceConfig(Environment environment) {
    this.environment = environment;
  }

  /**
   * stg用のdataSource.
   *
   * @return stgのdataSource
   */
  @Bean
  public HikariDataSource stgDataSource() {
    String baseConfig = "spring.datasource.stg.%s";
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(environment.getProperty(String.format(baseConfig, "url")));
    config.setUsername(environment.getProperty(String.format(baseConfig, "username")));
    config.setPassword(environment.getProperty(String.format(baseConfig, "password")));
    return new HikariDataSource(config);
  }

  /**
   * 本番用のdataSource.
   *
   * @return 本番用のdataSource
   */
  @Bean
  public HikariDataSource prodDataSource() {
    String baseConfig = "spring.datasource.prod.%s";
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(environment.getProperty(String.format(baseConfig, "url")));
    config.setUsername(environment.getProperty(String.format(baseConfig, "username")));
    config.setPassword(environment.getProperty(String.format(baseConfig, "password")));
    return new HikariDataSource(config);
  }

  /**
   * dataSourceのdefaultを設定するBean.
   *
   * @return DynamicRoutingDataSourceResolver
   */
  @Bean
  @Primary
  public DynamicRoutingDataSourceResolver dataSourceResolver() {
    DynamicRoutingDataSourceResolver resolver = new DynamicRoutingDataSourceResolver();

    Map<Object, Object> dataSources = new LinkedHashMap<>();
    dataSources.put("stg", stgDataSource());
    dataSources.put("prod", prodDataSource());

    resolver.setTargetDataSources(dataSources);
    resolver.setDefaultTargetDataSource(stgDataSource());

    return resolver;
  }
}
