package rmsoft.librarymanagementsystem.domain.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmsoft.librarymanagementsystem.domain.admin.entity.Admin;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByUsername(String username);

    Optional<Admin> findByLibraryName(String libraryName);
}
