package org.project.user.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "al_users")
@Setter
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String phoneNumber;
    private String avatar;
    private boolean isActive;
    private boolean isDisable;
    private Date createdDate;

    @OneToOne(mappedBy = "user")
    private UserDetails userDetails;

    @OneToMany(mappedBy = "user")
    private List<UserSocialMedia> userSocialMedia;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Jobs jobs;

    //report relationship
    @OneToMany(mappedBy = "user")
    private List<Report> reports;

    //share relationship
    @OneToMany(mappedBy = "user")
    private List<Share> shares;

    //comment relationship
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @OneToMany(mappedBy = "user")
    private List<Replies> replies;

    //relationship with forget password
    @OneToOne(mappedBy = "user")
    private ForgetPassword forgetPassword;

}
