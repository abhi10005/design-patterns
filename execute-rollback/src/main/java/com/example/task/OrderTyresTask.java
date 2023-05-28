package com.example.task;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderTyresTask extends TaskContext{

    @Override
    public void execute() throws Exception {
        log.info("Ordering the tyres now");
    }

    @Override
    public void rollback() throws Exception {
        log.warn("Rolling back the orders for tyres");
    }
}