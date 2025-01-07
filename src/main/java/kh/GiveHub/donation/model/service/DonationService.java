package kh.GiveHub.donation.model.service;

import org.springframework.stereotype.Service;

import kh.GiveHub.donation.model.mapper.DonationMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DonationService {
	private final DonationMapper mapper;
}
