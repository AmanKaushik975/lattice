package com.latticeProject.Assignment.Service;

import java.util.HashMap;
import java.util.Map;

public class Specialty {
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
//                    result.put("Specialty", specialty);
//                    result.put("Symptoms", symptomsList);
                    return res;
                }
            }
        }

//        Map<String, Object> result = new HashMap<>();
//        result.put("Specialty", "Unknown");
//        result.put("Symptoms", new String[]{});
        return "Unkown";


    }
}
