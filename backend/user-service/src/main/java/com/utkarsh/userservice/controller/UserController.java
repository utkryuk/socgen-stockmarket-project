package com.utkarsh.userservice.controller;

import com.utkarsh.userservice.entity.User;
import com.utkarsh.userservice.model.JwtRequest;
import com.utkarsh.userservice.model.JwtResponse;
import com.utkarsh.userservice.model.Mail;
import com.utkarsh.userservice.service.MailService;
import com.utkarsh.userservice.service.UserService;
import com.utkarsh.userservice.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    /users/signin", "/users/validate", "/users/signup
    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticate(@RequestBody JwtRequest jwtRequest) throws RuntimeException {
        UserDetails userDetails =
                userService.loadUserByUsername(jwtRequest.getUsername());

        boolean doesPasswordMatch =
                passwordEncoder.matches(jwtRequest.getPassword(), userDetails.getPassword());

        if (userDetails == null || !doesPasswordMatch) {
            throw new RuntimeException("Invalid credentials or this user is not present. Please Signup first");
        }

        String jwtToken =
                jwtUtility.generateToken(userDetails);
        long expiryTimeLeft =
                (jwtUtility.getExpirationDateFromToken(jwtToken).getTime()-(new Date()).getTime());

        return ResponseEntity
                .ok(new JwtResponse(jwtToken, userDetails.getUsername(), expiryTimeLeft));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user, HttpServletRequest httpServletRequest) {

        user = userService.createUser(user);
        if (user == null) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("User already present with the given username or email!!");
        }

        Mail mail = new Mail();
        String applicationUrl =
                        httpServletRequest.getScheme() + "://" +
                        httpServletRequest.getServerName() + ":" +
                        httpServletRequest.getServerPort();

        mail.setSender("utkryuk@gmail.com");
        mail.setReceiver(user.getEmail());
        mail.setSubject("Email Confirmation");
        mail.setContent("Hi! " + user.getUsername() + "\n" + "To create your email address," +
                " click on the link below:\n" + applicationUrl + "/user/validate?token=" +
                user.getEmailValidationToken());
        mail.setSentMailDate(new Date().toString());
        mailService.sendEmail();

        return ResponseEntity
                .ok(user);
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validate(@RequestParam String token) {

        User user = userService.activate(token);
        if (user == null) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid token");
        }
        return ResponseEntity
                .ok("Account successfully activated");
    }


    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity
                .ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable(value = "id") int id) {
        User user = userService.findUserById(id);
        if (user == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No User found");
        }

        return ResponseEntity
                .ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@RequestBody User user, @PathVariable(value = "id") int id) {
        User updatedUser = userService.updateUser(user, id);
        if (updatedUser == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No User found");
        }
        return ResponseEntity
                .ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") int id) {
        boolean isUserDeleted = userService.deleteUser(id);
        if (!isUserDeleted) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No User found");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("User Deleted Successfully");
    }

}
