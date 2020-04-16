package com.quantitymeasurement.dto;

public class ResponseDTO {

    public double convertedValue;
    public String response;
    public int status;

    public ResponseDTO(double convertedValue, String response, int status) {
        this.convertedValue = convertedValue;
        this.response = response;
        this.status = status;
    }

    public double getConvertedValue() {
        return convertedValue;
    }

    public String getResponse() {
        return response;
    }

    public int getStatus() {
        return status;
    }
}
