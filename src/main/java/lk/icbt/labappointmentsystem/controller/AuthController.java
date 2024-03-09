package lk.icbt.labappointmentsystem.controller;

import lk.icbt.labappointmentsystem.dto.LoginDTO;
import lk.icbt.labappointmentsystem.entity.User;
import lk.icbt.labappointmentsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserService userService;

//    @PostMapping("/login")
//    public ResponseEntity<User> login(@RequestBody LoginDTO loginDTO) {
//        // Call the service to authenticate the user
//        User authenticatedUser = userService.authenticateUser(loginDTO);
//
//        if (authenticatedUser != null) {
//            return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//    }
}
