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

    //로그인
	public Member login(Member m) {
		return mapper.login(m);
	}

	public Member selectNo(int no) {
		return mapper.selectNo(no);
	}

	public int adminMemberUpdate(Member m) {
		return mapper.adminMemberUpdate(m);
	}

	public int adminMemberDelete(Member m) {
		return mapper.adminMemberDelete(m);
	}

}
