package rmsoft.librarymanagementsystem.global.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class PageInfo {
    private int totalCount;
    private int totalPage;
    private int pageNum;
    private int pageSize;
}

