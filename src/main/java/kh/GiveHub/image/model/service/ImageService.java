package kh.GiveHub.image.model.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kh.GiveHub.image.model.exception.ImageException;
import kh.GiveHub.image.model.mapper.ImageMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageService {
	private final ImageMapper mapper;

	public String saveTemp(MultipartFile file,
			String imgName, String imgType) {
			
		try {
			String tempPath ="C:/GiveHub/temp/";
			File dir = new File(tempPath);
			
			if(!dir.exists()) {
				dir.mkdirs();
			}
			
			int ranNum = (int)(Math.random()*100);
			String re = ranNum+"_"+imgName;
			
			if (imgType.equals("0")) {
				re = "TH"+re;
			}
			
			File destfile = new File(tempPath, re);
			file.transferTo(destfile);
			return re;
		} catch (IllegalStateException | IOException e) {
			throw new ImageException("failed :  img transfer to /temp");
		}

	}
}
