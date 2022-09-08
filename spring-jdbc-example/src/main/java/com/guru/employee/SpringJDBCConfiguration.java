package com.guru.employee;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.guru.employee.dao.EmployeeDAO;
import com.guru.employee.dao.EmployeeDAOImpl;

@Configuration
public class SpringJDBCConfiguration {
  @Bean
  public DataSource dataSource() {
	 DriverManagerDataSource   dataSource = new DriverManagerDataSource();
    //MySQL database we are using
    
    //H2 database
    dataSource.setDriverClassName("org.h2.Driver");
    dataSource.setUrl("jdbc:h2:mem:sampleboot");
    dataSource.setUsername("sa");
    dataSource.setPassword("");
    return dataSource;
  }
  
  @Bean
  public JdbcTemplate jdbcTemplate() {
    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    jdbcTemplate.setDataSource(dataSource());
    return jdbcTemplate;
  }
  
  @Bean
  public EmployeeDAO employeeDAO(){
    EmployeeDAOImpl empDao = new EmployeeDAOImpl();
    empDao.setJdbcTemplate(jdbcTemplate());
    return empDao;
  }
}