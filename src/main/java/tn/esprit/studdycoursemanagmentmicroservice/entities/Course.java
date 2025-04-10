package tn.esprit.studdycoursemanagmentmicroservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private Level level;
    // TODO is live
    private Boolean live;
    //private float Rating;
    //private int totalEnrollements;

    @ManyToOne
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Module> modules;
}
