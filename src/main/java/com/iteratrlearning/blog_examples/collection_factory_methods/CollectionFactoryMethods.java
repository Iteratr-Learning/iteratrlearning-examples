package com.iteratrlearning.blog_examples.collection_factory_methods;

import java.util.*;
import static java.util.Map.*;

public class CollectionFactoryMethods
{

    public static void main(String[] args)
    {
		List<String> values = new ArrayList<>();
		values.add("Hello");
		values.add("World");
		values.add("from");
		values.add("Java");

        values = Arrays.asList("Hello", "World", "from", "Java");

        String[] hello = { "Hello" };
        values = Arrays.asList(hello);
        hello[0] = "World";
        System.out.println(values);

        Set<String> oldSet = new HashSet<>(Arrays.asList("Hello", "World", "from", "Java"));

        List<String> list = List.of("Hello", "World", "from", "Java");
        Set<String> set = Set.of("Hello", "World", "from", "Java");

        Map<String, Integer> oldCities = Map.of("Brussels", 1_139000, "Cardiff", 341_000);

        Map<String, Integer> cities = Map.ofEntries(
            entry("Brussels", 1139000), entry("Cardiff", 341000));

    }
}

