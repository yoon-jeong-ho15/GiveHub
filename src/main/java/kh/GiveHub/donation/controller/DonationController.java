package kh.GiveHub.donation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import kh.GiveHub.donation.model.vo.Donation;
import kh.GiveHub.member.model.vo.Member;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DonationController {
	private final Donation dService;

	
	@GetMapping("/ongoingList")
	public String ongoingList(HttpSession session) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		return "templates/member/mydonation";
	}
	
	@GetMapping("/finishedList")
	public String finishedList(HttpSession session) {
		
		return "templates/member/mydonation";
	}
	
	@GetMapping("/donationlist")
	public String donationlist() {
		return "/page/donationlist";
	}
	
	
	@GetMapping("detailCategory")
	public String detailCategory(@RequestParam ) {
		
		d.setDoCategory();

		
	}
	 
}
