package tn.esprit.studdycoursemanagmentmicroservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import tn.esprit.studdycoursemanagmentmicroservice.utils.StringListConverter;

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
    @Lob
    private String description;
    private Integer duration;
    private Integer position;
    @Convert(converter = StringListConverter.class)
    private List<String> externalLinks;

    @ManyToOne
    @JsonIgnore
    private Course course;

    @OneToMany(mappedBy = "module")
    private List<ModuleCompletion> completions;
    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL)
    private List<ModuleAttachment> attachments;
    //@OneToMany
    //private List<ModuleContent> contents;

    @Override
    public String toString() {
        return "Module: " + id + " - " + title;
    }
}
