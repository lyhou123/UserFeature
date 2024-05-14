package org.project.user.feature.mail.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.project.user.feature.mail.dto.MailRequest;
import org.project.user.feature.mail.dto.MailRespone;
import org.project.user.feature.user.repository.UserRepository;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MailService{

    private final JavaMailSender mailSender;


    private final UserRepository userRepository;

    @Override
    public MailRespone sendMail(MailRequest mailRequest) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        mimeMessageHelper.setTo(mailRequest.sendTo());

        mimeMessageHelper.setSubject(mailRequest.Subject());

        mimeMessageHelper.setText(mailRequest.body());

        mailSender.send(mimeMessage);

        return null;
    }

    @Override
       public void sendOtpEmail(String email, String otp) throws MessagingException {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setSubject("Verify OTP");
            mimeMessageHelper.setText("""
            <div>
            <a href="http://localhost:8080/verify-account?email=%s&otp=%s" target="_blank">click link to verify</a>
            </div>
            """.formatted(email, otp), true);

            mailSender.send(mimeMessage);
        }

}
