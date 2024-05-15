package org.project.user.feature.auth.dto;

public record AuthRequest(
    String email,
    String password
            )
{
}
