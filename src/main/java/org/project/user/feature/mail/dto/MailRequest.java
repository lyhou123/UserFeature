package org.project.user.feature.mail.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record MailRequest(
        @NotBlank(message = "Email to is required")
        String sendTo,
        String Subject,
        String body
) {
}
