package rmsoft.librarymanagementsystem.domain.admin.entity;

import jakarta.persistence.Entity;

@Entity
public class Admin {

    private Long id;
    private String username;
    private String password;
    private String libraryName;
    private String role;

}
