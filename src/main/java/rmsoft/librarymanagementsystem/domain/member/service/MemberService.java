package rmsoft.librarymanagementsystem.domain.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmsoft.librarymanagementsystem.domain.member.entity.Member;
import rmsoft.librarymanagementsystem.domain.member.repository.MemberRepository;
import rmsoft.librarymanagementsystem.global.exception.BusinessLogicException;
import rmsoft.librarymanagementsystem.global.exception.ExceptionCode;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    public void createMember(Member member) {
        validateDuplicateEmail(member.getEmail());
        memberRepository.insertMember(member);
    }

    //이메일 중복검사
    public void validateDuplicateEmail(String email){
        memberRepository.selectMemberByEmail(email).ifPresent(m -> {
            throw new BusinessLogicException(ExceptionCode.EMAIL_EXISTS);
        });

    }
}
