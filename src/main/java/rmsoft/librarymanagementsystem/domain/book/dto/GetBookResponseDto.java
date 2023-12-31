package rmsoft.librarymanagementsystem.domain.book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetBookResponseDto {

    private Long bookId;
    private String title;
    private String author;
    private String bookCategory;
    private boolean bookStatus;
    private String createdDate;
    private String lastModifiedDate;

}
