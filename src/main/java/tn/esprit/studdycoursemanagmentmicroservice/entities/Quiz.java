package tn.esprit.studdycoursemanagmentmicroservice.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private Integer passingScore;
    private Integer timeLimit;
    // TODO Consider @OneToMany for simpler implementation
    @ManyToMany
    private List<Question> questions;

    // TODO relationship with course, module
}
