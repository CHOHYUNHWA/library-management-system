package rmsoft.librarymanagementsystem.domain.member.dto;

import lombok.*;
import rmsoft.librarymanagementsystem.domain.member.entity.Member;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberCreateRequestDto {

    private String name;
    private String phoneNumber;
    private String email;

}
