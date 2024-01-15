package com.latticeProject.Assignment.Repo;

import com.latticeProject.Assignment.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient,Integer> {

}
