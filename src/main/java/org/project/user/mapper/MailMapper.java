package org.project.user.mapper;

import org.mapstruct.Mapper;
import org.project.user.feature.mail.dto.MailRequest;
import org.project.user.feature.mail.dto.MailRespone;

@Mapper(componentModel = "spring")
public interface MailMapper {
    MailRespone mapToMailRespone(MailRequest mailRequest);
}
