package tn.esprit.studdycoursemanagmentmicroservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Lob
    private String description;
    private String thumbnailUrl;
    @Enumerated(EnumType.STRING)
    private CourseStatus status;
    @CreatedDate
    private LocalDateTime createdAt;
    private float price;
    private int duration;
    @Enumerated(EnumType.STRING)
    private Level Level;
    //private float Rating;
    //private int totalEnrollements;

    @ManyToOne
    private Category category;
    @OneToOne
    private Progress progress;
}
