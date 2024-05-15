package org.project.user.feature.auth;


import lombok.RequiredArgsConstructor;
import org.project.user.feature.auth.dto.AuthRequest;
import org.project.user.feature.auth.dto.AuthResponse;
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
public class AuthServiceImpl implements AuthService{
    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    private final DaoAuthenticationProvider daoAuthenticationProvider;
    private final TokenGenerator tokenGenerator;

    @Override
    public AuthResponse login(AuthRequest loginRequest) {
        Authentication authentication = daoAuthenticationProvider
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));
        return tokenGenerator.generateTokens(authentication);
    }

    @Override
    public AuthResponse refresh(RefreshTokenRequest request) {
        Authentication authentication = jwtAuthenticationProvider
                .authenticate(new BearerTokenAuthenticationToken(request.refreshToken()));
        return tokenGenerator.generateTokens(authentication);
    }

    @Override
    public void logout(String refreshToken) {

    }

}
