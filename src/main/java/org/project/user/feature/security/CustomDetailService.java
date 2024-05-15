package org.project.user.feature.security;

import lombok.RequiredArgsConstructor;
import org.project.user.feature.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        var userEmail = userRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));

       UserDetail userDetail = new UserDetail();

         userDetail.setUser(userEmail);

        return userDetail;
    }
}
