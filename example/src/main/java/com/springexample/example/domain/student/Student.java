package com.springexample.example.domain.student;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate birthday;
    private Integer age;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                '}';
    }

    /* Constructors */

    public Student() {
    }

    //<editor-fold desc="Constructor with id" defaultstate="collapsed">

    public Student(Long id, String name, String email, LocalDate birthday, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.age = age;
    }

    //</editor-fold>

    //<editor-fold desc="Constructor without id" defaultstate="collapsed">

    public Student(String name, String email, LocalDate birthday, Integer age) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.age = age;
    }

    //</editor-fold>

    /* Getters and Setters */

    //<editor-fold desc="Getters and Setters" defaultstate="collapsed">

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    //</editor-fold>

}
