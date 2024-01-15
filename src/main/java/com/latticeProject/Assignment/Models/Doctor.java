package com.latticeProject.Assignment.Models;

import com.latticeProject.Assignment.Enums.City;
//import com.latticeProject.Assignment.Enums.Specialty;
import com.latticeProject.Assignment.Validation.ValidName;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int docId;

    @NotBlank
    @ValidName(message = "Invalid name")  // validate name to take min 3 character
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{10,}", message = "Phone number must consist of 10 digits")
    private String phoneNo;

    private String specialty;

    @Size(max = 20)
    private String location;



}
