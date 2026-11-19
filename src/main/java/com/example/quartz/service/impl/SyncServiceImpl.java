package com.example.quartz.service.impl;

import com.example.quartz.service.SyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SyncServiceImpl implements SyncService {

    @Override
    public void sync() {
        log.info("sync");
    }
}
