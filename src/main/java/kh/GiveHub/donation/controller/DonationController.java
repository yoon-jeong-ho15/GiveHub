package kh.GiveHub.donation.controller;

import java.util.ArrayList;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		return "templates/member/mydonation";
	}
	
	@GetMapping("/finishedList")
	public String finishedList(HttpSession session) {
		
		return "templates/member/mydonation";
	}
	
	@GetMapping("/donationList")
	public String danationList(){
		return "page/DonationList";
	}
	
	@GetMapping("/search")
	public String searchBoard(@RequestParam("search") String keyword, Model model) {
		ArrayList<Donation> list = dService.searchBoard(keyword);
	    model.addAttribute("list", list);
	    return "/page/search";
	}
	
	
	
	
	
}
