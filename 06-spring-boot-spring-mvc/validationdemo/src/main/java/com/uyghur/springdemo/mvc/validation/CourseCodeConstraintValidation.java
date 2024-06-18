package com.uyghur.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidation implements ConstraintValidator<CourseCode,String> {

    private String coursePrefix;
    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;

        if (theCode != null) {
            result=theCode.startsWith(coursePrefix);
        } else {
            result = true;
        }

        return result;
    }

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        coursePrefix = constraintAnnotation.value();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
