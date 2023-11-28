package rmsoft.librarymanagementsystem.domain.member.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;
import lombok.*;
import rmsoft.librarymanagementsystem.domain.bookRental.entity.BookRental;
import rmsoft.librarymanagementsystem.global.audit.BaseTimeEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;

    @Builder.Default
    @OneToMany(mappedBy = "member")
    private List<BookRental> bookRentalList = new ArrayList<>();

}
