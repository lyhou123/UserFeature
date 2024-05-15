package org.project.user.feature.auth.dto;

import lombok.Builder;

@Builder
public record AuthResponse(String userId,
        String accessToken,
        String refreshToken) {
}
