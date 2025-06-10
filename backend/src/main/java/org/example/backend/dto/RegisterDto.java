package org.example.backend.dto;
import jakarta.validation.constraints.*;
import lombok.*;
@Data
public class RegisterDto {
    @Size(min = 3, max = 20, message = "Invalid first name!(3-20 characters)")
    private String firstName;
    @Size(min = 3, max = 20, message = "Invalid first name!(3-20 characters)")
    private String lastName;
    @NotBlank(message = "Email is required!")
    @Email(message = "Email is invalid!")
    private String email;
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, max = 20, message = "Password must length: 8-20 characters")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$",
            message = "Password must contain at least one number, one lowercase letter and one uppercase letter")
    private String password;

    private String confirmPassword;
    @AssertTrue(message = "You must accept the terms and privacy policy")
    private boolean accept;
}
