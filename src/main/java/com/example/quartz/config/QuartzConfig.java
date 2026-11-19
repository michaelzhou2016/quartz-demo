package com.example.quartz.config;

import com.example.quartz.job.SyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail syncJobDetail() {
        return JobBuilder.newJob(SyncJob.class)
                .withIdentity("syncJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger syncTrigger(JobDetail syncJobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(syncJobDetail)
                .withIdentity("syncTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * * * ?"))
                .build();
    }

}
