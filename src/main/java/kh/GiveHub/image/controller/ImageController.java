package kh.GiveHub.image.controller;

import java.io.File;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kh.GiveHub.donation.model.service.DonationService;
import kh.GiveHub.image.model.service.ImageService;
import kh.GiveHub.news.model.service.NewsService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/image")
public class ImageController {
	private final ImageService iService;
	private final DonationService dService;
	private final NewsService nService;
	
	@PostMapping("/temp")
	@ResponseBody
	public ResponseEntity<String> saveTemp(
		@RequestParam("image") MultipartFile file,
		@RequestParam("imgType") String imgType,
		@RequestParam("imgName") String imgName) {
		String tempname = iService.saveTemp(file, imgName, imgType);
		
		return ResponseEntity.ok("/temp/"+tempname);
	}
	
	@DeleteMapping("/delete")
	@ResponseBody
	public boolean deleteTemp(
			@RequestParam("tempFileNames") List<String> list) {
		int length = list.size();
		int i = 0;
		for(String name : list) {
			File tempFile = new File("/temp/"+name);
			if (tempFile.exists()) {
				tempFile.delete();
			}
			i++;
		}
		return length==i? true:false;
	}
	
	@PostMapping("/upload")
	@ResponseBody
	public boolean saveUpload(
			@RequestParam("uploadFileNames") List<String> list,
			@RequestParam("bid") int bid, 
			@RequestParam("content") String content,
			@RequestParam("boardType") String boardType) {
		if(iService.saveUpload(list, bid)) {
			if(boardType.equals("donation")) {
				dService.setContent(bid, content);
			}else {
				nService.setContent(bid, content);
			}
		}
		return false;
	}
}
