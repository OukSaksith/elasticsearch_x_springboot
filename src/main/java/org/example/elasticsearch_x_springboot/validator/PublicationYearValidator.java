package org.example.elasticsearch_x_springboot.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.elasticsearch_x_springboot.metadata.PublicationYear;

import java.time.Year;

public class PublicationYearValidator implements ConstraintValidator<PublicationYear, Integer> {

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return !Year.of(integer).isAfter(Year.now());
    }
}
