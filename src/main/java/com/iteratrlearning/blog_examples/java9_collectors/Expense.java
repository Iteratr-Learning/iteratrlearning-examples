package com.iteratrlearning.blog_examples.java9_collectors;

import java.util.List;

public class Expense {
    private final long amount;
    private final int year;
    private final List<Tag> tags;

    public Expense(long amount, int year, List<Tag> tags) {
        this.amount = amount;
        this.year = year;
        this.tags = tags;
    }

    public long getAmount() {
        return amount;
    }

    public int getYear() {
        return year;
    }

    public List<Tag> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "amount=" + amount +
                ", year=" + year +
                ", tags=" + tags +
                '}';
    }
}
