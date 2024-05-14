package org.project.user.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "al_post")
@Setter
@Getter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String description;
    private String thumbnail;
    private int likes;
    private int shares;

    private Date createdDate;
    private Date updatedDate;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @OneToMany(mappedBy = "post")
    private List<Replies> replies;

    @OneToMany(mappedBy = "post")
    private List<Share> share;

    @ManyToOne
    @JoinColumn(name = "post_type")
    private PostType postType;


}
