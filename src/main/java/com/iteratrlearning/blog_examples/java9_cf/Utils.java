package com.iteratrlearning.blog_examples.java9_cf;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    private static final int MIN_DELAY_IN_MS = 750;
    private static final int MAX_DELAY_IN_MS = 1000;

    static public void randomDelay() {
        int delayInMS = ThreadLocalRandom.current().nextInt(MIN_DELAY_IN_MS, MAX_DELAY_IN_MS);
        try {
            Thread.sleep(delayInMS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static double round(double value) {
        return round(value, 2);
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
