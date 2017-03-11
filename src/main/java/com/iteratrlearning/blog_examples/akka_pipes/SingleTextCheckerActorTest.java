package com.iteratrlearning.blog_examples.akka_pipes;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.JavaTestKit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static akka.testkit.JavaTestKit.duration;

public class SingleTextCheckerActorTest {
    private ActorSystem system;

    @Test
    public void testMessageDoesNotContainForbiddenWord() {
        JavaTestKit testProbe = new JavaTestKit(system);
        Props props = Props.create(SingleTextCheckerActor.class);
        ActorRef subject = system.actorOf(props);
        String msg = "I am waiting for you.";
        subject.tell(msg, testProbe.getRef());
        testProbe.expectMsgEquals(duration("1 second"), msg);
    }

    @Test
    public void testMessageContainsForbiddenWord() {
        JavaTestKit testProbe = new JavaTestKit(system);
        Props props = Props.create(SingleTextCheckerActor.class);
        ActorRef subject = system.actorOf(props);
        subject.tell("I'm feeling good!", testProbe.getRef());
        testProbe.expectNoMsg(duration("1 second"));
    }

    @Before
    public void setup() {
        system = ActorSystem.create();
    }

    @After
    public void teardown() {
        JavaTestKit.shutdownActorSystem(system);
    }
}