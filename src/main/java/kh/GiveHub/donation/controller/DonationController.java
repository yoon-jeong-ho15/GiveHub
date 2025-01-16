package kh.GiveHub.donation.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import kh.GiveHub.donation.model.service.DonationService;
import kh.GiveHub.donation.model.vo.Donation;
import kh.GiveHub.member.model.vo.Member;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DonationController {
	private final DonationService dService;

	
	@GetMapping("/ongoingList")
	public String ongoingList(HttpSession session) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		return "/member/mydonation";
	}
	
	@GetMapping("/finishedList")
	public String finishedList(HttpSession session) {
		
		return "/member/mydonation";
	}
	
	@GetMapping("/donationlist")
	public String donationlist() {
		return "/page/donationlist";
	}
	
	
	@GetMapping("detailCategory")
	public ArrayList<Donation> detailCategory(@RequestParam("doCategory") String category) {
		ArrayList<Donation> list = dService.detailCategory(category);

		return list;
	}
	 
}
