package com.iteratrlearning.blog_examples.java9_collectors;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class FilteringRefactored
{

    public static void main(String[] args) {

        // 1. show that 2015 is missing from the results map
        // 2. refactor to use filtering collector

        List<Expense> purchases
                = List.of(
                        new Expense(500, 2016, List.of(Tag.FOOD, Tag.ENTERTAINMENT)),
                        new Expense(1_500, 2016, List.of(Tag.UTILITY)),
                        new Expense(700, 2015, List.of(Tag.TRAVEL, Tag.ENTERTAINMENT)));

        Map<Integer, List<Expense>> yearToExpenses
                = purchases.stream()
                .collect(
                    groupingBy(Expense::getYear,
                        filtering(expense -> expense.getAmount() > 1_000, toList())));

        System.out.println(yearToExpenses);

    }
}
