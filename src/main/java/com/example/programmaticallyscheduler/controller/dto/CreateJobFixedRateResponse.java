package com.example.programmaticallyscheduler.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CreateJobFixedRateResponse {
    private UUID id;
}
