package com.tikalk.spockDemo.service;

public class ImageNameValidator {
    public boolean isValidImageExtension(String fileName) {
        fileName = fileName.toLowerCase();
        return fileName.endsWith(".jpg") ||
                fileName.endsWith(".jpeg") ||
                fileName.endsWith(".png");
    }

    public ImageExtensionCheck validateImageExtension(String fileName) {
        fileName = fileName.toLowerCase();
        boolean result = fileName.endsWith(".jpg") ||
                fileName.endsWith(".jpeg") ||
                fileName.endsWith(".png");
        String errorCode = "";
        String errorDescription = "";
        if(!result) {
            if (fileName.endsWith(".tiff")) {
                errorCode = "ERROR002";
                errorDescription = "Tiff files are not supported";
            } else {
                errorCode = "ERROR999";
                errorDescription = "Unsupported file type";
            }
        }
        return new ImageExtensionCheck(result, errorCode, errorDescription);
    }
}
