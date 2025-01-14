package kh.GiveHub.news.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {
    private int newsNo;
    private String newsTitle;
    private String newsContent;
    private Date newsCreateDate;
    private String newsStatus;
    private String memNo;
    private String doNo;
    private String doTitle;
}
