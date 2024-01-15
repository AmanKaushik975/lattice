package com.latticeProject.Assignment.Repo;

import com.latticeProject.Assignment.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepo extends JpaRepository<Patient,Integer> {

}
