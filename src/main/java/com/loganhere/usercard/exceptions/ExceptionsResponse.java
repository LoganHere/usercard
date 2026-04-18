package com.loganhere.usercard.exceptions;

public class ExceptionsResponse {

    private String title;
    private String code;
    private String description;

    public ExceptionsResponse(String title, String code, String description) {
        this.title = title;
        this.code = code;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
