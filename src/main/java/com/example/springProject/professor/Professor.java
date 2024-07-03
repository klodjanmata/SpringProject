package com.example.springProject.professor;

import com.example.springProject.subject.Subject;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table
@Entity(name = "Professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Name cannot be null")
    @Length(min = 3)
    private String name;

    @Email(message = "You must give a valid email!")
    @NotNull(message = "Email cannot be null")
    private String email;

    @ManyToMany
    @JoinTable(
            name = "professor_subject",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects;
}
