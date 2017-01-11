package com.iteratrlearning.blog_examples.java9_cf;

public class Price {

    private final Currency currency;
    private final double price;

    public Price(Currency currency, double price) {
        this.currency = currency;
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getAmount() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price1 = (Price) o;

        if (Double.compare(price1.price, price) != 0) return false;
        if (currency != price1.currency) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = currency.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Price{" +
                "currency=" + currency +
                ", price=" + price +
                '}';
    }

}
