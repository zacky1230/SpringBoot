package com.wisely.hightlight_spring4.ch3.taskscheduler;

import com.wisely.hightlight_spring4.ch3.taskexecutor.TaskExecutorConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        ScheduledTaskService scheduledTaskService = context.getBean
                (ScheduledTaskService.class);
        context.close();
    }
}
