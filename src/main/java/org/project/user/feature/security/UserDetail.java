package org.project.user.feature.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.project.user.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class UserDetail implements UserDetails {

    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        user.getRoles().forEach(role -> {
            authorities.add(role);
            role.getAuthorities().forEach(authority -> {
                authorities.add(authority::getName);
            });
        });

        return authorities;

    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !user.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !user.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return !user.isEnabled();
    }
}
