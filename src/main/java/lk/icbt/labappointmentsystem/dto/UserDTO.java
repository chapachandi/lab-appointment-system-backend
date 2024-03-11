package lk.icbt.labappointmentsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long userId;
    private String name;
    private String email;
    private String password;
    private String username;
    private String mobileNumber;

}
