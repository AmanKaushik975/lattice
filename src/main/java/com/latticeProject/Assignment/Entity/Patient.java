package com.latticeProject.Assignment.Entity;

import com.latticeProject.Assignment.Enums.Symptom;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;
    private String name;
    private String email;
    private String phoneNo;
    private String city;
    @Enumerated(EnumType.STRING)
    private Symptom symptoms;
}
