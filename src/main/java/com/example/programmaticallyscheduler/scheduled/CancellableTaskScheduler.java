package com.example.programmaticallyscheduler.scheduled;

import com.example.programmaticallyscheduler.scheduled.task.IdentityTask;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

@Service
public class CancellableTaskScheduler extends ThreadPoolTaskScheduler {

    private final Map<UUID, ScheduledFuture<?>> scheduledTasks = new ConcurrentHashMap<>();

    public void scheduleAtFixedRate(IdentityTask task, Duration period) {
        ScheduledFuture<?> future = super.scheduleAtFixedRate(task, period);
        scheduledTasks.put(task.getId(), future);
    }

    public void cancelScheduledTask(UUID id, boolean mayInterruptIfRunning) {
        ScheduledFuture<?> future = scheduledTasks.get(id);
        if (null != future) {
            future.cancel(mayInterruptIfRunning);
        }
    }
}