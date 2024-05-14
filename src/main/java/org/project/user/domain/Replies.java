package org.project.user.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "al_replies")
@Setter
@Getter
@NoArgsConstructor
public class Replies {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String replyTitle;
    private Date createdDate;
    private Date updatedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
