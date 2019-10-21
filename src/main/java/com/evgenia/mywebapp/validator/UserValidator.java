package com.evgenia.mywebapp.validator;

import com.evgenia.mywebapp.model.User;
import com.evgenia.mywebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 *  Valodator for {@link com.evgenia.mywebapp.model.User} class
 *  implements {@link Validator} interface
 */


public class UserValidator implements org.springframework.validation.Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");
        if (user.getUserName().length() < 8 || user.getUserName().length() > 32){
            errors.rejectValue("username", "Size.userForm.username");
        }

        //if db already have this username
        if (userService.findByUserName(user.getUserName()) != null){
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (user.getUserPassword().length() < 8 ){
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getConfirmPassword().equals(user.getUserName())){
            errors.rejectValue("confirmPassword", "Different.userForm.password");
        }
    }
}
