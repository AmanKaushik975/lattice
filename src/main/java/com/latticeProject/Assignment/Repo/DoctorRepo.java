package com.latticeProject.Assignment.Repo;

import com.latticeProject.Assignment.Entity.Doctor;
import com.latticeProject.Assignment.Enums.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
    List<Doctor> findByLocation(City location);

    List<Doctor> findByCityAndSpecialty(City location, String symptom);
}
