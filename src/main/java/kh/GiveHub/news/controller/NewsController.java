package kh.GiveHub.news.controller;

import kh.GiveHub.member.model.exception.MemberException;
import kh.GiveHub.news.model.vo.News;
import org.springframework.stereotype.Controller;

import kh.GiveHub.news.model.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class NewsController {
	private final NewsService nService;

	// 관리자 소식관리 게시판
	@GetMapping("/admin/newsList")
	public String newsList(Model model) {
		ArrayList<News> list = nService.selectNewsList();
		model.addAttribute("list", list);
		return "/admin/newsList";
	}

	// 관리자 소식 상세 페이지(삭제)
	@GetMapping("/admin/newsDelete/{nNo}")
	public String newsManage(@PathVariable("nNo") String nNo) {
		int result = nService.deleteNews(nNo);
		if (result > 0) {
			return "redirect:/admin/newsList";
		}
		throw new MemberException("실패");
	}

	// 사용자 소식 게시판
	@GetMapping("/news/newsList")
	public String nnewsList(Model model) {
		ArrayList<News> list = nService.nnewsList();
		model.addAttribute("list", list);
		return "/news/newsList";
	}

	// 디테일 페이지로 들어가기
	@GetMapping("/news/newsdetail/{newsNo}")
	public String newsDetail(Model model, @PathVariable("newsNo") int newsNo) {
		News n = nService.newsDetail(newsNo);
		model.addAttribute("n", n);
		return "/news/newsdetail";
  }

	//뉴스 작성 기능 (윤정호)
	@GetMapping("/news/write")
	public String toWrite() {
		return "/news/newsWrite";
	}
}
