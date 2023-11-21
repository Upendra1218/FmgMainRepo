package com.scheduleRun;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class TestScheduler {

    public static void main(String[] args) throws SchedulerException {
        // Create a scheduler factory
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        // Get a scheduler instance
        Scheduler scheduler = schedulerFactory.getScheduler();

        // Define a job to be executed
        JobDetail job = JobBuilder.newJob(SeleniumTestJob.class)
            .withIdentity("seleniumTestJob", "group1")
            .build();

        
        // Define a job to be executed
        JobDetail job1 = JobBuilder.newJob(SeleniumTestJob.class)
            .withIdentity("seleniumTestJob", "group2")
            .build();
        
        // Define a job to be executed
        JobDetail job2 = JobBuilder.newJob(SeleniumTestJob.class)
            .withIdentity("seleniumTestJob", "group3")
            .build();
        
        
        // Define a job to be executed
        JobDetail job3 = JobBuilder.newJob(SeleniumTestJob.class)
            .withIdentity("seleniumTestJob", "group4")
            .build();
        
     // Define multiple triggers for scheduling the job at different times of the day
       
      
        Trigger trigger1 = TriggerBuilder.newTrigger()
            .withIdentity("testTrigger1", "group1")
            .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(6, 0))
            .build();

        Trigger trigger2 = TriggerBuilder.newTrigger()
            .withIdentity("testTrigger2", "group2")
            .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(22, 00))
            .build();

        Trigger trigger3 = TriggerBuilder.newTrigger()
            .withIdentity("testTrigger3", "group2")
            .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(00, 30))
            .build();

        // Start the scheduler
       // scheduler.scheduleJob(job3, trigger0);
       // scheduler.scheduleJob(job, trigger1);
        scheduler.scheduleJob(job1, trigger2);
       // scheduler.scheduleJob(job2, trigger3);
        scheduler.start();

        // Output a message indicating the execution times
        System.out.println("Execution times are set to 06:00 AM, 9:00 PM, and 12:00 AM daily.");
    }
}
