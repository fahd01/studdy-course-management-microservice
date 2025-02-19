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
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private ContentType contentType;
    private String content_url;
    private int duration;
    private int position;
    private LocalDateTime created_at;

    @OneToOne
    private Progress progress;
}
