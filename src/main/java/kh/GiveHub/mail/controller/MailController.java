package kh.GiveHub.mail.controller;

import jakarta.mail.MessagingException;
import kh.GiveHub.mail.model.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @ResponseBody
    @PostMapping("/emailCheck") // ajax로 보낸 email을 받아서 넘기기
    public String emailCheck(@RequestParam("email") String mail) throws MessagingException, UnsupportedEncodingException {
        return mailService.sendSimpleMessage(mail);
    }
}
