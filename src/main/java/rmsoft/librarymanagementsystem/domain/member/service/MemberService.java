package rmsoft.librarymanagementsystem.domain.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmsoft.librarymanagementsystem.domain.member.entity.Member;
import rmsoft.librarymanagementsystem.domain.member.repository.MemberRepository;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    public void createMember(Member member) {
        memberRepository.insertMember(member);
    }
}
