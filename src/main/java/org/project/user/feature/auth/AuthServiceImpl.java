package org.project.user.feature.auth;

import lombok.RequiredArgsConstructor;
import org.project.user.feature.auth.dto.AuthRequest;
import org.project.user.feature.auth.dto.AuthRespone;
import org.project.user.feature.auth.dto.RefresTokenRequest;
import org.project.user.feature.security.TokenGenerator;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl {

    private final TokenGenerator tokenGenerator;

    private final JwtEncoder jwtRefreshTokenEncoder;

    private final JwtDecoder jwtRefreshTokenDecoder;

    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    private final DaoAuthenticationProvider daoAuthenticationProvider;

    public AuthRespone login(AuthRequest authRequest) {
        Authentication authentication = daoAuthenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.email(), authRequest.password())
        );
        return tokenGenerator.generateTokens(authentication);
    }

    public AuthRespone refreshToken(RefresTokenRequest refresTokenRequest)
    {
       Authentication authentication = jwtAuthenticationProvider.authenticate(
               new BearerTokenAuthenticationToken(refresTokenRequest.refreshToken())
       );
       return tokenGenerator.generateTokens(authentication);
    }


}
