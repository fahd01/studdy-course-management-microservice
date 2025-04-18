package com.Projet.Jasser.auth;

import com.Projet.Jasser.Entity.User;
import com.Projet.Jasser.Exceptions.*;
import com.Projet.Jasser.Interfaces.UserService;
import com.Projet.Jasser.Repository.UserRepository;
import com.Projet.Jasser.auth.Dtoauth.PasswordResetToken;
import com.Projet.Jasser.auth.interfaces.AuthenticationService;
import com.Projet.Jasser.auth.interfaces.JwtRefreshTokenService;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("api/authentication")
@CrossOrigin(origins = "*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtRefreshTokenService jwtRefreshTokenService;


     @PostMapping(value = "/sign-up", consumes = "application/json")
    public ResponseEntity<?> signUp(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (UsernameExist | EmailExist ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            return new ResponseEntity<>("Registration failed. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/sign-in", consumes = "application/json")
    public ResponseEntity<User> signIn(@RequestBody User user) throws AccountLockedException {
        // Log the incoming request
        System.out.println("Sign-in attempt for user: " + user.getUsername());

        User u = userRepository.findByUsername(user.getUsername()).orElse(null);
        System.out.println(user);
        System.out.println(u);

        // Check if user exists
        if (u != null) {
            System.out.println("User found: " + u.getUsername());

            // Check if the account is locked
            if (!u.isLocked()) {
                System.out.println("User account is not locked.");

                // Check for login attempts and password match
                if (u.getLoginAttempts() < 4) {
                    System.out.println("Current login attempts: " + u.getLoginAttempts());

                    String providedPassword = user.getPassword().trim();; // The password provided by the user
                    String storedEncodedPassword = u.getPassword(); // The stored encoded password

                    // Log both passwords (BE CAUTIOUS about logging sensitive information in production)
                    System.out.println("Provided password: " + providedPassword);
                    System.out.println("Stored encoded password: " + storedEncodedPassword);

                    boolean passwordMatches = passwordEncoder.matches(providedPassword, storedEncodedPassword);
                    System.out.println("Password match result: " + passwordMatches);

                    if (!passwordMatches) {
                        u.setLoginAttempts(u.getLoginAttempts() + 1);
                        userRepository.save(u);

                        // Check if the account should be locked
                        if (u.getLoginAttempts() == 4) {
                            u.setLocked(true);
                            userRepository.save(u);
                            System.out.println("Account has been locked due to too many failed attempts.");
                            throw new AccountLockedException("Your account has been locked, please contact the administration !");
                        } else {
                            System.out.println("Incorrect password. Attempts increased to: " + u.getLoginAttempts());
                            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); // Optionally return a 401 status
                        }
                    } else {
                        u.setLoginAttempts(0); // Reset attempts on successful login
                        userRepository.save(u);
                        System.out.println("User authenticated successfully. JWT being generated.");
                        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
                    }
                } else {
                    System.out.println("Account is locked due to too many attempts.");
                    throw new AccountLockedException("Your account has been locked, please contact the administration !");
                }
            } else {
                System.out.println("User account is locked.");
                throw new AccountLockedException("Your account has been locked, please contact the administration !");
            }
        } else {
            System.out.println("User not found: " + user.getUsername());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if user not found
        }
    }


    @PostMapping("/reset-password")
    public ResponseEntity<?> generatePasswordResetToken(@RequestParam String email) {
        try {
            PasswordResetToken token = authenticationService.generatePasswordResetToken(email);
            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (EmailNotExist | IOException | MessagingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/reset-password/new")
    public ResponseEntity<?> updatePassword(@RequestParam String token, @RequestBody Map<String, String> body) {
        String newPassword = body.get("newPassword"); // Extract the new password from the JSON body

        try {
            authenticationService.updatePassword(token, newPassword);
            // Return a JSON object
            return ResponseEntity.ok(Collections.singletonMap("message", "Your password has been successfully updated!"));
        } catch (ResetPasswordException | ResetPasswordTokenException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("error", e.getMessage()));
        }
    }


    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestParam String token) {
        return ResponseEntity.ok(jwtRefreshTokenService.generateAccessTokenFromRefreshToken(token));
    }


}
