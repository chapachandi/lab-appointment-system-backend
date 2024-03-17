package lk.icbt.labappointmentsystem.service.impl;

import lk.icbt.labappointmentsystem.dto.LoginDTO;
import lk.icbt.labappointmentsystem.dto.TestDTO;
import lk.icbt.labappointmentsystem.dto.UserDTO;
import lk.icbt.labappointmentsystem.entity.User;
import lk.icbt.labappointmentsystem.exception.NotFoundException;
import lk.icbt.labappointmentsystem.exception.ValidateException;
import lk.icbt.labappointmentsystem.repeository.UserRepository;
import lk.icbt.labappointmentsystem.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

//    public Page<UserDTO> getAllUsers(int page, int size) {
//        Page<User> users = userRepository.findAll(PageRequest.of(page, size, Sort.by("id").ascending()));
//        return users.map(user -> modelMapper.map(user, UserDTO.class));
//
//
//    }
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        User userById = userRepository.findById(id).orElse(null);
        return modelMapper.map(userById, UserDTO.class);

    }

    private User createFormatUserId(User user){
        if (user.getUserId() == null) {
            ;

        }
        user.setFormattedUserId(String.format("PID%03d", user.getUserId()));
        userRepository.save(user);
        return user;
    }

    public UserDTO createUser(UserDTO userDTO) {
//        User user = modelMapper.map(userDTO, User.class);
//        userRepository.save(user);
//        return userDTO;
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new ValidateException("Registration Already Exist");
        }
        User user = modelMapper.map(userDTO, User.class);
        userRepository.save(user); // Save the user to the database
        return modelMapper.map(createFormatUserId(user), UserDTO.class);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            User user = modelMapper.map(userDTO, User.class);
            User savedUser = userRepository.save(existingUser);
            return userDTO;
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

//    @Override
//    public User authenticateUser(LoginDTO loginDTO) {
//        User user = userRepository.findByEmail(loginDTO.getEmail());
//
//        if (user != null && user.getPassword().equals(loginDTO.getPassword())) {
//            return user;
//        } else {
//            return null;
//        }
//    }

    @Override
    public UserDTO findEmailAndPassword(String email, String password) {
        Optional<User> reg = userRepository.findByEmailAndPassword(email, password);
        if (reg.isPresent()) {
            return modelMapper.map(reg.get(), UserDTO.class);
        }
        throw new NotFoundException("Email name and Password Not Matched");
    }
}
