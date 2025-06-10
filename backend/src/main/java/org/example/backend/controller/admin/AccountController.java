package org.example.backend.controller.admin;

import jakarta.validation.Valid;
import org.example.backend.dto.RegisterDto;
import org.example.backend.entity.Admin;
import org.example.backend.entity.Role;
import org.example.backend.repository.admin.AdminRepository;
import org.example.backend.repository.admin.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class AccountController {

    private final AdminRepository adminRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public AccountController(AdminRepository adminRepository, RoleRepository roleRepository) {
        this.adminRepository = adminRepository;
        this.roleRepository = roleRepository;
    }
    @GetMapping("/admin/register")
    public String register(Model model) {
        RegisterDto registerDto = new RegisterDto();
        model.addAttribute("registerDto", registerDto);
        model.addAttribute("success",false);
        return "admin/pages/login/sign-up";
    }
    @PostMapping("/admin/register")
    public String register(Model model, @Valid @ModelAttribute RegisterDto registerDto, BindingResult result) {
        boolean hasError = false;
        if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())) {
            result.addError(
                    new FieldError("registerDto", "confirmPassword", "Password do not match!")
            );
            hasError = true;
        }
        Optional<Admin> admin = adminRepository.findByEmail(registerDto.getEmail());
        if (admin.isPresent()) {
            result.addError(
                    new FieldError("registerDto", "email", "Email address is already used!")
            );
            hasError = true;
        }
        Role role = null;
        try {
            role = roleRepository.findByName("ADMIN");
        } catch (Exception e) {
            result.addError(new FieldError("registerDto", "role", e.getMessage()));
            hasError = true;
        }
        if (!result.hasErrors() && !hasError) {
            try {
                var bCryptEncoder = new BCryptPasswordEncoder();
                Admin newAdmin = new Admin();
                newAdmin.setFirstName(registerDto.getFirstName());
                newAdmin.setLastName(registerDto.getLastName());
                newAdmin.setEmail(registerDto.getEmail());
                newAdmin.setRole(role);
                newAdmin.setCreatedAt(LocalDateTime.now());
                newAdmin.setPassword(bCryptEncoder.encode(registerDto.getPassword()));
                //Add new admin
                adminRepository.save(newAdmin);
                model.addAttribute("registerDto", new RegisterDto());
                model.addAttribute("success", true);
            } catch (Exception ex) {
                result.addError(
                        new FieldError("registerDto", "firstName",
                                ex.getMessage()));
            }

        }
        return "admin/pages/login/sign-up";
    }
}
