package com.latticeProject.Assignment.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<ValidName, String> {
    @Override
    public void initialize(ValidName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {

        // counting number of space to check it should have 3 character
        if (name != null) {
            int c =0;
            for(int i = 0; i < name.length(); i++){
                if(name.charAt(i) ==' '){
                    c++;
                }
            }
            if(c >2){
                return false;
            }
            return true;
        }
        return false;  // Null names are not valid
    }
}

