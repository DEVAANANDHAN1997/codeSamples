package com.htc.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.htc.spring.beans.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean addEmployee(Employee emp) {
		System.out.println("Overrided Method 1");
		int result = jdbcTemplate.update("insert into employees values(?,?,?,?)", emp.getEmpno(), emp.getEname(), emp.getJob(), emp.getSalary());
		if(result>0)
			return true;
		return false;
	}

	@Override
	public boolean addEmployee(int empno, String empname, String job, double salary) {
		System.out.println("Overrided Method 2");
		return addEmployee(new Employee(empno,empname,job,salary));
	}

	@Override
	public boolean deleteEmployee(int empno) {
		NamedParameterJdbcTemplate named_param_jdbc_temp = new NamedParameterJdbcTemplate(jdbcTemplate);
		Map<String , Integer> params = new HashMap<String, Integer>();
		params.put("eno",empno);
		System.out.println(params);
		int result = named_param_jdbc_temp.update("delete from employees where empno=:eno",params);
		if(result>0)
			return true;
		return false;
	}

	@Override
	public boolean updataEmployee(Employee newemp) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
		        .withFunctionName("updateemp")
		        .declareParameters(new SqlParameter("sal", Types.INTEGER),
		        				   new SqlParameter("empno", Types.INTEGER));
		    
		    SqlParameterSource in = new MapSqlParameterSource().addValue("no", newemp.getEmpno());
		    ((MapSqlParameterSource) in).addValue("sal", newemp.getSalary());
		    System.out.println("callable="+newemp.getEmpno()+"callable="+newemp.getSalary());
		     simpleJdbcCall.executeFunction(String.class, in);
		     
		    return true;
		
		
	}

	@Override
	public Employee getEmployee(int empno) {
		Employee emp = null;
		emp = jdbcTemplate.queryForObject("select empno, ename, job, salary from employees where empno = ?", 
				 new Object[] {empno},
				 new RowMapper<Employee>()
				 {

					@Override
					public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
						Employee e = new Employee();
						e.setEmpno(rs.getInt(1));
						e.setEname(rs.getString(2));
						e.setJob(rs.getString(3));
						e.setSalary(rs.getDouble(4));
						return e;
					}
			
				 });
		
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> emplist = null;
		
		emplist = jdbcTemplate.query("select empno,ename,job,salary from employees",
				new RowMapper<Employee>() {

					@Override
					public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
						Employee e = new Employee();
						e.setEmpno(rs.getInt(1));
						e.setEname(rs.getString(2));
						e.setJob(rs.getString(3));
						e.setSalary(rs.getDouble(4));
						return e;
					}});
		return emplist;
	}
	

}
