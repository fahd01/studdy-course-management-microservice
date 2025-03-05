package tn.esprit.studdycoursemanagmentmicroservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private ContentType contentType;
    private String contentUrl;
    private Integer duration;
    private Integer position;
    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToOne
    private Course course;

    @OneToMany(mappedBy = "module")
    private List<ModuleCompletion> completions;
}
