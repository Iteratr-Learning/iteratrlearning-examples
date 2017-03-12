package com.iteratrlearning.blog_examples.akka_pipes;

import java.util.Arrays;

public class PipesAndFilterProblem {
    public static void main(String[] args) {
        String[] forbiddenWords = {"isn't", "i'm", "don't"};
        String message = "I am feeling \\beta!";
        String messageLowerCase = message.toLowerCase();
        if(Arrays.stream(forbiddenWords).noneMatch(messageLowerCase::contains)) {
            String converted =  message.replaceAll("\\\\alpha", "α").replaceAll("\\\\beta", "β");
            // ... upload to S3
            System.out.println(converted);
        }
    }
}
