package rmsoft.librarymanagementsystem.domain.bookRental.entity;

import jakarta.persistence.*;
import rmsoft.librarymanagementsystem.domain.book.entity.Book;
import rmsoft.librarymanagementsystem.domain.member.entity.Member;

@Entity
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

    private boolean returnStatus;


}
