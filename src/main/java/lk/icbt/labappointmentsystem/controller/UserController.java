package lk.icbt.labappointmentsystem.controller;

import lk.icbt.labappointmentsystem.dto.UserDTO;
import lk.icbt.labappointmentsystem.entity.User;
import lk.icbt.labappointmentsystem.exception.NotFoundException;
import lk.icbt.labappointmentsystem.service.impl.UserServiceImpl;
import lk.icbt.labappointmentsystem.util.StandradResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ModelMapper  modelMapper;

   /* @GetMapping
    public Page<UserDTO> getAllUsers(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size) {
        return userService.getAllUsers(page, size);
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }*/

    @GetMapping
    public ResponseEntity<Page<UserDTO>> getAllUsers() {
        Page<UserDTO> allUsers = userService.getAllUsers(2, 5);

        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO userById = userService.getUserById(id);

        if (userById == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
//        User user = modelMapper.map(userDTO, User.class);
//
//        //user = userRepository.save(user);
//        return new ResponseEntity<>(modelMapper.map(user, UserDTO.class), HttpStatus.CREATED);
//    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveRegistration(@RequestBody UserDTO dto) throws ValidationException {
        if (dto.getEmail().trim().length() <= 0) {
            throw new NotFoundException("email can not be empty");
        }
        UserDTO user = userService.createUser(dto);
        return new ResponseEntity(new StandradResponse("201", "Done", user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        UserDTO userById = userService.getUserById(id);
        if (userById == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        UserDTO userById = userService.getUserById(id);
        if (userById == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findEmailAndPassword(@RequestBody UserDTO user) {
        if (!user.getEmail().equals("") && !user.getPassword().equals("")) {
            UserDTO dto = userService.findEmailAndPassword(user.getEmail(), user.getPassword());
            return new ResponseEntity(new StandradResponse("200", "done",dto), HttpStatus.OK);
        }
        throw new NotFoundException("Please Input email And Password");
    }

}
