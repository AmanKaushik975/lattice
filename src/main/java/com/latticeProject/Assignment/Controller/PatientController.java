package com.latticeProject.Assignment.Controller;

import com.latticeProject.Assignment.Models.Doctor;
import com.latticeProject.Assignment.Models.Patient;
import com.latticeProject.Assignment.Enums.City;
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

    // delete patient
    @DeleteMapping("/delete")
    public ResponseEntity deleteDoctor(@RequestParam("pid") int id) {
        try {
            String res = ps.deleteDoctor(id);
            return new ResponseEntity(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    // getting doctor pid,location , symtomp

    @GetMapping("/getDoctor")   // give doctor Entity
    public ResponseEntity getdoctor(@RequestParam("pid") int pid , @RequestParam("location") String location , @RequestParam("symptom") String symptom){
        try{
            List<Doctor> doctor = ps.suggestDoctors(pid,location,symptom);
            return new ResponseEntity<>(doctor, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
