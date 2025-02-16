package org.skypro.skyshop;

import org.skypro.skyshop.product.BestResultNotFound;

import java.util.Arrays;
import java.util.Objects;

public class SearchEngine {

    private final Searchable[] searchables;
    private int count;

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

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isBlank()) {
            throw new IllegalArgumentException("Для поискового запроса '" + search + "' ничего не найдено.");
        }
        Searchable bestMatch = null;
        int maxCount = -1;

        for (Searchable item : searchables) {
            if (item != null) {
                String searchTerm = item.getSearchTerm();
                int count = countRepetitions(searchTerm, search);

                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = item;
                }
            }

            if (bestMatch == null) {
                throw new BestResultNotFound("Для поискового запроса '" + search + "' ничего не  найдено.");
            }
        }
        return bestMatch;
    }

    private int countRepetitions(String str, String substring) {
        int count = 0;
        int index = 0;
        int substringLength = substring.length();

        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substringLength;
        }

        return count;
    }


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
}

