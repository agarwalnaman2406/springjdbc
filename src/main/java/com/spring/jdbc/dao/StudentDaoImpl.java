package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
		// TODO Auto-generated method stub
		String query = "insert into student(id, name, city) values(?,?,?)";
		int result = jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return result;
	}

	public int change(Student student) {
		// TODO Auto-generated method stub
		String query = "update student set name=? , city=? where id=?";
		int result = jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return result;
	}

	public int delete(Student student) {
		// TODO Auto-generated method stub
		String query = "delete from student where id = ?";
		int result = jdbcTemplate.update(query,student.getId());
		return result;
	}

	public Student getStudent(int studentId) {
		// Selecting SIngle Student Data
		String query = "select * from student where id = ?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return student;
	}

	public List<Student> getAllStudents() {
		// Selectin Multiple Student
		String query = "select * from student";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		return jdbcTemplate.query(query, rowMapper);
	}

}
