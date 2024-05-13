package org.project.user.feature.user.dto;

import jakarta.validation.Valid;
import lombok.Builder;
import lombok.NonNull;

import java.util.Date;
@Builder
public record UserRequest(
        String firstName,
        String lastName,
        String gender,
        @NonNull
        String email,
        String phoneNumber,
        String avatar,
        boolean isActive,
        boolean isDisable,
        Date createdDate

) {
}
