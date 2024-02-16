package com.example.programmaticallyscheduler.controller.dto;

import lombok.Data;

@Data
public class CreateJobFixedRateRequest {

    private String text;
    private String period;
}
