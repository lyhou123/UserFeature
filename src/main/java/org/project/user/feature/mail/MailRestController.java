package org.project.user.feature.mail;

import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.project.user.feature.mail.dto.MailRequest;
import org.project.user.feature.mail.dto.MailRespone;
import org.project.user.feature.mail.service.MailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mail")
@RequiredArgsConstructor
public class MailRestController {

    private final MailService mailService;

    @PostMapping
    public MailRespone sendMail(@Valid  @RequestBody  MailRequest mailRequest) throws MessagingException {
        return mailService.sendMail(mailRequest);
    }

    }


