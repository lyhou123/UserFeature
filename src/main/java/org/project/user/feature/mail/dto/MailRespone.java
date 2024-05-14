package org.project.user.feature.mail.dto;

import lombok.Builder;

@Builder
public record MailRespone(
        String message
) {
}
