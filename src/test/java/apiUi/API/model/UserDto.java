package apiUi.API.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String full_name;
    private String email;
    private String password;
    private boolean generate_magic_link;
//    private String UpdateFull_name;
//    private String UpdateEmail;
//    private String UpdateEmail;
}
