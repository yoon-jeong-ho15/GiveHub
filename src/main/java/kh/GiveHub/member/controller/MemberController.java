package kh.GiveHub.member.controller;

import java.util.ArrayList;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.servlet.http.HttpSession;
import kh.GiveHub.member.model.exception.MemberException;
import kh.GiveHub.member.model.service.MemberService;
import kh.GiveHub.member.model.vo.Member;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@SessionAttributes("loginUser")
public class MemberController {

    private final MemberService mService;
    
    private final BCryptPasswordEncoder bcrypt;

    //로그인 화면 연결
    @GetMapping("/member/login")
    public String logIn() {
    	return "/member/login";
    }

    //로그인
//    @PostMapping("/member/login")
//    public String login(Member m, HttpSession session) {
//
//    	Member loginUser = mService.login(m);
//    	if(loginUser != null) {
//    		session.setAttribute("loginUser", loginUser);
//    		return "redirect:/";
//    	}else {
//    		return "";
//    	}
//    }
    
    @PostMapping("/member/login")
    public String login(Member m, Model model) {
    	Member loginUser = mService.login(m);
    	if(loginUser != null && bcrypt.matches(m.getMemPwd(), loginUser.getMemPwd())) {
    		model.addAttribute("loginUser", loginUser);
    		System.out.println(bcrypt.encode("1111"));
    		return "redirect:/";
    	}else {
    		return "";
    	}
    }
    

    //로그아웃
    @GetMapping("/member/logout")
	   public String logout(SessionStatus session) {
	      session.setComplete();
	      return "redirect:/";
	}
    
    
    // 회원가입
    @GetMapping("/member/join")
    public String Join() {
        return "/member/join";
    }

    @PostMapping("/member/join")
    public String Join(Member m) {
        if (m.getMemType().equals("1")){
            m.setMemConfirm("W");
        }else{
            m.setMemConfirm("Y");
        }
        m.setMemGrade("UNRANK");
        m.setMemPwd(bcrypt.encode(m.getMemPwd()));
        int result = mService.memberJoin(m);
        if (result > 0) {
            return "redirect:/";
        }
        System.out.println(bcrypt);
        throw new MemberException("실패");
    }

    @GetMapping("/member/join.id")
    @ResponseBody
    public int checkId(@RequestParam("id") String id) {
        return mService.checkId(id);
    }
  
    @PostMapping("/admin/editMyInfo")
    public String editMyInfo() {
    	return "editmyinfo";
    }
    
    
    @GetMapping("/member/mypage")
    public String mypage() {
    	return "/member/mypage";
    }
    

    @GetMapping("/admin/myDonation")
    public String myDonation(){
        return "mydonation";
    }

    // 관리자 메인페이지(회원관리 페이지)
    @GetMapping("/admin/main")
    public String adminMain(Model model) {
        ArrayList<Member> list = mService.selectMemberList();
        model.addAttribute("list", list);
        return "/admin/main";
    }

    @GetMapping("/admin/selectNo")
    @ResponseBody
    public Member selectNo(@RequestParam("no") int no) {
        return mService.selectNo(no);
    }

    @PostMapping("/admin/memberUpdate")
    public String adminMemberUpdate(Member m) {
        if (m.getMemType().equals("1")){
            m.setMemConfirm("Y");
        }
        int result = mService.adminMemberUpdate(m);
        if (result > 0) {
            return "redirect:/admin/main";
        }
        throw new MemberException("실패");
    }

    @PostMapping("/admin/memberDelete")
    public String adminMemberDelete(Member m) {
        int result = mService.adminMemberDelete(m);
        if (result > 0) {
            return "redirect:/admin/main";
        }
        throw new MemberException("실패");
    }
}
