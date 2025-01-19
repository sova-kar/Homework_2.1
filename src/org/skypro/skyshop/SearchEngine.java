package org.skypro.skyshop;

import java.util.Arrays;
import java.util.Objects;

public class SearchEngine {

    private final Searchable[] searchables;
    private int count;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchEngine that = (SearchEngine) o;
        return count == that.count && Objects.deepEquals(searchables, that.searchables);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(searchables), count);
    }

    public SearchEngine(int capacity) {
        searchables = new Searchable[capacity];
        count = 0;
    }

    public void add(Searchable searchable) {
        if (count < searchables.length) {
            searchables[count] = searchable;
            count++;
        } else {
            System.out.println("Поисковой движок переполнен");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int foundCount = 0;
        for (int i = 0; i < count; i++) {
            if (searchables[i].getSearchTerm().contains(query)) {
                results[foundCount] = searchables[i];
                foundCount++;
                if (foundCount == 5) {
                    break;
                }
            }
        }
        return results;
    }
}
