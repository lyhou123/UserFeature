package org.project.user.feature.security;


import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.project.user.feature.user.repository.UserRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Data
@RequiredArgsConstructor
@Component
public class JwtToUserConverter implements Converter<Jwt, JwtAuthenticationToken> {

    private final UserRepository userRepository;

    @Override
    public JwtAuthenticationToken convert(Jwt source) {
        var User = userRepository.findByEmail(source.getSubject()).orElseThrow(()->
                new IllegalArgumentException("User not found"));

        UserDetail userDetail = new UserDetail();

        userDetail.setUser(User);

        return new JwtAuthenticationToken(source, userDetail.getAuthorities());
    }

//    @Override
//    public UsernamePasswordAuthenticationToken convert(Jwt source) {
//        User user = userRepository.findByEmail(source.getSubject()).orElseThrow(()->
//                new IllegalArgumentException("User not found"));
//
//        UserDetail userDetail = new UserDetail();
//        userDetail.setUser(user);
//
//         userDetail.getAuthorities().forEach(
//                 authority -> System.out.println(authority.getAuthority())
//         );
//
//        return new UsernamePasswordAuthenticationToken(
//                userDetail,
//                "",
//                userDetail.getAuthorities());
//    }
}
