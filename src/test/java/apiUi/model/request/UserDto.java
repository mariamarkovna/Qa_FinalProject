package apiUi.model.request;

public class UserDto {
    public String full_name;
    public String email;
    public boolean generate_magic_link;

    public UserDto(String full_name, String email, boolean generate_magic_link) {
        this.full_name = full_name;
        this.email = email;
        this.generate_magic_link = generate_magic_link;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGenerate_magic_link() {
        return generate_magic_link;
    }

    public void setGenerate_magic_link(boolean generate_magic_link) {
        this.generate_magic_link = generate_magic_link;
    }
}
