package lk.icbt.labappointmentsystem.controller;

import lk.icbt.labappointmentsystem.dto.CreateFinalResultDTO;
import lk.icbt.labappointmentsystem.dto.ReservationDTO;
import lk.icbt.labappointmentsystem.service.EmailService;
import lk.icbt.labappointmentsystem.util.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/senEmail")
@CrossOrigin
public class AController {

    private final EmailService emailService;

    public AController(EmailService emailService) {
        this.emailService = emailService;
    }
    @GetMapping(value = "/sendmail")
    public String sendmail() {

        emailService.sendMail("chapachandi@gmail.com", "Test Subject", "Test mail");

        return "emailsent";
    }
}
