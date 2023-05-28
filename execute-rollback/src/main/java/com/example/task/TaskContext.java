package com.example.task;

public abstract class TaskContext {

    private TaskContext nextTask;

    public abstract void execute() throws Exception;

    public abstract void rollback() throws Exception;

    public void next(TaskContext nextTask){
        if(nextTask != null){
            this.nextTask = nextTask;
        }
    }

    public boolean hasNextTask(){
        return this.nextTask != null ;
    }

    public TaskContext getNextTask(){
        return this.nextTask;
    }

}
