/*package com.example.demo.Controller;

import com.example.demo.Models.Admin;
import com.example.demo.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/secure/rest")
public class AdminController {

    @Autowired
    private AdminRepo adminRepo;

   // @Autowired
    //private PasswordEncoder passwordEncoder;


    /*@PostMapping("/admin/add")
    public String addUserByAdmin(User user){
        String pwd = user.getPassword();
        String encryptpwd = passwordEncoder.encode(pwd);
        user.setPassword(encryptpwd);
        userRepo.save(user);
        return  "User added successfully";
    }*/

   /* //signup
    @PostMapping("/signup")
    public String signUp(@RequestBody Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepo.save(admin);
        return "Admin registered successfully";
    }

    //loging in
    @PostMapping("/login/{email}/{password}")
    public String login(@PathVariable(value = "email") String email,
                        @PathVariable(value = "password") String password) {
        Admin admin = adminRepo.findByEmail(email);
        if (admin == null) {
            return "Invalid email or password.";
        }
        boolean isTrue = passwordEncoder.matches(password, admin.getPassword());
        if (isTrue){
            return "Logged in successfully";
        }else {
            return "Invalid email or password.";
        }
    }*/


//}
package com.example.demo.Controller;

import com.example.demo.Models.Admin;
import com.example.demo.Repository.AdminRepo;
import com.example.demo.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRepo adminRepo;

   /* @Autowired
    private PasswordEncoder passwordEncoder;*/


    @PostMapping("/add")
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    @GetMapping("/getadmin/{id}")
    public Optional<Admin> getAdminById(@PathVariable String id) {
        return adminService.getAdminById(id);
    }

    @GetMapping("/")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        return new ResponseEntity<List<Admin>>(adminService.getAllAdmin(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteadmin/{id}")
    public void deleteAdmin(@PathVariable String id) {
        adminService.deleteAdmin(id);
    }
}