package rmsoft.librarymanagementsystem.domain.bookRental.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetBookRentalResponseDto {

    private String email;
    private String name;
    private String phoneNumber;
    private String title;
    private String author;
    private String bookCategory;
    private boolean bookStatus;
    private String rentalDate;
    private String expiredDate;
    private String returnDate;


}
