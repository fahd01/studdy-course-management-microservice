package com.esprit.microservice.stagemicroservice.stagemicroservice.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    private String title;
    private String location;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String phone;

    @Column(name = "is_visible")
    private Boolean isVisible;
}