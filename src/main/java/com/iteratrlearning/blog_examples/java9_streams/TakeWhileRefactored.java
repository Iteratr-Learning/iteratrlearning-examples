package com.iteratrlearning.blog_examples.java9_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TakeWhileRefactored
{
    public static void main(String[] args)
    {
        // 1. show it doesn't terminate
        // 2. refactor to use takeWhile

        List<Payment> paymentsByValue = new ArrayList<>();

        paymentsByValue.add(new Payment(9));
        paymentsByValue.add(new Payment(7));
        paymentsByValue.add(new Payment(5));
        paymentsByValue.add(new Payment(3));
        paymentsByValue.add(new Payment(1));
        paymentsByValue.add(new Payment(0));

        final List<Payment> expensivePayments = paymentsByValue
            .stream()
            .takeWhile(transaction -> transaction.getValue() >= 5)
            .collect(Collectors.toList());

        System.out.println(expensivePayments);


    }
}
