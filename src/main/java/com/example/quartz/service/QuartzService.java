package com.example.quartz.service;

import com.example.quartz.job.SyncJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuartzService {

    @Autowired
    private Scheduler scheduler;

    public void addJob(
            String jobName,
            String cron) throws SchedulerException {

        JobDetail jobDetail = JobBuilder.newJob(SyncJob.class)
                .withIdentity(jobName)
                .build();

        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(jobName + "_trigger")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule(cron)
                )
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
    }
}
