package org.project.user.feature.user.dto;
import lombok.Builder;

import java.util.Date;

@Builder
public record UserResponse(
        String id,
        String firstName,
        String lastName,
        String gender,
        String email,
        String phoneNumber,
        String avatar,
        boolean isActive,
        boolean isDisable,
        Date createdDate
) {
}
