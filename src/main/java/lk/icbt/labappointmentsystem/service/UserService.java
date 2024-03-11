package lk.icbt.labappointmentsystem.service;

import lk.icbt.labappointmentsystem.dto.LoginDTO;
import lk.icbt.labappointmentsystem.dto.UserDTO;
import lk.icbt.labappointmentsystem.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public interface UserService {
    public Page<UserDTO> getAllUsers(int page, int size);

    public UserDTO getUserById(Long userId);
    public UserDTO createUser(UserDTO userDTO) ;

    public UserDTO updateUser(Long userId, UserDTO userDTO);

    public void deleteUser(Long userId) ;

//    User authenticateUser(LoginDTO loginDTO);
    UserDTO findEmailAndPassword(String email, String password);
}
