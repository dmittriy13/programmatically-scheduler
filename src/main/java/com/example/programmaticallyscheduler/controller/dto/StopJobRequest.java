package com.example.programmaticallyscheduler.controller.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class StopJobRequest {
    private UUID id;
    private boolean mayInterruptIfRunning;
}
