package com.iteratrlearning.blog_examples.process_api;

public class ApplicationCleaner
{
    public static void main(String[] args)
    {
        cleanupApplication("chrome");
    }

    private static void cleanupApplication(String applicationName)
    {
        ProcessHandle.allProcesses()
                     .filter(process -> isApplication(applicationName, process))
                     .forEach(process ->
                         process.info().command().ifPresent(command ->
                             closeAndLog(process, command)));
    }

    private static
    void closeAndLog(ProcessHandle process, String command)
    {
        String status = process.destroyForcibly() ? " Success!" : " Failed";
        System.out.println("Killing ... " + command + status);
    }

    private static boolean isApplication(final String appName, final ProcessHandle process)
    {
        return process.info().command().filter(command -> command.contains(appName)).isPresent();
    }
}
