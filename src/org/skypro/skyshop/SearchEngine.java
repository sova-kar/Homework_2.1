package org.skypro.skyshop;

import org.skypro.skyshop.product.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    private final Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

 HW_7
    public Set<Searchable> search(String query) {
        Set<Searchable> results = new TreeSet<>(new SearchableComparator());

    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>(); // TreeMap для сортировки по ключу
 master
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(query)) {
                results.put(searchable.getName(), searchable);
            }
        }
        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (searchables.isEmpty()) {
            throw new BestResultNotFound("Для поискового запроса '" + search + "' не найдено подходящих результатов.");
        }

        Searchable bestMatch = null;
        int maxCount = -1;

        for (Searchable searchable : searchables) {
            String searchTerm = searchable.getSearchTerm();
            int count = countOccurrences(searchTerm, search);

            if (count > maxCount) {
                maxCount = count;
                bestMatch = searchable;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Для поискового запроса '" + search + "' не найдено подходящих результатов.");
        }

        return bestMatch;
    }

    private int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;
        int substringLength = substring.length();

        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substringLength;
        }

        return count;
    }
    private static class SearchableComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            int lengthCompare = Integer.compare(s2.getName().length(), s1.getName().length());
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            return s1.getName().compareTo(s2.getName());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchEngine that = (SearchEngine) o;
        return Objects.equals(searchables, that.searchables);
    }

    @Override
    public int hashCode() {
        return Objects.hash(searchables);
    }
}