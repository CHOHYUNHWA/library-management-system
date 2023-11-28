package rmsoft.librarymanagementsystem.domain.book.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import rmsoft.librarymanagementsystem.domain.book.dto.BookUpdateRequestDto;
import rmsoft.librarymanagementsystem.domain.book.dto.GetBookResponseDto;
import rmsoft.librarymanagementsystem.domain.book.entity.Book;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BookRepository {

    int insertBook(@Param("book") Book book);

    Optional<GetBookResponseDto> selectBookById(Long bookId);

    int updateBook(Long bookId, @Param("book") BookUpdateRequestDto bookUpdateRequestDto);

    List<GetBookResponseDto> selectBookList(int offset, int limit, String searchTitle, String searchAuthor, String searchCategory,Boolean bookStatus);

    int selectBookTotalCount(String searchTitle,String searchAuthor, String searchCategory,Boolean bookStatus);

    int deleteBook(Long bookId);

    int updateRentalBookStatus(Long bookId);
    int updateReturnBookStatus(Long bookId);
}
