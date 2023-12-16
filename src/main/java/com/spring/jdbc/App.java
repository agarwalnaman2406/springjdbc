package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
//        JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
        
        // Insert Query
//        String query = "insert into student(id, name, city) values(?,?,?)";
        // fire Query
//        int result = template.update(query,456,"Akash","Delhi");
        
        
       // Created Dao Class to update the data so that it can be loosely coupled 
//        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
//        Student student = new Student(123,"Somya","Sitapur");
//        int result = studentDao.insert(student);
//        Student student = new Student(123,"Devansh","Sitapur-");
//        int result = studentDao.change(student);
//        Student student = new Student();
//        student.setId(456);
//        int result = studentDao.delete(student);
//        Student student = studentDao.getStudent(222);
//        List<Student> students = studentDao.getAllStudents();
//        for(Student s: students) {
//        	System.out.println(s);
//        }
//        System.out.println("number of records inserted.."+result);
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        Student student = new Student(1243,"Somya","Sitapur");
        int result = studentDao.insert(student);
        System.out.println("number of records inserted.."+result);
        List<Student> students = studentDao.getAllStudents();
        for(Student s: students) {
        	System.out.println(s);
        }
    }
}
