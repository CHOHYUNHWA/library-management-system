package rmsoft.librarymanagementsystem.domain.book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookListSearchDto {

    private int pageNum;
    private int pageSize;
    private String searchTitle;
    private String searchCategory;

}
