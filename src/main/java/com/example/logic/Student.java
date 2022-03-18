package com.example.logic;

import java.time.LocalDate;

public class Student {
    private String code;
    private String surname;
    private String name;
    private TypeGender gender;
    private String city;
    private LocalDate birthday;
    private String email;
    private double subsidy;

    public Student(String code, String surname, String name, TypeGender gender, String city, LocalDate birthday, String email, double subsidy) {
        this.code = code;
        this.surname = surname;
        this.name = name;
        this.gender = gender;
        this.city = city;
        this.birthday = birthday;
        this.email = email;
        this.subsidy = subsidy;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeGender getGender() {
        return gender;
    }

    public void setGender(TypeGender gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(double subsidy) {
        this.subsidy = subsidy;
    }

    @Override
    public String toString() {
        return "Student{" +
                "code='" + code + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", city='" + city + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", subsidy=" + subsidy +
                '}';
    }
}
