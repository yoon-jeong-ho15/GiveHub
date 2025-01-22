package kh.GiveHub.donation.controller;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
		Member loginUser = (Member) session.getAttribute("loginUser");
		return "/member/mydonation";
	}

	@GetMapping("/finishedList")
	public String finishedList(HttpSession session) {

		return "/member/mydonation";
	}

	@GetMapping("/admin/donaList")
	public String newsList (Model model){
		ArrayList<Donation> list = dService.selectDonaList(0);
		model.addAttribute("list", list);
		return "/admin/donaList";
	}

	@GetMapping("/admin/donaDelete/{no}")
	public String deleteDona (@PathVariable("no") String no){
		int result = dService.deleteDona(no);
		if (result > 0) {
			return "redirect:/admin/donaList";
		} else {
			throw new MemberException("실패");
		}
	}

	@GetMapping("payment")
	public String paymentPage () {
		return "page/paymentPage";
	}

	@GetMapping("/donation/donationWrite")
	public String donationWrite () {
		return "donation/donationWrite";
	}





	@GetMapping("/donation/donationlist")
	public String donationList(Model model) {
		ArrayList<Donation> list = dService.selectDonaList(0); // 기본 전체 목록
		model.addAttribute("list", list);
		return "donation/donationlist";
	}

	@GetMapping("/category")
	@ResponseBody
	public ArrayList<Donation> category (@RequestParam("category") String category){
//		System.out.println(category);
		if (category.equals("all")) {
			return dService.selectDonaList(1);
		} else {
			return dService.selectCategory(category);
		}
	}

	@GetMapping("/order")
	@ResponseBody
	public ArrayList<Donation> order(@RequestParam("type") String type) {
		return dService.orderBy(type);
	}

	@GetMapping("/search")
	@ResponseBody
	public ArrayList<Donation> search(@RequestParam("selectItem") String item, @RequestParam("searchInput") String searchInput) {
		Donation d = new Donation();
		if (item.equals("doTitle")){
			d.setDoTitle(searchInput);
		}else{
			d.setMemName(searchInput);
		}
		return dService.search(d);
	}




}

