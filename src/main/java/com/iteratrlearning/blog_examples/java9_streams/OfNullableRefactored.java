package com.iteratrlearning.blog_examples.java9_streams;

import java.util.stream.Stream;

public class OfNullableRefactored
{
    public static void main(String[] args)
    {
        // 1. Show verbose code
        // 2. Introduce Stream.ofNullable();

        final String configurationDirectory =
            Stream.of("app.config", "app.home", "user.home")
                  .flatMap(key -> Stream.ofNullable(System.getProperty(key)))
                  .findFirst()
                  .orElseThrow(IllegalStateException::new);

        System.out.println(configurationDirectory);
    }

}
