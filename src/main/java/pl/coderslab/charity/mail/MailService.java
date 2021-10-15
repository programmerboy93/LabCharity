package pl.coderslab.charity.mail;

import org.springframework.mail.MailMessage;
import org.springframework.stereotype.Service;

@Service
public interface MailService {
    String sendMailWithNewPassword(String emailTo, String tokenValue);

    String sendMailWithNewToken(String emailTo, String tokenValue);

    MailMessage prepareMessage(String to, String url, String subject);
}
