package kh.GiveHub.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import kh.GiveHub.member.model.vo.Member;
import kh.GiveHub.news.model.vo.News;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;
import kh.GiveHub.member.model.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService mService;

    @GetMapping("/admin/main")
    public String adminMain(Model model) {
        ArrayList<Member> list = mService.selectMemberList();
        model.addAttribute("list", list);
        return "admin/Main";
    }

    @GetMapping("/admin/donalist")
    public String donalist() {
        return "page/DonationList";
    }
    
    @PostMapping("/admin/editMyInfo")
    public String editMyInfo() {
    	return "member/EditMyInfo";
    }
    
    @GetMapping("/admin/checkEmail")
    public void checkEmail(String email, HttpServletResponse response) throws IOException {
    	int result = mService.checkEmail(email);
    	response.getWriter().print(result);
    }

    @GetMapping("/admin/myDonation")
    public String myDonation(){
        return "member/MyDonation";
    }
    
    @GetMapping("member/join")
    public String Join() {
    	return "member/Join";
    }
}
