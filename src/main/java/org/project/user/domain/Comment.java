package org.project.user.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "al_comment")
@Setter
@Getter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String comment;
    private boolean createdDate;
    private boolean updatedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;


    @OneToMany(mappedBy = "comment")
    private List<Replies> replies;
}
