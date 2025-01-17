package kh.GiveHub.donation.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donation {
	private int doNo;
    private String doTitle;
    private String doContent;
    private int doGoal;
    private String doCategory;
    private Date doStartDate;
    private Date doEndDate;
    private int doViews;
    private Date doCreateDate;
    private String doStatus;
    private String memNo;
    private String memName;
}
