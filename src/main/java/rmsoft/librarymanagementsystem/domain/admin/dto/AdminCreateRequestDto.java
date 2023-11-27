package rmsoft.librarymanagementsystem.domain.admin.dto;

import lombok.*;
import rmsoft.librarymanagementsystem.domain.admin.entity.Admin;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminCreateRequestDto {

    private String username;
    private String password;
    private String libraryName;

}
