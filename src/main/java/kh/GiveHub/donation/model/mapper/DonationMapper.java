package kh.GiveHub.donation.model.mapper;

import java.util.ArrayList;

import kh.GiveHub.donation.model.vo.Donation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DonationMapper {

    ArrayList<Donation> selectDonaList(int i);

    ArrayList<Donation> selectCategory(String category);

    int deleteDona(String no);

    ArrayList<Donation> selectOrderBy(String type);

    ArrayList<Donation> search(Donation d);

    Donation selectDonation(int doNo);

    int updateCount(int doNo);

	int setContent(int bid, String content);

	int insertDonation(Donation d);

}