package com.example.programmaticallyscheduler.scheduled.task;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Getter
public abstract class IdentityTask implements Runnable {
    private final UUID id;
}
