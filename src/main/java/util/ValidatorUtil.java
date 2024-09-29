package util;

import java.util.Set;

import entity.District;
import entity.Province;
import entity.User;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ValidatorUtil {
	
	public static String validatorUser(User user) {
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
		Set<ConstraintViolation<User>> violations  = validator.validate(user);
		
		if (!violations.isEmpty()) {
            return violations.iterator().next().getMessage();
        }
		
		return null;
	}
	
	public static String validatorProvince(Province province) {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Province>> violations = validator.validate(province);

		if (!violations.isEmpty()) {
			return violations.iterator().next().getMessage();
		}

		return null;
	}
	
	public static String validatorDistrict(District district) {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<District>> violations = validator.validate(district);

		if (!violations.isEmpty()) {
			return violations.iterator().next().getMessage();
		}

		return null;
	}
	
}
