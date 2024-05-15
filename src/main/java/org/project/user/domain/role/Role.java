package org.project.user.domain.role;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.project.user.domain.role.Authorities;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Table(name = "al_role")
@Setter
@Getter
@NoArgsConstructor
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false,length = 25)
    private String roleName;
    @Override
    public String getAuthority() {
        return "ROLE_"+this.roleName;
    }
    @ManyToMany
    private Set<Authorities> authorities;


}
