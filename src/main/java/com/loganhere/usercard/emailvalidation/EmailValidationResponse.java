package com.loganhere.usercard.emailvalidation;

public class EmailValidationResponse {
    private boolean isValid;

    public EmailValidationResponse() {
    }

    public EmailValidationResponse(boolean isValid) {
        this.isValid = isValid;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
