package rmsoft.librarymanagementsystem.domain.book.mapper;

import org.springframework.stereotype.Component;
import rmsoft.librarymanagementsystem.domain.book.dto.BookPostRequestDto;
import rmsoft.librarymanagementsystem.domain.book.dto.GetBookResponseDto;
import rmsoft.librarymanagementsystem.domain.book.entity.Book;

@Component
public class BookMapper {
    public Book toEntity(BookPostRequestDto bookPostRequestDto){
        return Book.builder()
                .title(bookPostRequestDto.getTitle())
                .bookCategory(bookPostRequestDto.getBookCategory())
                .bookStatus(false)
                .build();
    }
}
