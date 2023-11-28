package rmsoft.librarymanagementsystem.domain.member.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import rmsoft.librarymanagementsystem.domain.member.entity.Member;

import java.util.Optional;

@Mapper
public interface MemberRepository{

    int insertMember(@Param("member") Member member);

    Optional<Member> selectMemberByEmail(String email);
}
