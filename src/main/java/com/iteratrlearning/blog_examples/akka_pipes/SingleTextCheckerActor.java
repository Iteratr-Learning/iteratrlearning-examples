package com.iteratrlearning.blog_examples.akka_pipes;

import akka.actor.UntypedActor;

import java.util.Arrays;

public class SingleTextCheckerActor extends UntypedActor {
    private final static String[] forbiddenWords = {"isn't", "i'm", "don't"};

    @Override
    public void onReceive(Object message) throws Throwable {
        String lowercaseMessage = ((String) message).toLowerCase();
        if(!containsForbiddenWord(lowercaseMessage)){
            getSender().tell(message, getSelf());
        }
    }

    private boolean containsForbiddenWord(String message) {
        return Arrays.stream(forbiddenWords)
                .anyMatch(message::contains);
    }
}