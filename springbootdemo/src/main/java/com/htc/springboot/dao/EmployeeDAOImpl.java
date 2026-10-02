package com.htc.springboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.htc.springboot.model.Employee;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired  //by type
	JdbcTemplate jdbcTemplate;
		

	public boolean addEmployee(Employee emp) {

		int result = jdbcTemplate.update("insert into employees values(?,?,?,?)", emp.getEmpno(), emp.getEname(), emp.getJob(), emp.getSalary());
		if(result > 0) 
			return true;

		return false;
	}

	public boolean addEmployee(int empno, String ename, String job, double salary) {
		return addEmployee(new Employee(empno,ename, job, salary));
	}

	public Employee getEmployee(int empno) {

		Employee emp = null;
		emp = jdbcTemplate.queryForObject("select empno, ename, job, salary from employees where empno = ?",
				                    new RowMapper<Employee>() {
										public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
											Employee e = new Employee();
											e.setEmpno(rs.getInt(1));
											e.setEname(rs.getString(2));
											e.setJob(rs.getString(3));
											e.setSalary(rs.getDouble(4));
											return e;
										}
			
									}, new Object[] {empno});
		return emp;
	}

	public List<Employee> getEmployees() {
		
		List<Employee> empList = null;

		empList = jdbcTemplate.query("select empno, ename, job, salary from employees", 
							new RowMapper<Employee>() {

								public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
									Employee e = new Employee();
									e.setEmpno(rs.getInt(1));
									e.setEname(rs.getString(2));
									e.setJob(rs.getString(3));
									
									e.setSalary(rs.getDouble(4));
									return e;
							
								}
				
							});
		return empList;
	}

	public boolean deleteEmployee(int empno) {
		
		NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		Map<String, Integer> params = new HashMap<String,Integer>();
		params.put("eno", empno);
		System.out.println(empno);
		int result = npjt.update("delete from employees where empno=:eno", params);
		if(result>0) 
			return true;
		return false;
	}


	@Override
	public boolean updateEmployee(Employee newemp) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
		        .withFunctionName("updateemp")
		        .declareParameters(new SqlParameter("sal", Types.INTEGER),
		        		new SqlParameter("enam", Types.VARCHAR),
		        		new SqlParameter("jo", Types.VARCHAR),
		        				   new SqlParameter("empn", Types.INTEGER));
		    
		    SqlParameterSource in = new MapSqlParameterSource().addValue("empn", newemp.getEmpno()).addValue("enam",newemp.getEname()).addValue("jo",newemp.getJob());
		    
		    ((MapSqlParameterSource) in).addValue("sal", newemp.getSalary());
		    
		    System.out.println("callable="+newemp.getEmpno()+"callable="+newemp.getSalary()+newemp.getJob()+newemp.getEname());
		     simpleJdbcCall.executeFunction(String.class, in);
		     
		    return true;
		
		
	}

/*
 
 	public void procedureCallDemo(String productCode) {
		
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
										.withProcedureName("GETPRODUCTDETAILS")
										.useInParameterNames("pcode")
										.declareParameters(
												new SqlParameter("pcode", Types.VARCHAR),
												new SqlOutParameter("product_desc", Types.VARCHAR),
												new SqlOutParameter("unitprice", Types.DECIMAL)
										);
										
			Map<String, Object> result  = jdbcCall.execute(productCode);
			
			System.out.println(result.get("product_desc"));
			System.out.println(result.get("unitprice"));
	}

 */
}
