package lk.icbt.labappointmentsystem.service;

import lk.icbt.labappointmentsystem.dto.LoginDTO;
import lk.icbt.labappointmentsystem.dto.TestDTO;
import lk.icbt.labappointmentsystem.dto.UserDTO;
import lk.icbt.labappointmentsystem.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface UserService {
//    public Page<UserDTO> getAllUsers(int page, int size);
    public List<UserDTO> getAllUsers() ;

    public UserDTO getUserById(Long id);
    public UserDTO createUser(UserDTO userDTO) ;

    public UserDTO updateUser(Long id, UserDTO userDTO);

    public void deleteUser(Long id) ;

//    User authenticateUser(LoginDTO loginDTO);
    UserDTO findEmailAndPassword(String email, String password);
}
