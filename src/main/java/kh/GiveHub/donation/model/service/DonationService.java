package kh.GiveHub.donation.model.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import kh.GiveHub.donation.model.mapper.DonationMapper;
import kh.GiveHub.donation.model.vo.Donation;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class DonationService {
	private final DonationMapper mapper;

	public ArrayList<Donation> donationlist(String category) {
		return mapper.donationlist(category);
	}
    public int deleteDona(String no) {
        return mapper.deleteDona(no);
    }

    public ArrayList<Donation> selectDonaList() {
        return mapper.selectDonaList();
    }
    
}

