package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
@AllArgsConstructor

public class User {
    private String email;
    private String password;
    private String newFull_name;
    private String newEmail;
    private String aboutMe;
    private String photo;
    private String externalProfile;
    private String major;
    private String oldPhoto;

    public User() {

    }
}
