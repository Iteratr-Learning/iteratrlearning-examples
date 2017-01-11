package com.iteratrlearning.blog_examples.java9_cf;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class Catalogue
{
    private static final Product harrypotter = new Product(Product.Category.BOOK, "Harry Potter");
    private static final Product davincicode = new Product(Product.Category.BOOK, "Da Vinci Code");
    private static final Product iphone5 = new Product(Product.Category.ELECTRONICS, "Iphone5");
    private static final Product nexus7 = new Product(Product.Category.ELECTRONICS, "Nexus7");
    private static final Product toothbrush = new Product(Product.Category.HEALTH, "Tooth brush");
    private static final Product perfume = new Product(Product.Category.HEALTH, "Perfume");

    public static final List<Product> products = Arrays.asList(
            harrypotter, davincicode, iphone5,
            nexus7, perfume, toothbrush
    );

    private final Map<String, Product> productsByName = products
            .stream().collect(toMap(Product::getName, p -> p));

    public Product productByName(final String name)
    {
        return productsByName.get(name);
    }

}
