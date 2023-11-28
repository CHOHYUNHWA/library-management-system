package rmsoft.librarymanagementsystem.domain.bookRental.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRentalListSearchDto {

    private int pageNum;
    private int pageSize;
    private String searchEmail;
    private String searchName;
    private String searchTitle;
    private String searchAuthor;
    private Boolean bookStatus;

}


