package com.iteratrlearning.blog_examples.akka_pipes;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.JavaTestKit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static akka.testkit.JavaTestKit.duration;

public class PipesAndFilterTest {

    private ActorSystem system;

    @Test
    public void testTextCheckerAndLatextoUnicodePipeline() {
        JavaTestKit endProbe = new JavaTestKit(system);
        // LatexToUnicode filter
        Props latexToUnicodeProps = Props.create(LatexToUnicodeActor.class, endProbe.getRef());
        ActorRef latexToUnicodeActor = system.actorOf(latexToUnicodeProps, "latex-to-unicode-actor");
        // TextChecker filter
        Props textCheckerProps = Props.create(TextCheckerActor.class, latexToUnicodeActor);
        ActorRef textCheckerActor = system.actorOf(textCheckerProps, "text-checker-actor");
        // test
        textCheckerActor.tell("I think the answer is \\alpha + \\beta", textCheckerActor);
        endProbe.expectMsgEquals(duration("1 second"), "I think the answer is α + β");
    }

    @Test
    public void testTextCheckerAndNoLatextoUnicodePipeline() {
        JavaTestKit endProbe = new JavaTestKit(system);
        // LatexToUnicode filter
        Props latexToUnicodeProps = Props.create(LatexToUnicodeActor.class, endProbe.getRef());
        ActorRef latexToUnicodeActor = system.actorOf(latexToUnicodeProps, "latex-to-unicode-actor");
        // TextChecker filter
        Props textCheckerProps = Props.create(TextCheckerActor.class, latexToUnicodeActor);
        ActorRef textCheckerActor = system.actorOf(textCheckerProps, "text-checker-actor");
        // test
        textCheckerActor.tell("I'm wondering whether the answer is \\alpha + \\beta", textCheckerActor);
        endProbe.expectNoMsg(duration("1 second"));
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
