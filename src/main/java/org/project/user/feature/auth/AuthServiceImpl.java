package org.project.user.feature.auth;

import lombok.RequiredArgsConstructor;
import org.project.user.feature.auth.dto.AuthRequest;
import org.project.user.feature.auth.dto.AuthRespone;
import org.project.user.feature.auth.dto.RefreshTokenRequest;
import org.project.user.feature.security.TokenGenerator;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl {

    private final DaoAuthenticationProvider daoAuthenticationProvider;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    private final TokenGenerator tokenGenerator;

    public AuthRespone login(AuthRequest request) {
        Authentication authentication = daoAuthenticationProvider
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.email(),
                                request.password()
                        )
                );
        return tokenGenerator.generateTokens(authentication);
    }

    public AuthRespone refreshToken(RefreshTokenRequest request) {

        Authentication authentication = jwtAuthenticationProvider
                .authenticate(
                        new BearerTokenAuthenticationToken(request.refreshToken())
                );
        return tokenGenerator.generateTokens(authentication);

    }



}
