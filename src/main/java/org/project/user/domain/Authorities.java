package org.project.user.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "al_authorities")
public class Authorities {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
}
