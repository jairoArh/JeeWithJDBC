package com.example.persistence;

public class StudentDAOFactoty {
    public StudentDAO createStudentDAO(){

        return new StudentDAOImpl();
    }
}
