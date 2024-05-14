package org.project.user.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "al_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false,length = 25)
    private String roleName;

    @ManyToMany
    private Set<Authorities> authoritiesSet;
}
