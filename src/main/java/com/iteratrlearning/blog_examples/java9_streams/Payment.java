package com.iteratrlearning.blog_examples.java9_streams;

public class Payment
{
    private final int value;

    public Payment(final int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return "Transaction{" +
            "value=" + value +
            '}';
    }
}
