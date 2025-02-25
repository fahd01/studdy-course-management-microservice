package tn.esprit.studdycoursemanagmentmicroservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String progressStatus;
    private LocalDateTime started_at;
    private LocalDateTime completed_at;


    @OneToOne(mappedBy = "progress")
    private Enrollment enrollment;
    @OneToOne(mappedBy = "progress")
    private Course course;
    @OneToOne(mappedBy = "progress")
    private Lesson lesson;



}
