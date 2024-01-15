package com.latticeProject.Assignment.Service;

import com.latticeProject.Assignment.Entity.Doctor;
import com.latticeProject.Assignment.Repo.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    DoctorRepo dr;

    public String addDoctor(Doctor doctor) {
        dr.save(doctor);
        return "doc saved";
    }

    public String deleteDoctor(int id) throws Exception {
        // i have id .. now find entity from it
        Optional<Doctor> optionalDoctor = dr.findById(id);

        if(!optionalDoctor.isPresent()){
            throw  new Exception("with given id Doctor is not presnet");
        }
        Doctor doctor =  optionalDoctor.get();
        dr.delete(doctor);
        return  "doc with given id id removed";
    }
}
