package org.project.user.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "al_jobs")
@Setter
@Getter
@NoArgsConstructor
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private String position;
    private String companyName;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String poster;
    private String status;
    private boolean createdDate;
    private boolean updatedDate;


}

