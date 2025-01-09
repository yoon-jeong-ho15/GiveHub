package kh.GiveHub.news.model.mapper;

import kh.GiveHub.news.model.vo.News;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsMapper {

    News selectNews(String nNo);
}
