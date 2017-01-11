package com.iteratrlearning.blog_examples.java9_cf;

public enum Currency {
    USD(1.0), EUR(1.35), GBP(1.68), CAD(.92), SEK(.15), CHF(1.44);

    public final double rate;

    Currency(double rate) {
        this.rate = rate;
    }
}
