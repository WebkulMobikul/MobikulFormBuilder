package com.example.manishchoudhary.formbuilder.Helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by manish.choudhary on 2/11/17.
 */

public class Validation {
    public static boolean isEmailValid(String email) {
        boolean isValid = false;
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
}
