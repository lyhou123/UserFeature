package org.project.user.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "al_post_type")
@Setter
@Getter
@NoArgsConstructor
public class PostType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String type;

    @OneToMany(mappedBy = "postType")
    private List<Post> post;

    @OneToMany(mappedBy = "postType")
    private List<Events> events;

    @OneToMany(mappedBy = "postType")
    private List<Donations> donations;
}
