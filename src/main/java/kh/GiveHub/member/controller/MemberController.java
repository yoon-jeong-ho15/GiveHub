package kh.GiveHub.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kh.GiveHub.member.model.service.MemberService;
import kh.GiveHub.member.model.vo.Member;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@SessionAttributes("loginUser")
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
    		return "redirect:/";
    	}else {
    		return "redirect:/member/login";
    	}
    }
    
    //로그아웃
    @GetMapping("/member/logout")
	   public String logout(SessionStatus session) {
	      session.setComplete();  
	      return "redirect:/";
	}

    //회원가입
    @GetMapping("/member/enroll")
    public String enroll() {
    	return "member/enroll";
    }
    
    @PostMapping("/member/enroll")
    public void enroll(@ModelAttribute Member m) {
    	System.out.println(m);
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
