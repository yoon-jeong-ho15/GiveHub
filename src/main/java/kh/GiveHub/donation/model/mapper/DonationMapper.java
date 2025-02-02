package kh.GiveHub.donation.model.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kh.GiveHub.donation.model.vo.Donation;

@Mapper
public interface DonationMapper {

    ArrayList<Donation> selectDonaList(int i);

    ArrayList<Donation> selectCategory(Map<String, Object> map);

    int deleteDona(String no);

    Donation selectDonation(int doNo);

    int updateCount(int doNo);

    int setContent(@Param("doNo") int doNo, @Param("content") String content);

	int insertDonation(Donation d);

    ArrayList<Donation> selectNew();

	String getOldContent(int doNo);

	int updateDonation(Donation d);
}