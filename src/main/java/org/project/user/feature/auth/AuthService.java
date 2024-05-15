package org.project.user.feature.auth;

import org.project.user.feature.auth.dto.AuthRequest;
import org.project.user.feature.auth.dto.AuthRespone;

public interface AuthService {
    AuthRespone login(AuthRequest authRequest);
    AuthRespone signup(AuthRequest authRequest);
    AuthRespone refreshToken(String refreshToken);
}
