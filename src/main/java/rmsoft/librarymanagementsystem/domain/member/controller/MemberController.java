package rmsoft.librarymanagementsystem.domain.member.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rmsoft.librarymanagementsystem.domain.member.dto.MemberCreateRequestDto;
import rmsoft.librarymanagementsystem.domain.member.entity.Member;
import rmsoft.librarymanagementsystem.domain.member.mapper.MemberMapper;
import rmsoft.librarymanagementsystem.domain.member.service.MemberService;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper memberMapper;

    //회원 등록
    @PostMapping
    public ResponseEntity<Void> createMember(@RequestBody MemberCreateRequestDto memberCreateRequestDto){
        Member member = memberMapper.toEntity(memberCreateRequestDto);
        memberService.createMember(member);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
