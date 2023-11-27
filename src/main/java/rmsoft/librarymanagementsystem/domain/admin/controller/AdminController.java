package rmsoft.librarymanagementsystem.domain.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rmsoft.librarymanagementsystem.domain.admin.dto.AdminCreateRequestDto;
import rmsoft.librarymanagementsystem.domain.admin.entity.Admin;
import rmsoft.librarymanagementsystem.domain.admin.mapper.AdminMapper;
import rmsoft.librarymanagementsystem.domain.admin.service.AdminService;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminMapper adminMapper;
    private final AdminService adminService;

    //Admin 등록
    @PostMapping
    public ResponseEntity<Long> createAdmin(@RequestBody AdminCreateRequestDto adminCreateRequestDto){
        Admin createdAdmin = adminMapper.toEntity(adminCreateRequestDto);
        Long adminId = adminService.join(createdAdmin);
        return new ResponseEntity<>(adminId, HttpStatus.CREATED);
    }
}
