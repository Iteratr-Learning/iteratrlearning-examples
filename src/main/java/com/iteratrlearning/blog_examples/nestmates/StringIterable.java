package com.iteratrlearning.blog_examples.nestmates;

import java.util.Iterator;

public class StringIterable implements Iterable<Character> {

    private final String string;

    public StringIterable(String string) {
        this.string = string;
    }

    @Override
    public Iterator<Character> iterator() {
        return new StringIterator();
    }

    private class StringIterator implements Iterator<Character> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < string.length();
        }

        @Override
        public Character next() {
            final char c = string.charAt(index);
            index++;
            return c;
        }
    }
}
