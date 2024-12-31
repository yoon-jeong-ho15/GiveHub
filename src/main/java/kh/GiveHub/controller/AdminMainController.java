package kh.GiveHub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminMainController {
    @GetMapping("/main")
    public String adminMain() {
        return "admin/main";
    }

    @GetMapping("/NewsList")
    public String donationList() {
        return "admin/newslist";
    }

    @GetMapping("/NewsManage")
    public String donationManage() {
        return "admin/newsmanage";
    }
}
