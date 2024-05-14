package org.project.user.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "al_share")
@Setter
@Getter
@NoArgsConstructor
public class Share {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String description;
    private boolean createdDate;
    private boolean updatedDate;

    //relationship user_id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
