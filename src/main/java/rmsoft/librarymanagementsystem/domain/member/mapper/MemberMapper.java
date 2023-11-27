package rmsoft.librarymanagementsystem.domain.member.mapper;

import org.springframework.stereotype.Component;
import rmsoft.librarymanagementsystem.domain.member.dto.MemberCreateRequestDto;
import rmsoft.librarymanagementsystem.domain.member.entity.Member;

@Component
public class MemberMapper {

    public Member toEntity(MemberCreateRequestDto memberCreateRequestDto){
        return Member.builder()
                .name(memberCreateRequestDto.getName())
                .phoneNumber(memberCreateRequestDto.getPhoneNumber())
                .email(memberCreateRequestDto.getEmail())
                .build();
    }
}
