package kh.GiveHub.member.model.mapper;

import kh.GiveHub.member.model.vo.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper 
public interface MemberMapper {

    ArrayList<Member> selectMemberList();

	Member login(Member m);

    Member selectNo(int no);

    int adminMemberUpdate(Member m);


	int adminMemberDelete(Member m);

    int checkId(String id);

    int memberJoin(Member m);
}
