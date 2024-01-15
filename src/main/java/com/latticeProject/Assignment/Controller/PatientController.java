package com.latticeProject.Assignment.Controller;

import com.latticeProject.Assignment.Entity.Doctor;
import com.latticeProject.Assignment.Entity.Patient;
import com.latticeProject.Assignment.Enums.City;
import com.latticeProject.Assignment.Repo.PatientRepo;
import com.latticeProject.Assignment.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patient")
public class PatientController {
    @Autowired
    PatientService ps;

    // add patient
    @PostMapping("/add")
    public String addPatient(@RequestBody Patient patient){
       String res = ps.addPatient(patient);
        return res;
    }

    // getting doctor pid,location , symtomp

//    @GetMapping("/getDoctor")   // give doctor Entity
//    public ResponseEntity getdoctor(@RequestParam("pid") int pid , @RequestParam("location") City location , @RequestParam("symptom") String symptom){
//        try{
//            List<Doctor> doctor = ps.getDoctorsByLocationAndSymptom(pid,location,symptom);
//            return new ResponseEntity<>(doctor, HttpStatus.ACCEPTED);
//        }
//        catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
//        }
//    }

}
