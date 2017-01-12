package com.iteratrlearning.blog_examples.process_api;

import java.time.Duration;
import java.util.Comparator;

public class ApplicationRuntimeReport
{
    public static void main(String[] args)
    {
        final String userName = System.getProperty("user.name");
        ProcessHandle.allProcesses()
                     .map(ProcessHandle::info)
                     .filter(info -> info.user().filter(name -> name.contains(userName)).isPresent())
                     .sorted(Comparator.comparing(info -> info.totalCpuDuration().orElse(Duration.ZERO)))
                     .forEach(info ->
                         info.command().ifPresent(command ->
                             info.totalCpuDuration().ifPresent(duration ->
                                 System.out.println(command + " has been running for " + duration))));
    }
}
