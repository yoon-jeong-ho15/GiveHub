package kh.GiveHub.admin.controller;

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

    @GetMapping("/newslist")
    public String newsList() {
        return "admin/newslist";
    }

    @GetMapping("/NewsManage")
    public String newsManage() {
        return "admin/newsmanage";
    }
}
