package kh.GiveHub.donation.model.mapper;

import java.util.ArrayList;

import kh.GiveHub.donation.model.vo.Donation;
import org.apache.ibatis.annotations.Mapper;

import kh.GiveHub.donation.model.vo.Donation;
import java.util.ArrayList;

@Mapper
public interface DonationMapper {

	ArrayList<Donation> categorySelect = null;

	ArrayList<Donation> donationlist(String category);

    int deleteDona(String no);

    ArrayList<Donation> selectDonaList();

	ArrayList<Donation> categorySelect(String category);

	ArrayList<Donation> categoryChoice();

	ArrayList<Donation> selectList();
}
