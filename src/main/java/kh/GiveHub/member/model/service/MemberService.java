package kh.GiveHub.member.model.service;

import kh.GiveHub.member.model.vo.Member;
import org.springframework.stereotype.Service;

import kh.GiveHub.member.model.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberMapper mapper;
	
	public int checkEmail(String email) {
		return mapper.checkEmail(email);
	}

    public ArrayList<Member> selectMemberList() {
		return mapper.selectMemberList();
    }
}
