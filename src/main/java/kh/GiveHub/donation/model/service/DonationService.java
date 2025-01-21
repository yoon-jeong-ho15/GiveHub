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

    public int deleteDona(String no) {
        return mapper.deleteDona(no);
    }

    public ArrayList<Donation> selectDonaList(int i) {
        return mapper.selectDonaList(i);
    }

    public ArrayList<Donation> selectCategory(String category) {
        return mapper.selectCategory(category);
    }
}

