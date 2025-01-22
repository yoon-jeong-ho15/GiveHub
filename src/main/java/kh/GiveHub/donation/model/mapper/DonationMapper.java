package kh.GiveHub.donation.model.mapper;

import java.util.ArrayList;

import kh.GiveHub.donation.model.vo.Donation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DonationMapper {

    ArrayList<Donation> selectDonaList(int i);

    ArrayList<Donation> selectCategory(String category);

    int deleteDona(String no);
}