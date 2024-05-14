package org.project.user.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;
import java.util.List;

@Entity
@Table(name = "al_user_details")
@Setter
@Getter
@NoArgsConstructor
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(length = 255)
    private String address;

    @Column(length = 255)
    private String generation;

    @Column(length = 255)
    private String company;

    @Column(length = 255)
    private String position;

    @Column(length = 255)
    private String education;

    @Column(length = 255)
    private String experience;

    @Column(length = 255)
    private String skill;

    @Column(length = 255)
    private String language;

    @Column(length = 255)
    private String cv_url;

    @Temporal(TemporalType.DATE)
    private Date created_at;

    @Temporal(TemporalType.DATE)
    private Date updated_at;

    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "userDetails")
    private List<Generation> generations;

}
