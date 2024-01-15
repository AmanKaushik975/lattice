package com.latticeProject.Assignment.Service;

import com.latticeProject.Assignment.Entity.Doctor;
import com.latticeProject.Assignment.Enums.City;
import com.latticeProject.Assignment.Entity.Patient;
import com.latticeProject.Assignment.Repo.DoctorRepo;
import com.latticeProject.Assignment.Repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.latticeProject.Assignment.Service.Specialty.getSpecialtyAndSymptoms;

@Service
public class PatientService {
    @Autowired
    PatientRepo pr;

    @Autowired
    DoctorRepo dr;

    public String addPatient(Patient patient) {
        pr.save(patient);

        return "Patient is added";
    }

    // getting doctorr entity
//    public List<Doctor> getdoctor(, String location, String symptom) throws Exception {
//        // if location and symptomp matches
//        // first check location
//        try{
//            City city = City.valueOf(location);
//            // now check for symtom
//            return dr.findByLocation(location);
//
//        }
//        catch (Exception e){
//            throw new Exception("We are still waiting to expand to your location");
//        }
//
//    }
    public List<Doctor> getDoctorsByLocationAndSymptom(int pid, City location, String symptom)throws Exception {
//        try{
//            City city = City.valueOf(String.valueOf(location));
//            // now check for symtom
//            return dr.findByLocation(location);
//
//        }
//        catch (Exception e){
//            throw new Exception("We are still waiting to expand to your location");
//        }
//        finally {
//            List<Doctor> doctors = dr.findByCityAndSpecialty(location, symptom);
//            if (doctors.isEmpty()) {
//                System.out.println("There isn't any doctor present at your location for your symptom");
//            }
//
//            return doctors;
//        }

        if(symptom.length() == 0){

                    try{
            City city = City.valueOf(String.valueOf(location));
            // now check for symtom
            return dr.findByLocation(location);

        }
        catch (Exception e){
            throw new Exception("We are still waiting to expand to your location");
        }

        }
        else{

            try{
                List<Doctor> doctors = dr.findByCityAndSpecialty(location, symptom);
            if (doctors.isEmpty()) {
                System.out.println("There isn't any doctor present at your location for your symptom");
            }

            return doctors;
            }
            catch (Exception e){
                throw new Exception("eror");
            }
        }

}
}
