package kh.GiveHub.news.model.service;

import org.springframework.stereotype.Service;

import kh.GiveHub.news.model.mapper.NewsMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NewsService {
	private final NewsMapper mapper;
}
