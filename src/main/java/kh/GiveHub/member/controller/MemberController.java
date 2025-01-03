package kh.GiveHub.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class MemberController {
    @GetMapping("/main")
    public String adminMain() {
        return "admin/main";
    }

    @GetMapping("/donalist")
    public String donalist() {
        return "admin/donalist";
    }

    @GetMapping("/newslist")
    public String newsList() {
        return "admin/newslist";
    }

    @GetMapping("/NewsManage")
    public String newsManage() {
        return "admin/newsmanage";
    }
}
