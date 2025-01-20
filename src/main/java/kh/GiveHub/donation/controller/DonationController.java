package kh.GiveHub.donation.controller;


import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
//	@GetMapping("/donation/donationlist")
//	public String donationlist(    @RequestParam(value = "category", required = false, defaultValue = "all") String category, 
//		    Model model) {
//
//	    List<Donation> donationList = category.equals("all") 
//	            ? dService.categorySelect(category) 
//	            : dService.categorySelect(category);
//	        
//	        // 모델에 데이터 전달
//	        model.addAttribute("list", donationList);
//	        model.addAttribute("selectedCategory", category);
//
//	    return "/page/donationlist";
//	}
	@GetMapping("/donation/donationlist")
	public String donationlist(
	        @RequestParam(value = "category", required = false, defaultValue = "all") String category,
	        Model model) {

	    List<Donation> donationList = dService.categorySelect(category);
	    model.addAttribute("donationList", donationList);
	    model.addAttribute("selectedCategory", category);
	    System.out.println("donationList : " + donationList);

	    return "donation/donationlist";
	}
	
	
	
	@PostMapping("/donation/donationlist")
	@ResponseBody
	public ArrayList<Donation> categorySelect(@RequestParam("category") String cat) {
//	System.out.println("카테고리 받아오니? " + category);
		ArrayList<Donation> list = dService.categorySelect(cat);
		
		System.out.println(list);
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
  
	@GetMapping("payment")
	public String paymentPage() {
		return "page/paymentPage";
	}

	@GetMapping("/donation/donationWrite")
	public String donationWrite() {
		return "donation/donationWrite";
	}

	@GetMapping(value="/category")
	public void categoryChoice(HttpServletResponse response) {
		System.out.println("잘 들어옴");
		ArrayList<Donation> list = dService.categoryChoice();

		response.setContentType("application/json; charset=UTF-8");

		GsonBuilder gb = new GsonBuilder().setDateFormat("yyyy-MM-dd");
		Gson gson = gb.create();


		try {
			gson.toJson(list, response.getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping(value="/selectList")
	public void selectList(HttpServletResponse response) {
		ArrayList<Donation> list = dService.selectList();

		response.setContentType("application/json; charset=UTF-8");

		GsonBuilder gb = new GsonBuilder().setDateFormat("yyyy-MM-dd");
		Gson gson = gb.create();


		try {
			gson.toJson(list, response.getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}







}
