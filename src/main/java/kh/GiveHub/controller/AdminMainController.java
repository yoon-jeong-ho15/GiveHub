package kh.GiveHub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/admin")
public class AdminMainController {
    @GetMapping("/main")
    public String adminMain() {
        return "admin/main";
    }

    @GetMapping("/DonationList")
    public String donationList() {
        return "admin/donationlist";
    }
}
