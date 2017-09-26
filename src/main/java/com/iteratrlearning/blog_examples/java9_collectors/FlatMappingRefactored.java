package com.iteratrlearning.blog_examples.java9_collectors;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class FlatMappingRefactored
{

    public static void main(String[] args) {
        // Problem: Set<List<Tag>>

        List<Expense> purchases
                = List.of(
                        new Expense(500, 2016, List.of(Tag.FOOD, Tag.ENTERTAINMENT)),
                        new Expense(1_500, 2016, List.of(Tag.UTILITY)),
                        new Expense(700, 2015, List.of(Tag.TRAVEL, Tag.ENTERTAINMENT)));

        Map<Integer, Set<Tag>> tagsByYear = purchases.stream()
            .collect(groupingBy(Expense::getYear,
                flatMapping(exp -> exp.getTags().stream(), toSet())));

        System.out.println(tagsByYear);

    }
}
