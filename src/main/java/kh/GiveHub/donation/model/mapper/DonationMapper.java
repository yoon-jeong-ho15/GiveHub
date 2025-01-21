package kh.GiveHub.donation.model.mapper;

import java.util.ArrayList;

import kh.GiveHub.donation.model.vo.Donation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DonationMapper {

    int deleteDona(String no);

    ArrayList<Donation> selectDonaList(int i);

    ArrayList<Donation> selectCategory(String category);
}
