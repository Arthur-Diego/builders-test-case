package com.builders.testcase.utils;

public class ResourceUtils {

    public static final String DESCRIPTION_OPERATION_VALID = "Checks whether the imputed password is valid";

    public static final String CODE_200 = "Request is valid";
    public static final String CODE_400 = "Error business";
    public static final String CODE_500 = "Error of system";

    public static final String NOTES = "* Nine or more characters\n" +
            "* At least 1 digit\n" +
            "* At least 1 lowercase letter\n" +
            "* At least 1 capital letter\n" +
            "* At least 1 special character\n" +
            "* Consider the following characters as special :! @ # $% ^ & * () - +\n" +
            "* Do not have repeated characters within the set\n" +
            "* Blanks should not be considered as valid characters";
}
