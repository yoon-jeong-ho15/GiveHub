package kh.GiveHub.news.model.service;

import kh.GiveHub.news.model.vo.News;
import org.springframework.stereotype.Service;

import kh.GiveHub.news.model.mapper.NewsMapper;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

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
}
