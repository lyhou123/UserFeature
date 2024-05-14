package org.project.user.feature.mail.service;

import jakarta.mail.MessagingException;
import org.project.user.feature.mail.dto.MailRequest;
import org.project.user.feature.mail.dto.MailRespone;

public interface MailService {
   MailRespone sendMail(MailRequest mailRequest) throws MessagingException;
   void sendOtpEmail(String email, String otp) throws MessagingException;

}
