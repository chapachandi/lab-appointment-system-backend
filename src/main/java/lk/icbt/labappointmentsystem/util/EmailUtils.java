package lk.icbt.labappointmentsystem.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailUtils {
    @Value("{spring.mail.username}")
    private String username;
    @Value("{spring.mail.password}")
    private String password;

    public void sendEmail(String to, String subject, String text, JavaMailSender javaMailSender) {
        SimpleMailMessage message = new SimpleMailMessage();
//        javaMailSender.set
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

}
