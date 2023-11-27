package rmsoft.librarymanagementsystem.global.exception;

import lombok.Getter;

public enum ExceptionCode {

    MEMBER_NOT_FOUND(404, "Member not found"),

    USERNAME_EXISTS(400, "Already Exists Username"  ),
    LIBRARY_NAME_EXISTS(400,"Already Exists Library" );

    @Getter
    private final int status;
    @Getter
    private final String message;

    ExceptionCode(int status, String message){
        this.status = status;
        this.message = message;
    }
}
