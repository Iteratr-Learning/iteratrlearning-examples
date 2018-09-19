package com.iteratrlearning.blog_examples.nestmates;

public class StringExample {

    public static void main(String[] args) {
        iterateString("abc");
        iterateString("1");
        iterateString("");
    }

    private static void iterateString(String abc) {
        System.out.println("Iterating: '" + abc + "'");
        for (Character character : new StringIterable(abc)) {
            System.out.println(character);
        }
    }

}
