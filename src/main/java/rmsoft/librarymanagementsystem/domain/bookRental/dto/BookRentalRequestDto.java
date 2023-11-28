package rmsoft.librarymanagementsystem.domain.bookRental.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookRentalRequestDto {

    private String email;
    private Long bookId;

}
