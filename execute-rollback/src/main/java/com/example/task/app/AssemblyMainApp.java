package com.example.task.app;

import com.example.task.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AssemblyMainApp {

    public static void main(String[] args) throws Exception {
        // Registering the tasks in order
        TaskContext orderTyresTask = new OrderTyresTask();
        TaskContext orderEngineTask = new OrderEngineTask();
        TaskContext orderBodyTask = new OrderBodyTask();

        // Now, let's chain them together
        orderEngineTask.next(orderBodyTask);
        orderTyresTask.next(orderEngineTask);

        TaskManager taskManager = null;
        try{
            taskManager = new TaskManager(orderTyresTask);
            taskManager.execute();
        }catch(Exception e){
            assert taskManager != null;
            taskManager.rollback();
        }

    }
}
