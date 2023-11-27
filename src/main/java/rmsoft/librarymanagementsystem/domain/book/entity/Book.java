package rmsoft.librarymanagementsystem.domain.book.entity;

import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.*;
import rmsoft.librarymanagementsystem.domain.bookRental.entity.BookRental;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;
    private String title;
    private BookCategory bookCategory;

    @Builder.Default
    @OneToMany(mappedBy = "book")
    private List<BookRental> bookRentalList = new ArrayList<>();
}