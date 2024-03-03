package lk.icbt.labappointmentsystem.service.impl;

import lk.icbt.labappointmentsystem.dto.UserDTO;
import lk.icbt.labappointmentsystem.entity.User;
import lk.icbt.labappointmentsystem.repeository.UserRepository;
import lk.icbt.labappointmentsystem.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<UserDTO> getAllUsers(int page, int size) {
        Page<User> users = userRepository.findAll(PageRequest.of(page, size, Sort.by("id").ascending()));
        return users.map(user -> modelMapper.map(user, UserDTO.class));

    }

    public UserDTO getUserById(Long id) {
        User userById = userRepository.findById(id).orElse(null);
        return modelMapper.map(userById, UserDTO.class);

    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        userRepository.save(user);
        return userDTO;
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
}