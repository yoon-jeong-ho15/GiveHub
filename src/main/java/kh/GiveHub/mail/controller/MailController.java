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
    @PostMapping("/emailCheck") // 이 부분은 각자 바꿔주시면 됩니다.
    public String emailCheck(@RequestParam("email") String mail) throws MessagingException, UnsupportedEncodingException {
        String authCode = mailService.sendSimpleMessage(mail);
        return authCode; // Response body에 값을 반환
    }
}
