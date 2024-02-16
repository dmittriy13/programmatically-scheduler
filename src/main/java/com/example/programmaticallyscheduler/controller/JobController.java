package com.example.programmaticallyscheduler.controller;

import com.example.programmaticallyscheduler.controller.dto.CreateJobFixedRateRequest;
import com.example.programmaticallyscheduler.controller.dto.CreateJobFixedRateResponse;
import com.example.programmaticallyscheduler.controller.dto.StopJobRequest;
import com.example.programmaticallyscheduler.scheduled.CancellableTaskScheduler;
import com.example.programmaticallyscheduler.scheduled.task.IdentityTask;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.UUID;

@RequestMapping("/api/job")
@RestController
@RequiredArgsConstructor
public class JobController {

    private final CancellableTaskScheduler scheduler;


    @PostMapping
    public CreateJobFixedRateResponse createJobFixedRate(CreateJobFixedRateRequest request) {
        var id = UUID.randomUUID();
        var period = Duration.parse(request.getPeriod());
        scheduler.scheduleAtFixedRate(
                new IdentityTask(id) {
                    @Override
                    public void run() {
                        System.out.println(request.getText());
                    }
                },
                period
        );

        return new CreateJobFixedRateResponse(id);
    }

    @PostMapping("/stop/{id}")
    public void stopJob(@RequestBody StopJobRequest request) {
        scheduler.cancelScheduledTask(request.getId(), request.isMayInterruptIfRunning());
    }
}
