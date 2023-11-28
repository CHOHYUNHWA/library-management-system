package rmsoft.librarymanagementsystem.domain.bookRental.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import rmsoft.librarymanagementsystem.domain.bookRental.dto.BookRentalRequestDto;
import rmsoft.librarymanagementsystem.domain.bookRental.dto.GetBookRentalResponseDto;

import java.util.List;

@Mapper
public interface BookRentalRepository {
    void insertBookRental(@Param("bookRental") BookRentalRequestDto bookRentalRequestDto);

    void updateBookReturn(Long bookId);

    int selectBookRentalTotalCount(String searchEmail, String searchName, String searchTitle, String searchAuthor, Boolean bookStatus);

    List<GetBookRentalResponseDto> selectBookRentalList(int offset, int limit, String searchEmail, String searchName, String searchTitle, String searchAuthor, Boolean bookStatus);
}
