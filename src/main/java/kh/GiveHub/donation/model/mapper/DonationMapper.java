package kh.GiveHub.donation.model.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kh.GiveHub.donation.model.vo.Donation;

@Mapper
public interface DonationMapper {

	ArrayList<Donation> detailCategory(String category);

}
