package rmsoft.librarymanagementsystem.domain.member.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import rmsoft.librarymanagementsystem.domain.member.entity.Member;

@Mapper
public interface MemberRepository{

    public int insertMember(@Param("member") Member member);
}
