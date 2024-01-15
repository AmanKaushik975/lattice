package com.latticeProject.Assignment.Service;

import com.latticeProject.Assignment.Models.Doctor;
import com.latticeProject.Assignment.Enums.City;
import com.latticeProject.Assignment.Models.Patient;
import com.latticeProject.Assignment.Repo.DoctorRepo;
import com.latticeProject.Assignment.Repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientService {
    @Autowired
    PatientRepo pr;

    @Autowired
    DoctorRepo dr;

    // adding patient
    public String addPatient(Patient patient) {
        pr.save(patient);

        return "Patient is added";
    }

    // Deleting patent
    public String deleteDoctor(int id) throws Exception {
        Optional<Patient> optionalPatient = pr.findById(id);

        if(!optionalPatient.isPresent()){
            throw  new Exception("with given id Patient is not presnet");
        }
        Patient patient =  optionalPatient.get();
        pr.delete(patient);
        return  "Patient with given id is removed";
    }


    // getting doctorr entity
    public List<Doctor> suggestDoctors(int patientId, String location, String symptom) {
        // Retrieve the patient
        Patient patient = pr.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // Convert the location String to City

        City patientLocation;
        try {
            patientLocation = City.valueOf(location.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("We are still waiting to expand to your location");
        }

        // Check if the patient's location is valid
        if (!EnumSet.of(City.DELHI, City.NOIDA, City.FARIDABAD).contains(patientLocation)) {
            throw new RuntimeException("We are still waiting to expand to your location");
        }

        // Find doctors with the given location and specialty matching patient's symptom
       String s =  getSpecialtyAndSymptoms(symptom);
        List<Doctor> suggestedDoctors = dr.findByLocationAndSpecialty(location, s);

        // Check if there are doctors available for the given symptom at the patient's location
        if (suggestedDoctors.isEmpty()) {
            throw new RuntimeException("There isn't any doctor present at your location for your symptom");
        }

        return suggestedDoctors;
    }

    // Helper method to map Symptom enum to Specialty enum
    public static String getSpecialtyAndSymptoms(String symptom) {
        Map<String, Object> specialties = new HashMap<>();
        specialties.put("Orthopedic", new String[]{"Arthritis", "Back Pain", "Tissue injuries"});
        specialties.put("Gynecology", new String[]{"Dysmenorrhea"});
        specialties.put("Dermatology", new String[]{"Skin infection", "Skin burn"});
        specialties.put("ENT", new String[]{"Ear pain"});

        for (Map.Entry<String, Object> entry : specialties.entrySet()) {
            String specialty = entry.getKey();
            String[] symptomsList = (String[]) entry.getValue();

            for (String s : symptomsList) {
                if (s.equals(symptom)) {
                    String res;
                    res = specialty;

                    return res;
                }
            }
        }

        return "Unkown";


    }


}




