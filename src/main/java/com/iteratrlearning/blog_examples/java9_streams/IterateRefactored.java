package com.iteratrlearning.blog_examples.java9_streams;

import java.util.stream.Stream;

public class IterateRefactored
{
    public static void main(String[] args)
    {
        // 1. Show that it never terminates
        // 2. use new iterate with filter method

        Stream.iterate(3, x -> x < 100, x -> x + 3)
              .forEach(System.out::println);
    }

}
