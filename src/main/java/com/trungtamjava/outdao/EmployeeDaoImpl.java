package com.trungtamjava.outdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trungtamjava.model.Employee;
@org.springframework.transaction.annotation.Transactional

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Employee> getAllEmployee(){
		String sql ="SELECT * FROM data";
		return jdbcTemplate.query(sql, new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int index) throws SQLException{
				Employee employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setAge(rs.getInt("age"));
				employee.setName(rs.getString("name"));
				return employee;
			}
		});
		
	}
}
