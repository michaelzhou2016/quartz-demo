package com.example.quartz.job;

import com.example.quartz.service.SyncService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@DisallowConcurrentExecution
@Component
public class SyncJob implements Job {
    private static final Logger log = LoggerFactory.getLogger(SyncJob.class);

    @Autowired
    private SyncService syncService;


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        log.info("开始同步数据");

        try {
            syncService.sync();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        log.info("同步完成");
    }
}
