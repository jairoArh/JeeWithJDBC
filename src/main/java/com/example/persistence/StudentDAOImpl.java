package com.example.persistence;

import com.example.logic.Student;
import com.example.logic.TypeGender;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class StudentDAOImpl implements StudentDAO{
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/uptc";
    private static final String USER = "student";
    private static final String PASSWD = "UPTC1234";

    @Override
    public void addStudent(Student student) {
        try {
            Class.forName( DRIVER );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection =
                    DriverManager.getConnection( URL,USER,PASSWD );
                ){
            Statement statement = connection.createStatement();

            String code = student.getCode();
            String surName = student.getSurname();
            String name = student.getName();
            String gender = student.getGender().equals( TypeGender.FEMENINO ) ? "F" : "M";
            String city = student.getCity();
            String birthday = student.getBirthday().toString();
            String email = student.getEmail();
            String subsidy = Double.toString( student.getSubsidy());



            final String query = "INSERT INTO student VALUES(" + "'" + code + "','" + surName + "','" + name + "','"  + gender + "','" + city + "','" + birthday + "','" + email + "','" + subsidy + "')";

            System.out.println( query );

            statement.execute( query );

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void delete(String code) {

    }

    @Override
    public Student findByCode(String code) {
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try(Connection connection =
                DriverManager.getConnection(URL,USER,PASSWD);
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery("select * from student");
                ){
            while( result.next()){
                String code = result.getString( "code" );
                String surName = result.getString( "surname" );
                String name = result.getString( "name" );
                TypeGender typeGender = result.getString("gender").equals("M") ? TypeGender.MASCULINO : TypeGender.FEMENINO;
                String city = result.getString("city");
                LocalDate birthday = LocalDate.parse( result.getString( "birthday" ) );
                String email = result.getString("email");
                double subsidy = Double.valueOf( result.getString("subsidy"));

                students.add( new Student(code, surName,name,typeGender,city,birthday,email,subsidy));
            }

            return students;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
