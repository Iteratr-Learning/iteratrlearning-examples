package com.iteratrlearning.blog_examples.java9_collectors;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class Filtering {

    public static void main(String[] args) {

        List<Expense> purchases
                = List.of(
                        new Expense(500, 2016, List.of(Tag.FOOD, Tag.ENTERTAINMENT)),
                        new Expense(1_500, 2016, List.of(Tag.UTILITY)),
                        new Expense(700, 2015, List.of(Tag.TRAVEL, Tag.ENTERTAINMENT)));

        Map<Integer, List<Expense>> yearToExpenses
                = purchases.stream()
                .filter(expense -> expense.getAmount() > 1_000)
                .collect(groupingBy(Expense::getYear));

        System.out.println(yearToExpenses);

    }
}
