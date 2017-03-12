package com.iteratrlearning.blog_examples.akka_pipes;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class LatexToUnicodeActor extends UntypedActor {

    private ActorRef nextActor;
    private LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    public LatexToUnicodeActor(ActorRef nextActor) {
        this.nextActor = nextActor;
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        log.info("Received Message: " + message);

        String msg = (String) message;
        String result =  msg.replaceAll("\\\\alpha", "α")
                .replaceAll("\\\\beta", "β");

        nextActor.tell(result, getSelf());
    }
}