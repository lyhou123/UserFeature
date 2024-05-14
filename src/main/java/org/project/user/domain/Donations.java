package org.project.user.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "al_donations")
@Setter
@Getter
@NoArgsConstructor
public class Donations {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private BigDecimal amount;
    private String image;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "post_type")
    private PostType postType;

    @OneToMany(mappedBy = "donations")
    private List<Events> events;
}
