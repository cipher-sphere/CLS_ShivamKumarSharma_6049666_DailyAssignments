package com.example.demo.exception;

public class MobileNumberDoesNotExistsForEmployeeException extends RuntimeException {

    public MobileNumberDoesNotExistsForEmployeeException(String mobileNumber) {
        super("No employee found with mobile number: " + mobileNumber);
    }
}
