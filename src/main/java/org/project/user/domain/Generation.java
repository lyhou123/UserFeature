package org.project.user.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "al_generations")
@Setter
@Getter
@NoArgsConstructor
public class Generation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name_type;
    private String num_gen;

    @ManyToOne
    private UserDetails userDetails;
}
