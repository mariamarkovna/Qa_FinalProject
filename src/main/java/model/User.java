package model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

public class User {
    private String email;
    private String password;
    private String newFull_name;
    private String newEmail;
    private String aboutMe;
    private String externalProfile;
    private String major;

    public User() {

    }

    public User(String email, String password, String newFull_name, String newEmail, String aboutMe, String externalProfile, String major) {
        this.email = email;
        this.password = password;
        this.newFull_name = newFull_name;
        this.newEmail = newEmail;
        this.aboutMe = aboutMe;
        this.externalProfile = externalProfile;
        this.major = major;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNewFull_name(String newFull_name) {
        this.newFull_name = newFull_name;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public void setExternalProfile(String externalProfile) {
        this.externalProfile = externalProfile;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
