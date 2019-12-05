package com.example.dataSourceDemo;

import com.example.dataSourceDemo.annotations.DataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAdvice {

  @Around("@annotation(dataSource)")
  public void adviceMethod(ProceedingJoinPoint proceedingJoinPoint, DataSource dataSource)
      throws Throwable {
    DataSourceContextHolder.setDataSourceType(dataSource.value());
    proceedingJoinPoint.proceed();
  }
}
