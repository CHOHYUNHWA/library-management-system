package rmsoft.librarymanagementsystem.domain.bookRental.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rmsoft.librarymanagementsystem.domain.bookRental.dto.BookRentalListSearchDto;
import rmsoft.librarymanagementsystem.domain.bookRental.dto.BookRentalRequestDto;
import rmsoft.librarymanagementsystem.domain.bookRental.dto.BookReturnRequestDto;
import rmsoft.librarymanagementsystem.domain.bookRental.dto.GetBookRentalResponseDto;
import rmsoft.librarymanagementsystem.domain.bookRental.service.BookRentalService;
import rmsoft.librarymanagementsystem.global.dto.MultiResponseDto;

@RestController
@RequestMapping("/api/rental")
@RequiredArgsConstructor
public class BookRentalController {

    private final BookRentalService bookRentalService;

    //대여
    @PostMapping("/book-rental")
    public ResponseEntity<Void> bookRental(@RequestBody BookRentalRequestDto bookRentalRequestDto){
        bookRentalService.rentalBook(bookRentalRequestDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //대여 이력 조회
    //이용자 이메일,이름 조회
    //책 이름 조회
    @GetMapping("/list")
    public ResponseEntity<MultiResponseDto> bookRentalList(BookRentalListSearchDto bookRentalListSearchDto){
        MultiResponseDto<GetBookRentalResponseDto> rentalBookList = bookRentalService.getRentalBookList(bookRentalListSearchDto);
        return new ResponseEntity<>(rentalBookList, HttpStatus.OK);
    }

    //반납
    @PostMapping("/book-return")
    public ResponseEntity<Void> bookReturn(@RequestBody BookReturnRequestDto bookReturnRequestDto){
        bookRentalService.returnBook(bookReturnRequestDto.getBookId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
