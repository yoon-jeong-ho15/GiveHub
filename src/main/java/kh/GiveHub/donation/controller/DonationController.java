package kh.GiveHub.donation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import kh.GiveHub.member.model.vo.Member;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DonationController {
	
	@GetMapping("/ongoingList")
	public String ongoingList(HttpSession session) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		return "templates/member/mydonation";
	}
	
	@GetMapping("/finishedList")
	public String finishedList(HttpSession session) {
		
		return "templates/member/mydonation";
	}
	@GetMapping("payment")
	public String paymentPage() {
		return "page/paymentPage";
	}

	
}
