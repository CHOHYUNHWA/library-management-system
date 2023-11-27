package rmsoft.librarymanagementsystem.domain.admin.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Admin {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long id;
    private String username;
    private String password;
    private String libraryName;
    private String role;

    public void updatePassword(String encodedPassword){
        this.password = encodedPassword;
    }

}
