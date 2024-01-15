package com.latticeProject.Assignment.Models;


import com.latticeProject.Assignment.Validation.ValidName;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;

    @NotBlank
    @ValidName(message = "Invalid name")  // validate name to take min 3 character
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{10,}", message = "Phone number must consist of 10 digits")
    private String phoneNo;

    @Size(max = 20)
    private String city;

    private String symptoms;
}
