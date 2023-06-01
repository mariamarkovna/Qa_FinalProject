package apiUi.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {
    private String full_name;
    private String email;
    private String password;
    private Object generate_magic_link;

}
