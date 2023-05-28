package com.example.task;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderBodyTask extends TaskContext {

    @Override
    public void execute() throws Exception {
        log.info("Ordering the body now");
    }

    @Override
    public void rollback() throws Exception {
        log.warn("Rolling back the orders for body");
    }
}