package com.latticeProject.Assignment.Entity;

import com.latticeProject.Assignment.Enums.City;
import com.latticeProject.Assignment.Enums.Specialty;
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
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int docId;

    private String name;
    private String email;
    private String phoneNo;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    @Enumerated(EnumType.STRING)
    private City location;



}
