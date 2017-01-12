package com.iteratrlearning.blog_examples.process_api;

public class ApplicationCleaner
{
    public static void main(String[] args)
    {
        cleanupApplication("chrome");
    }

    private static void cleanupApplication(final String applcationName)
    {
        ProcessHandle.allProcesses()
                     .filter(process -> isApplication(applcationName, process))
                     .forEach(process ->
                     {
                         System.out.println("Killing ... " + process.info().command().get());
                         if (process.destroyForcibly())
                         {
                             System.out.println("Success!");
                         }
                     });
    }

    private static boolean isApplication(final String chrome, final ProcessHandle process)
    {
        return process.info().command().filter(command -> command.contains(chrome)).isPresent();
    }
}
