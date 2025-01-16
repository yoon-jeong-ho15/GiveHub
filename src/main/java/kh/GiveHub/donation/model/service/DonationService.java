package kh.GiveHub.donation.model.service;

import kh.GiveHub.donation.model.vo.Donation;
import org.springframework.stereotype.Service;

import kh.GiveHub.donation.model.mapper.DonationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class DonationService {
	private final DonationMapper mapper;

    public int deleteDona(String no) {
        return mapper.deleteDona(no);
    }

    public ArrayList<Donation> selectDonaList() {
        return mapper.selectDonaList();
    }
}
