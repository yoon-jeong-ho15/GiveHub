package kh.GiveHub.news.model.mapper;

import kh.GiveHub.news.model.vo.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface NewsMapper {

    News selectNews(String nNo);

    ArrayList<News> selectNewsList();

    int deleteNews(String nNo);

    ArrayList<News> nnewsList();
}
