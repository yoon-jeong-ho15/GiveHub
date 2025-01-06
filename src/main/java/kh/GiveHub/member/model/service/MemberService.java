package kh.GiveHub.member.model.service;

import org.springframework.stereotype.Service;

import kh.GiveHub.member.model.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberMapper mapper;
	public int checkEmail(String email) {
		return mapper.checkEmail(email);
	}



}
