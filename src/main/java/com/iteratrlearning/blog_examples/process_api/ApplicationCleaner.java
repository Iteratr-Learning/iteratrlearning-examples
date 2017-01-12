package com.iteratrlearning.blog_examples.process_api;

public class ApplicationCleaner
{
    public static void main(String[] args)
    {
        cleanupApplication("chrome");
    }

    private static void cleanupApplication(final String applicationName)
    {
        ProcessHandle.allProcesses()
                     .filter(process -> isApplication(applicationName, process))
                     .forEach(process ->
                     {
                         process.info().command().ifPresent(command ->
                         {
                             System.out.println("Killing ... " + command);
                             if (process.destroyForcibly())
                             {
                                 System.out.println("Success!");
                             }
                             else
                             {
                                 System.out.println("Failed");
                             }
                         });
                     });
    }

    private static boolean isApplication(final String chrome, final ProcessHandle process)
    {
        return process.info().command().filter(command -> command.contains(chrome)).isPresent();
    }
}
