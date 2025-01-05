package kh.GiveHub.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.GiveHub.member.model.service.MemberService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class MemberController {

    //private final MemberService mService;

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
    
    @PostMapping("/editMyInfo")
    public String editMyInfo() {
    
    	return "member/EditMyInfo";
    }
}
