package rmsoft.librarymanagementsystem.domain.book.entity;

import jakarta.persistence.*;
import jdk.jfr.Category;
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
public class Book extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;
    private String title;
    private String author;
    private String bookCategory;
    private boolean bookStatus;

    @Builder.Default
    @OneToMany(mappedBy = "book")
    private List<BookRental> bookRentalList = new ArrayList<>();

}
