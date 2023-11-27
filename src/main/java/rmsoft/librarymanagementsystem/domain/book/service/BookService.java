package rmsoft.librarymanagementsystem.domain.book.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmsoft.librarymanagementsystem.domain.book.dto.BookListSearchDto;
import rmsoft.librarymanagementsystem.domain.book.dto.BookUpdateRequestDto;
import rmsoft.librarymanagementsystem.domain.book.dto.GetBookResponseDto;
import rmsoft.librarymanagementsystem.domain.book.entity.Book;
import rmsoft.librarymanagementsystem.domain.book.repository.BookRepository;
import rmsoft.librarymanagementsystem.global.dto.MultiResponseDto;
import rmsoft.librarymanagementsystem.global.dto.PageInfo;
import rmsoft.librarymanagementsystem.global.exception.BusinessLogicException;
import rmsoft.librarymanagementsystem.global.exception.ExceptionCode;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Transactional(readOnly = false)
    public void postBook(Book book) {
        bookRepository.insertBook(book);
    }

    public GetBookResponseDto getBook(Long booId) {
        GetBookResponseDto getBookResponseDto =
                bookRepository.selectBookByTitle(booId)
                        .orElseThrow(() -> new BusinessLogicException(ExceptionCode.BOOK_NOT_FOUND));
        return getBookResponseDto;
    }

    public void updateBook(Long bookId , BookUpdateRequestDto bookUpdateRequestDto) {
        bookRepository.updateBook(bookId, bookUpdateRequestDto);
    }

    public MultiResponseDto<GetBookResponseDto> getBookList(BookListSearchDto bookListSearchDto) {
        int pageNum = 0;
        int pageSize = 10;

        if(bookListSearchDto.getPageNum() != 0) {
            pageNum = bookListSearchDto.getPageNum() - 1;
        }
        if(bookListSearchDto.getPageSize() != 0) {
            pageSize = bookListSearchDto.getPageSize();
        }

        int offset = pageNum * pageSize;
        int limit = pageSize;
        int totalCount =
                bookRepository.selectBookTotalCount(
                    bookListSearchDto.getSearchTitle(),
                    bookListSearchDto.getSearchCategory());
        int totalPage = (int) Math.ceil((double) totalCount / pageSize);

        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(pageNum+1);
        pageInfo.setPageSize(limit);
        pageInfo.setTotalCount(totalCount);
        pageInfo.setTotalPage(totalPage);

        List<GetBookResponseDto> getBookResponseDtoList =
                bookRepository.selectBookList(
                        offset,
                        limit,
                        bookListSearchDto.getSearchTitle(),
                        bookListSearchDto.getSearchCategory());
        return new MultiResponseDto<GetBookResponseDto>(getBookResponseDtoList,pageInfo);
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteBook(bookId);
    }
}
