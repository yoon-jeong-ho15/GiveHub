package kh.GiveHub.member.model.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class RecaptchaService {

    @Value("${recaptcha.secret}")
    private String secretKey;

    private final String VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";

    public boolean verifyRecaptcha(String token) {
        RestTemplate restTemplate = new RestTemplate();

        // reCAPTCHA 검증 요청 파라미터
        String url = UriComponentsBuilder.fromHttpUrl(VERIFY_URL)
                .queryParam("secret", secretKey)
                .queryParam("response", token)
                .toUriString();

        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, null, Map.class);

        return response.getBody() != null && (Boolean) response.getBody().get("success");
    }
}

