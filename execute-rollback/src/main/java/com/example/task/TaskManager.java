package com.example.task;


import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

@Slf4j
public class TaskManager {

    private TaskContext entryTask;
    private Stack<TaskContext> rollbackTasks = new Stack<>();

    public TaskManager(TaskContext entryTask){
        this.entryTask = entryTask;
    }

    public void execute() throws Exception {
        executeTask(entryTask);
    }

    private void executeTask(TaskContext task) throws Exception {
        if(task != null){
            task.execute();
            rollbackTasks.add(task);
            if(task.hasNextTask()){
                executeTask( task.getNextTask());
            }
        }
    }

    public void rollback() throws Exception {
        while(!rollbackTasks.isEmpty()){
            TaskContext taskToRollback = rollbackTasks.pop();
            try{
                taskToRollback.rollback();
            }catch (Exception e){
                log.error("Rollback for task {} failed with error ", taskToRollback.getClass().getName(), e);
            }
        }
    }
}
