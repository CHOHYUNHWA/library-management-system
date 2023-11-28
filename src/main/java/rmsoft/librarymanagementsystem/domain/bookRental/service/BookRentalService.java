package rmsoft.librarymanagementsystem.domain.bookRental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmsoft.librarymanagementsystem.domain.book.dto.GetBookResponseDto;
import rmsoft.librarymanagementsystem.domain.book.repository.BookRepository;
import rmsoft.librarymanagementsystem.domain.bookRental.dto.BookRentalListSearchDto;
import rmsoft.librarymanagementsystem.domain.bookRental.dto.BookRentalRequestDto;
import rmsoft.librarymanagementsystem.domain.bookRental.dto.GetBookRentalResponseDto;
import rmsoft.librarymanagementsystem.domain.bookRental.repository.BookRentalRepository;
import rmsoft.librarymanagementsystem.domain.member.repository.MemberRepository;
import rmsoft.librarymanagementsystem.global.dto.MultiResponseDto;
import rmsoft.librarymanagementsystem.global.dto.PageInfo;
import rmsoft.librarymanagementsystem.global.exception.BusinessLogicException;
import rmsoft.librarymanagementsystem.global.exception.ExceptionCode;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookRentalService {

    private final BookRentalRepository bookRentalRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    public void rentalBook(BookRentalRequestDto bookRentalRequestDto) {
        memberRepository.selectMemberByEmail(bookRentalRequestDto.getEmail()).orElseThrow(
                ()-> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND)
        );
        bookRepository.selectBookById(bookRentalRequestDto.getBookId()).orElseThrow(
                () -> new BusinessLogicException(ExceptionCode.BOOK_NOT_FOUND)
        );
        bookRentalRepository.insertBookRental(bookRentalRequestDto);
        bookRepository.updateRentalBookStatus(bookRentalRequestDto.getBookId());
    }

    public void returnBook(Long bookId) {
        bookRentalRepository.updateBookReturn(bookId);
        bookRepository.updateReturnBookStatus(bookId);
    }

    public MultiResponseDto<GetBookRentalResponseDto> getRentalBookList(BookRentalListSearchDto bookRentalListSearchDto) {

        int pageNum = 0;
        int pageSize = 10;
        if(bookRentalListSearchDto.getPageNum() != 0){
            pageNum = bookRentalListSearchDto.getPageNum() -1;
        }
        if(bookRentalListSearchDto.getPageSize() != 0){
            pageSize = bookRentalListSearchDto.getPageSize();
        }

        int offset = pageNum * pageSize;
        int limit = pageSize;
        int totalCount =
                bookRentalRepository.selectBookRentalTotalCount(
                        bookRentalListSearchDto.getSearchEmail(),
                        bookRentalListSearchDto.getSearchName(),
                        bookRentalListSearchDto.getSearchTitle(),
                        bookRentalListSearchDto.getSearchAuthor(),
                        bookRentalListSearchDto.getBookStatus());
        int totalPage = (int) Math.ceil((double) totalCount / pageSize);

        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(pageNum+1);
        pageInfo.setPageSize(limit);
        pageInfo.setTotalCount(totalCount);
        pageInfo.setTotalPage(totalPage);

        List<GetBookRentalResponseDto> getBookRentalResponseDtoList =
                bookRentalRepository.selectBookRentalList(
                        offset,
                        limit,
                        bookRentalListSearchDto.getSearchEmail(),
                        bookRentalListSearchDto.getSearchName(),
                        bookRentalListSearchDto.getSearchTitle(),
                        bookRentalListSearchDto.getSearchAuthor(),
                        bookRentalListSearchDto.getBookStatus());
        return new MultiResponseDto<GetBookRentalResponseDto>(getBookRentalResponseDtoList,pageInfo);
    }
}
