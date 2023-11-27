package rmsoft.librarymanagementsystem.domain.book.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rmsoft.librarymanagementsystem.domain.book.dto.BookListSearchDto;
import rmsoft.librarymanagementsystem.domain.book.dto.BookPostRequestDto;
import rmsoft.librarymanagementsystem.domain.book.dto.BookUpdateRequestDto;
import rmsoft.librarymanagementsystem.domain.book.dto.GetBookResponseDto;
import rmsoft.librarymanagementsystem.domain.book.entity.Book;
import rmsoft.librarymanagementsystem.domain.book.mapper.BookMapper;
import rmsoft.librarymanagementsystem.domain.book.service.BookService;
import rmsoft.librarymanagementsystem.global.dto.MultiResponseDto;


@RestController
@RequestMapping("api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookMapper bookMapper;
    private final BookService bookService;

    //도서 등록
    @PostMapping
    public ResponseEntity<Void> postBook(@RequestBody BookPostRequestDto bookPostRequestDto){
        Book book = bookMapper.toEntity(bookPostRequestDto);
        bookService.postBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //도서 수정
    @PutMapping("/{bookId}")
    public ResponseEntity<Void> updateBook(@PathVariable("bookId") Long bookId,
                                               @RequestBody BookUpdateRequestDto bookUpdateRequestDto){
        bookService.updateBook(bookId, bookUpdateRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //도서 대출 이력 조회

    //도서 조회
    @GetMapping("/{bookId}")
    public ResponseEntity<GetBookResponseDto> getBook(@PathVariable("bookId") Long bookId){
        GetBookResponseDto response = bookService.getBook(bookId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //전체 도서 조회 및 검색
    @GetMapping("/list")
    public ResponseEntity<MultiResponseDto<GetBookResponseDto>> getBookList(BookListSearchDto bookListSearchDto){
        if(bookListSearchDto.getPageNum() < 0 || bookListSearchDto.getPageSize() < 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        MultiResponseDto<GetBookResponseDto> bookListResponse = bookService.getBookList(bookListSearchDto);
        return new ResponseEntity<>(bookListResponse,HttpStatus.OK);
    }

    //도서 삭제
    @DeleteMapping("{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") Long bookId){
        bookService.deleteBook(bookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
