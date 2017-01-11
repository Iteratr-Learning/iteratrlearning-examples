package com.iteratrlearning.blog_examples.java9_cf;

import java.util.Objects;

public class Product {

    public enum Category {
        BOOK, ELECTRONICS, HEALTH
    }

    private final Category category;
    private final String name;

    public Product(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return Objects.equals(category, product.category)
            && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "category=" + category +
                ", name='" + name + '\'' +
                '}';
    }

}
