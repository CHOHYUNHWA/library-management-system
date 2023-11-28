package rmsoft.librarymanagementsystem.domain.bookRental.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import rmsoft.librarymanagementsystem.domain.book.entity.Book;
import rmsoft.librarymanagementsystem.domain.member.entity.Member;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class BookRental {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_rental_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime rentalDate;
    private LocalDateTime expiredDate;
    private LocalDateTime returnDate;

}
