package kh.GiveHub.news.controller;

import kh.GiveHub.news.model.vo.News;
import org.springframework.stereotype.Controller;

import kh.GiveHub.news.model.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class NewsController {
	private final NewsService nService;

	@GetMapping("/admin/newslist")
	public String newsList() {
		return "admin/NewsList";
	}

	@GetMapping("/admin/newsmanage")
	public String newsManage(@RequestParam("nNo") String nNo, Model model) {
		News n = new News();
		if (nNo.equals("0")){
			model.addAttribute("n", n);
			return "admin/NewsManage";
		}else{
			n = nService.selectNews(nNo);
			model.addAttribute("n", n);
			return "admin/NewsManage";
		}
	}
}
