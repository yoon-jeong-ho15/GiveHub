package kh.GiveHub.member.model.mapper;

import kh.GiveHub.member.model.vo.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper 
public interface MemberMapper {

	int checkEmail(String email);

    ArrayList<Member> selectMemberList();

	Member login(Member m);
    
    
}
