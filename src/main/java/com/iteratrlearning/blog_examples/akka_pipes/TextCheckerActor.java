package com.iteratrlearning.blog_examples.akka_pipes;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import java.util.Arrays;

public class TextCheckerActor extends UntypedActor {

    private ActorRef nextActor;
    private final static String[] forbiddenWords = {"isn't", "i'm", "don't"};
    private LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    public TextCheckerActor(ActorRef nextActor) {
        this.nextActor = nextActor;
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        log.info("Received Message: " + message);
        String lowercaseMessage = ((String) message).toLowerCase();
        if(!containsForbiddenWord(lowercaseMessage)){
            nextActor.tell(message, getSelf());
        }
    }

    private boolean containsForbiddenWord(String message) {
        return Arrays.stream(forbiddenWords)
                .anyMatch(message::contains);
    }
}
