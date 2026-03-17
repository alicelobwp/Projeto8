package com.example.MayaFisioLumiere.controller;

import com.example.MayaFisioLumiere.Domain.Admin.AdminRequestDTO;
import com.example.MayaFisioLumiere.Services.AdminService;
import com.example.MayaFisioLumiere.entity.AdminEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/register/admin")
    public ResponseEntity<AdminEntity> create(@RequestBody AdminRequestDTO body, String hashedPassword){
        AdminEntity newAdmin = this.adminService.createAdmin(body, hashedPassword);
        return ResponseEntity.ok(newAdmin);
    }
    @PostMapping("/login/admin")
    public AdminEntity login(@RequestBody AdminEntity admin){

        return adminService.loginAdmin(
                admin.getAdminEmail(),
                admin.getAdminPassword()
        );
    }

    //FAZER LOGOUT QUANDO TIVER JWT, HASH...
}
