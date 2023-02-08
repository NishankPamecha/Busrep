package com.example.demo.Services;

import com.example.demo.Models.Admin;
import com.example.demo.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    public Admin createAdmin(Admin admin) {

        return adminRepo.save(admin);
    }

    public Optional<Admin> getAdminById(String id) {

        return adminRepo.findById(id);
    }

    public List<Admin> getAllAdmin()
    {
        return adminRepo.findAll();
    }

    public void deleteAdmin(String id) {

        adminRepo.deleteById(id);
    }

    public Admin updateAdmin(String id, Admin admin) {
        Admin existingAdmin = adminRepo.findById(id).orElse(null);
        if (existingAdmin != null) {
            existingAdmin.setEmail(admin.getEmail());
            existingAdmin.setFname(admin.getFname());
            existingAdmin.setLname(admin.getLname());
            existingAdmin.setPassword(admin.getPassword());
            existingAdmin.setRole(admin.getRole());
            return adminRepo.save(existingAdmin);
        } else {
            return null;
        }
    }

}
