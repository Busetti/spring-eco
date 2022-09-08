package com.guru.employee.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.h2.engine.User;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

  private JdbcTemplate jdbcTemplate;
  
  public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
    this.jdbcTemplate = jdbcTemplate;
  }

  public String getEmployeeName(int id) {
    String sql = "select name from employee where id = ?";
    String name = jdbcTemplate.queryForObject(sql,new Object[]{id},String.class);
    return name;
  }

  
  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void batchInsert(List<Employee> employees) {
    StopWatch timer = new StopWatch();
    String sql = "INSERT INTO `EMPLOYEE` (ID, AGE, NAME)"
        + " VALUES(?,?,?)";
    timer.start(); 
    jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps, int i) throws SQLException {
        Employee user = employees.get(i);
        ps.setInt(1, user.getId());
        ps.setInt(2, user.getAge());
        ps.setString(3, user.getName());
      }
      @Override
      public int getBatchSize() {
        return employees.size();
      }
    });
    timer.stop();
    System.out.println("batchInsert -> Total time in seconds: " + timer.getTotalTimeSeconds());
  }
}