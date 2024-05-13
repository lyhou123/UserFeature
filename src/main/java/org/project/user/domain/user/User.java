package org.project.user.domain.user;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "users_tbl")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String phoneNumber;
    private String avatar;
    private boolean isActive;
    private boolean isDisable;
    private Date createdDate;
}
