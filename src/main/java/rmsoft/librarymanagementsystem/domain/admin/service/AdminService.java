package rmsoft.librarymanagementsystem.domain.admin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmsoft.librarymanagementsystem.domain.admin.entity.Admin;
import rmsoft.librarymanagementsystem.domain.admin.repository.AdminRepository;
import rmsoft.librarymanagementsystem.global.exception.BusinessLogicException;
import rmsoft.librarymanagementsystem.global.exception.ExceptionCode;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminService {

    private final AdminRepository adminRepository;


    /**
     * 어드민 계정 생성
     * @param admin
     * @return admin_id;
     */
    @Transactional(readOnly = false)
    public Long join(Admin admin) {
        validateDuplicateUsername(admin.getUsername());
        validateDuplicateLibraryName(admin.getLibraryName());
        admin.updatePassword(admin.getPassword());
        adminRepository.save(admin);
        return admin.getId();
    }


    /**
     * 아이디 중복체크
     */
    public void validateDuplicateUsername(String username){
        adminRepository.findByUsername(username)
                .ifPresent(a -> {
                    throw new BusinessLogicException(ExceptionCode.USERNAME_EXISTS);
                });
    }

    /**
     * 도서관 중복체크
     */
    public void validateDuplicateLibraryName(String libraryName){
        adminRepository.findByLibraryName(libraryName)
                .ifPresent(a -> {
                    throw new BusinessLogicException(ExceptionCode.LIBRARY_NAME_EXISTS);
                });
    }
}
