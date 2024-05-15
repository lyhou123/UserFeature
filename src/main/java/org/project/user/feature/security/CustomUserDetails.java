package org.project.user.feature.security;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.project.user.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CustomUserDetails implements UserDetails {
    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles();
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
