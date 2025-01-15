package kh.GiveHub.donation.model.service;

import org.springframework.stereotype.Service;

import kh.GiveHub.donation.model.mapper.DonationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@RequiredArgsConstructor
public class DonationService {
	private final DonationMapper mapper;
}
