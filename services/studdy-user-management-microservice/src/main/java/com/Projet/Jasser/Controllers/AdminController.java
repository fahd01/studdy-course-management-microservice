package com.Projet.Jasser.Controllers;



import com.Projet.Jasser.Entity.Role;
import com.Projet.Jasser.Entity.User;
import com.Projet.Jasser.Interfaces.UserService;
import com.Projet.Jasser.Repository.UserRepository;
import com.Projet.Jasser.Security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api/admin")//pre-path
@CrossOrigin(origins = "*")
public class AdminController
{


    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository ;

    @GetMapping("all")//api/admin/all
    public ResponseEntity<?> findAllUsers()
    {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PutMapping("/lock/{userId}")
    public ResponseEntity<?> lockUser(@PathVariable Long userId ,@RequestBody Long adminId) {
        userService.lockUser(userId , adminId);
        return ResponseEntity.ok(true);
    }

    @PutMapping("/unlock/{userId}")
    public ResponseEntity<?> unlockUser(@PathVariable Long userId ,@RequestBody  Long adminId) {
        userService.unlockUser(userId ,adminId);
        return ResponseEntity.ok(true);
    }

    @PutMapping("/change/{userId}/{role}") // api/user/change/{userId}/{role}
    public ResponseEntity<?> changeRole(
            @PathVariable Long userId, // Assuming userId is of type Long
            @PathVariable Role role,
            @AuthenticationPrincipal UserPrincipal userPrincipal) {

        userService.changeRole(userId, role, userPrincipal.getUsername()); // Pass userId to the service
        return ResponseEntity.ok(true);
    }


    @PutMapping("/makeAdmin/{username}")
    public ResponseEntity<?> makeAdmin(@PathVariable(value="username") String username) {
        userService.makeAdmin(username);
        return ResponseEntity.ok(true);
    }
    @GetMapping("/admins")
    public List<User> allAdmins(){
    	return userService.allAdmins();
    }





    @DeleteMapping("/deleteAdmin/{userId}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long userId) {
        try {
            userService.deleteAdminById(userId);
            return ResponseEntity.noContent().build(); // Return 204 No Content if the deletion is successful
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // Return 404 Not Found if the admin is not found
        }
    }




}
