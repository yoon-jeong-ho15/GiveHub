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
import org.springframework.web.servlet.ModelAndView;

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




































	//기부페이지 상세보기
	@GetMapping("/donation/donationdetail/{doNo}")
	public ModelAndView selectDona(@PathVariable("doNo") int doNo,HttpSession session, ModelAndView mv) {
		// 글 상세조회 + 조회수 수정(내가 내 글 조회 or 비회원 조회 -> 조회수 올라가지 않음)

		Member loginUser = (Member)session.getAttribute("loginUser");
		String id = null;
		if(loginUser != null) {
			id = String.valueOf(loginUser.getMemNo());
		}

		//doNo, memId 를 서비스에 넘겨서 글쓴이 비교 로직 작성
		Donation d = dService.selectDonation(doNo, id);
		//게시글이 존재하면, 게시글 데이터(b)를 donationdetail.html로 전달
		//게시글이 존재하지 않으면 사용자 정의 예외 발생
		if(d != null) {
			mv.addObject("d", d).setViewName("donation/donationdetail");
			return mv;
		}else {
			throw new MemberException("게시글 상세보기를 실패하셨습니다.");
		}

	}


}

