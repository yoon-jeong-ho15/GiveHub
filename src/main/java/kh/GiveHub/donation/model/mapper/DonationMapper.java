package kh.GiveHub.donation.model.mapper;

import java.util.ArrayList;
import java.util.Map;

import kh.GiveHub.donation.model.vo.Donation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DonationMapper {

    ArrayList<Donation> selectDonaList(int i);

    ArrayList<Donation> selectCategory(Map<String, Object> map);

    int deleteDona(String no);

    Donation selectDonation(int doNo);

    int updateCount(int doNo);

	int setContent(int bid, String content);

	int insertDonation(Donation d);

}