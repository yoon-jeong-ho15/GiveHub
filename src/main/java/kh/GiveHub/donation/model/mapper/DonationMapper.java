package kh.GiveHub.donation.model.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kh.GiveHub.donation.model.vo.Donation;

@Mapper
public interface DonationMapper {

    ArrayList<Donation> selectDonaList(int i);

    ArrayList<Donation> selectCategory(String category);

    int deleteDona(String no);

    ArrayList<Donation> selectOrderBy(String type);

    ArrayList<Donation> search(Donation d);

    Donation selectDonation(int doNo);

    int updateCount(int doNo);

    int setContent(@Param("doNo") int doNo, @Param("content") String content);

	int insertDonation(Donation d);

}