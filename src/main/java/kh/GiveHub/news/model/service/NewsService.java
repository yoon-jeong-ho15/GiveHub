package kh.GiveHub.news.model.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kh.GiveHub.news.model.mapper.NewsMapper;
import kh.GiveHub.news.model.vo.News;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final NewsMapper mapper;

    public News selectNews(String nNo) {
        return mapper.selectNews(nNo);
    }

    public ArrayList<News> selectNewsList() {
        return mapper.selectNewsList();
    }

    public int deleteNews(String nNo) {
        return mapper.deleteNews(nNo);
    }

    public ArrayList<News> nnewsList() {
        return mapper.nnewsList();
    }

	public int setContent(int newsNo, String content) {
		StringBuilder newContent = new StringBuilder();
		Pattern pattern = 
				Pattern.compile("<img[^>]+?src=\"([^\"]+)\"[^>]*?>");
		Matcher matcher = pattern.matcher(content);
		while(matcher.find()) {
			String oldPath = matcher.group(1);
			String newPath = oldPath.replace("/temp/", "/upload/");
			int index = newContent.indexOf(oldPath);
			newContent.replace(index, index+oldPath.length(), newPath);
		}
		return mapper.setContent(newsNo, newContent.toString());
	}

	public int insertNews(News n) {
		return mapper.insertNews(n);
	}


}