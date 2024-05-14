package org.project.user.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "al_user_social_media")
@Setter
@Getter
@NoArgsConstructor
public class UserSocialMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private String id;
    private String name;
    private String socialMediaLink;

    @ManyToOne
    private User user;
}
