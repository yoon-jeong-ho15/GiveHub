package kh.GiveHub.donation.model.mapper;

import kh.GiveHub.donation.model.vo.Donation;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface DonationMapper {

    int deleteDona(String no);

    ArrayList<Donation> selectDonaList();
}
