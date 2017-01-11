package com.iteratrlearning.blog_examples.java9_cf;

public class PriceFinder {

    private final Currency[] currencyValues;

    public PriceFinder() {
        this.currencyValues = Currency.values();
    }

    public Price findBestPrice(Product product) {
        return calculatePrice(product.getName());
    }

    private Price calculatePrice(String product) {
        Utils.randomDelay();

        double price = 10 * product.charAt(0) + product.charAt(1);

        return new Price(pickRandomCurrencyForProduct(product), Utils.round(price));
    }

    private Currency pickRandomCurrencyForProduct(String product) {
        // hack to avoid using Random
        return currencyValues[product.charAt(2) % currencyValues.length];
    }

}
