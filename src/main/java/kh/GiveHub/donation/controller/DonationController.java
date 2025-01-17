package kh.GiveHub.donation.controller;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import kh.GiveHub.donation.model.service.DonationService;
import kh.GiveHub.donation.model.vo.Donation;
import kh.GiveHub.member.model.exception.MemberException;
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
	
	@GetMapping("/page/donationlist")
	public ArrayList<Donation> donationlist(@ModelAttribute Donation d, @RequestParam("doCategory") String category ) {
		ArrayList<Donation> list = dService.donationlist(category);

		
		return list;
	}
	
	@GetMapping("/admin/donaList")
	public String newsList(Model model) {
		ArrayList<Donation> list = dService.selectDonaList();
		model.addAttribute("list", list);
		return "/admin/donaList";
	}

	@GetMapping("/admin/donaDelete/{no}")
	public String deleteDona(@PathVariable("no") String no) {
		int result = dService.deleteDona(no);
		if (result > 0) {
			return "redirect:/admin/donaList";
		} else {
			//throw new MemberException("실패");
			throw new MemberException("실패");
		}
		
		
	}
}
