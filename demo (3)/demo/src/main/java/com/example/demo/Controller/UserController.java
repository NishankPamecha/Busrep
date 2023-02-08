package com.example.demo.Controller;

import com.example.demo.Models.Admin;
import com.example.demo.Models.User;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

   /* @Autowired
    private PasswordEncoder passwordEncoder;*/


    @PostMapping("/add")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/getuser/{id}")
    public Optional<User> getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteuser/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    /*@PutMapping("/updateuser/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id,user);
}*/

   /*@PostMapping("/signup")
    public String signUp(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return "User registered successfully";
    }

    @PostMapping("/login/{email}/{password}")
    public String login(@PathVariable(value = "email") String email,
                        @PathVariable(value = "password") String password) {
        User user1 = userRepo.findByEmail(email);
        if (user1 == null) {
            return "Invalid email or password.";
        }
        boolean isTrue = passwordEncoder.matches(password, user1.getPassword());
        if (isTrue) {
            return "Logged in successfully";
        } else {
            return "Invalid email or password.";
        }



    }*/

    @PostMapping("/msg")
    public String msg(){
       return "hi";
    }
}
