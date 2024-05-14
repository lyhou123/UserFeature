package org.project.user.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "al_report")
@Setter
@Getter
@NoArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
