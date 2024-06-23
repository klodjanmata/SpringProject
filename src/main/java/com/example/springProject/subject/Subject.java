package com.example.springProject.subject;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table
@Entity(name = "Subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Length(min = 5, max = 50, message = "Name must be between 5 and 50")
    private String name;
    @Null
    private String description;
    @Range(min = 1, max = 2, message = "Credits must be between 1, 2")
    private float credits;

}
