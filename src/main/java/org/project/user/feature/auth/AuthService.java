package org.project.user.feature.auth;



import org.project.user.feature.auth.dto.AuthRequest;
import org.project.user.feature.auth.dto.AuthResponse;
import org.project.user.feature.auth.dto.RefreshTokenRequest;

public interface AuthService {
    AuthResponse login(AuthRequest loginRequest);
    AuthResponse refresh(RefreshTokenRequest request);
    void logout(String refreshToken);
}
