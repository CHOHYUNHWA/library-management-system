package rmsoft.librarymanagementsystem.domain.admin.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import rmsoft.librarymanagementsystem.domain.admin.dto.AdminCreateRequestDto;
import rmsoft.librarymanagementsystem.domain.admin.entity.Admin;

@Component
@RequiredArgsConstructor
public class AdminMapper {

    public Admin toEntity(AdminCreateRequestDto adminCreateRequestDto){
        return Admin.builder()
                .username(adminCreateRequestDto.getUsername())
                .password(adminCreateRequestDto.getPassword())
                .libraryName(adminCreateRequestDto.getLibraryName())
                .role("ROLE_ADMIN")
                .build();

    }
}
