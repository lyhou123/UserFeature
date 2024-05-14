package org.project.user.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "al_forget_password")
@Setter
@Getter
@NoArgsConstructor
public class ForgetPassword {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private int otp;
    private boolean expiredDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


}
