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

import kh.GiveHub.image.model.service.ImageService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/image")
public class ImageController {
	private final ImageService iService;
	
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
			@RequestParam("tempFileNames") List<String> tempFileNames) {
		int length = tempFileNames.size();
		int i = 0;
		for(String tempname : tempFileNames) {
			File tempFile = new File("/temp/"+tempname);
			if (tempFile.exists()) {
				tempFile.delete();
			}
			i++;
		}
		return length==i? true:false;
	}
	
}
