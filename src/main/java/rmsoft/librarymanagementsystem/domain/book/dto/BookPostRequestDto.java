package rmsoft.librarymanagementsystem.domain.book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookPostRequestDto {

    private String title;
    private String author;
    private String bookCategory;

}
