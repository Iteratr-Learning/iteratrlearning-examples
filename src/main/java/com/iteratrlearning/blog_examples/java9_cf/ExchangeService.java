package com.iteratrlearning.blog_examples.java9_cf;

public class ExchangeService {

    public double exchangeCurrency(Currency source, Currency destination, double value) {
        double rate = lookupExchangeRate(source, destination);
        return exchange(value, rate);
    }

    public double exchange(double value, double rate)
    {
        return Utils.round(value * rate);
    }

    public double lookupExchangeRate(Currency source, Currency destination) {
        return getRateWithDelay(source, destination);
    }

    private double getRateWithDelay(Currency source, Currency destination) {
        Utils.randomDelay();
        return source.rate / destination.rate;
    }

}
