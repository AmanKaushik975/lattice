package com.latticeProject.Assignment.Controller;

import com.latticeProject.Assignment.Entity.Doctor;
import com.latticeProject.Assignment.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("doctor")
public class DoctorController {
    @Autowired
    DoctorService ds;
    // add doctor
    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor){
         String res = ds.addDoctor(doctor);
        return res;

    }

    // remove doctor
    @DeleteMapping("/delete")
    public ResponseEntity deleteDoctor(@RequestParam("docId") int id){
        try{
            String res = ds.deleteDoctor(id);
            return new ResponseEntity(res, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
}
