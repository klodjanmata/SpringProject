package com.example.springProject.student;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "Student")
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Name cannot be null")
    @Length(min = 3)
    private String name;

    @Email(message = "You must give a valid email!")
    @NotNull(message = "Email cannot be null")
    @Length(min = 5, message = "Length must be more than 5")
    private String email;

    private LocalDate dob;
    @Transient
    private int age;

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public int getAge(){
        return Period.between(dob, LocalDate.now()).getYears();
    }
}
