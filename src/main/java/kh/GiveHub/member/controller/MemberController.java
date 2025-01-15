package kh.GiveHub.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kh.GiveHub.member.model.service.MemberService;
import kh.GiveHub.member.model.vo.Member;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	
    private final MemberService mService;
    
    //로그인 화면 연결
    @GetMapping("/member/login")
    public String logIn() {
    	return "/member/login";
    }
    
    //로그인
    @PostMapping("/member/login")
    public String login(Member m, HttpSession session) {
    	
    	Member loginUser = mService.login(m);
    	if(loginUser != null) {
    		session.setAttribute("loginUser", loginUser);
    		return "redirect:/index";
    	}else {
    		return "";
    	}
    }

    
    
    
    
    
    
    
    
    
    
    
    @GetMapping("/admin/main")
    public String adminMain(Model model) {
        ArrayList<Member> list = mService.selectMemberList();
        model.addAttribute("list", list);
        return "main";
    }

    @GetMapping("/admin/donalist")
    public String donalist() {
        return "donationlist";
    }
    
    @PostMapping("/admin/editMyInfo")
    public String editMyInfo() {
    	return "editmyinfo";
    }
    
    @GetMapping("/admin/checkEmail")
    public void checkEmail(String email, HttpServletResponse response) throws IOException {
    	int result = mService.checkEmail(email);
    	response.getWriter().print(result);
    }

    @GetMapping("/admin/myDonation")
    public String myDonation(){
        return "mydonation";
    }
    
    @GetMapping("member/join")
    public String Join() {
    	return "join";
    }
}
