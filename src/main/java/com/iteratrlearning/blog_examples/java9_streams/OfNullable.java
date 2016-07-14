package com.iteratrlearning.blog_examples.java9_streams;

import java.util.stream.Stream;

public class OfNullable
{
    public static void main(String[] args)
    {
        final String configurationDirectory =
            Stream.of("app.config", "app.home", "user.home")
                  .flatMap(key -> {
                      final String property = System.getProperty(key);
                      if (property == null)
                      {
                          return Stream.empty();
                      }
                      else
                      {
                          return Stream.of(property);
                      }
                  })
                  .findFirst()
                  .orElseThrow(IllegalStateException::new);

        System.out.println(configurationDirectory);
    }

}
