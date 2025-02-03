package kh.GiveHub.news.model.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kh.GiveHub.news.model.vo.News;

@Mapper
public interface NewsMapper {

    News selectNews(int newsNo);

    ArrayList<News> selectNewsList();

    int deleteNews(String nNo);

    ArrayList<News> nnewsList(int i);

	int insertNews(News n);

	int setContent(@Param("newsNo")int newsNo,@Param("newContent") String newContent);

    News newsDetail(int newsNo);

    ArrayList<News> selectNewsNew();

    News selectNewsDetail(String newsNo);

	String getOldContent(int newsNo);

	int updateNews(News n);
}
