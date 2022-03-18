package com.example.persistence;

import com.example.logic.Student;
import com.example.logic.TypeGender;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOImplTest {

    private  StudentDAOFactoty factoty = new StudentDAOFactoty();

    @Test
    void addStudent() {
        factoty.createStudentDAO().addStudent( new Student("32453","Perez Buitrago","Jose Luis", TypeGender.MASCULINO,"Sogamoso", LocalDate.of(1990, Month.APRIL,21),"jose@gamil.com",450000));
    }

    @Test
    void updateStudent() {
    }

    @Test
    void delete() {
    }

    @Test
    void findByCode() {
    }

    @Test
    void getAllStudents() {
        factoty.createStudentDAO().getAllStudents()
                .forEach(System.out::println);
    }
}