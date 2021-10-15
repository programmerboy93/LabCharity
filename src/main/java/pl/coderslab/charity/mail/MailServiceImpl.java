package pl.coderslab.charity.mail;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@Primary
@AllArgsConstructor
@Log4j2
public class MailServiceImpl implements MailService {

    private final static String SUBJECT_REGISTER = "Link do rejestracji na stronie podaruj komuś trochę radości";
    private final static String URL_REGISTER = "http://localhost:8080/register/";
    private final static String EMAIL_ADDRESS = System.getProperty("EMAIL_USERNAME");

    private final static String SUBJECT_FORGOT_PASSWORD = "Przypomnienie hasła do strony podaruj komuś trochę radości";
    private final static String URL_FORGOT_PASSWORD = "http://localhost:8080/forgotPassword/";

    private final JavaMailSender emailSender;

    @Override
    public String sendMailWithNewPassword(String emailTo, String tokenValue) {
        try {
            emailSender.send(prepareMessage(emailTo, URL_FORGOT_PASSWORD + tokenValue, SUBJECT_FORGOT_PASSWORD));
        } catch (MailException e) {
            log.error("Error while sending out email..{}", e.getStackTrace());
            log.error("Error while sending out email..{}", e.fillInStackTrace());
            return "Problem podczas wysyłania email, spróbuj jeszcze raz później";
        }
        return "Email został poprawnie wysłany, sprawdź skrzynkę email.";
    }

    @Override
    public String sendMailWithNewToken(String emailTo, String tokenValue) {
        try {
            emailSender.send(prepareMessage(emailTo, URL_REGISTER + tokenValue, SUBJECT_REGISTER));
        } catch (MailException e) {
            log.error("Error while sending out email..{}", e.getStackTrace());
            log.error("Error while sending out email..{}", e.fillInStackTrace());
            return "Problem podczas wysyłania email, spróbuj jeszcze raz później.";
        }
        return "Email został poprawnie wysłany, sprawdź skrzynkę email.";
    }

    @Override
    public SimpleMailMessage prepareMessage(String to, String url, String subject) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(EMAIL_ADDRESS);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(url);
        return message;
    }
}
