package kh.GiveHub.image.model.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kh.GiveHub.common.config.WebMvcConfig;
import kh.GiveHub.image.model.exception.ImageException;
import kh.GiveHub.image.model.mapper.ImageMapper;
import kh.GiveHub.image.model.vo.Image;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageService {
	private final ImageMapper mapper;
	private String basePath = WebMvcConfig.getBasePath();
	private String tempPath = basePath + "/temp/";
	private String uploadPath =basePath + "/upload/";
	
	public String saveTemp(MultipartFile file,
			String imgName, String imgType) {
			
		try {
			File dir = new File(tempPath);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			int ranNum = (int)(Math.random()*10000);
			String rename = sdf.format(new Date())+ranNum+"_"+imgName;
			if (imgType.equals("0")) {
				rename = "T"+rename;
			}
			
			File destfile = new File(tempPath, rename);
			file.transferTo(destfile);
			return rename;
		} catch (IllegalStateException | IOException e) {
			throw new ImageException("failed :  img transfer to /temp");
		}
	}

	public boolean saveUpload(List<String> list, int bid, String boardType) {
		File dir = new File(uploadPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		for(String name : list) {
			String fileName = name.substring(name.lastIndexOf("/")+1);
			String sourcePath = tempPath+fileName;
			String destPath = uploadPath+fileName;
	        
			try {
				Files.copy(Paths.get(sourcePath), Paths.get(destPath),
						StandardCopyOption.REPLACE_EXISTING);
				
				Image img = new Image();
				img.setImgPath(uploadPath);
				img.setImgName(fileName.substring(fileName.lastIndexOf("_")+1));
				img.setImgRename(fileName);
				img.setImgType(fileName.startsWith("T")? "0":"1");
				img.setRefNo(bid);
				img.setBoardType(boardType.equals("donation")? "D":"N");
				mapper.insertImage(img);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public List<String> compareContent(String content, String oldcontent) {
		List<String> oldFiles = new ArrayList<String>();
        List<String> delFiles = new ArrayList<>();
		//Pattern pattern = Pattern.compile("<img[^>]+?src=\"/upload/([^\"]+)\"[^>]*?>");
        //Pattern pattern = Pattern.compile("<img[^>]+?src=\"(?:/upload/|../upload/)([^\"]+)\"[^>]*?>");
        Pattern pattern = Pattern.compile("<"
        		+ "img[^>]+?src=\"(?:/upload/|\\.\\./upload/|\\.\\./\\.\\./upload/)([^\"]+)\"[^>]*?>");
        Matcher matcher = pattern.matcher(oldcontent);
        
        while (matcher.find()) {
        	String filename = matcher.group(1);
        	oldFiles.add(filename);
        }
        
        for (String oldFile : oldFiles) {
        	if(!content.contains(oldFile)) {
        		delFiles.add(oldFile);
        	}
        }
        return delFiles;
	}

	public boolean deleteImage(List<String> delFiles) {
		int delcount = 0;
        for (String filename : delFiles) {
        	File file = new File(uploadPath+filename);
        	if(file.exists()) {
        		file.delete();
        	}
        	delcount += mapper.deleteImage(filename);
        }
        System.out.println("delCount : "+delcount);
        System.out.println("delFiles.size() : "+delFiles.size());
        if (delcount == delFiles.size()) {
        	return true;
        }
		return false;
	}
}
