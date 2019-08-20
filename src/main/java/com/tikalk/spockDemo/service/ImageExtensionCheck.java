package com.tikalk.spockDemo.service;

public class ImageExtensionCheck {

    public ImageExtensionCheck(boolean result, String errorCode, String errorDescription) {
        this.result = result;
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    private boolean result;
    private String errorCode;
    private String errorDescription;
}
