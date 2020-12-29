package com.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Task1 {

    /***
     * Time complexity O(n)
     * Extra memory using O(n/2 + 1)
     * @param listOfValues list of integer values
     * @return list of unique values
     */
    public static List<Integer> findUniqueValues(List<Integer> listOfValues) {
        return Optional.ofNullable(listOfValues)
                       .map(list -> {
                           final var uniqueValues = new HashSet<Integer>(listOfValues.size()/2 + 1);
                           list.forEach(value -> {
                               if (uniqueValues.contains(value)) {
                                   uniqueValues.remove(value);
                               } else {
                                   uniqueValues.add(value);
                               }
                           });
                           return (List<Integer>) new ArrayList<>(uniqueValues);
                       }).orElse(Collections.emptyList());
    }

    public static void main(String[] args) {
        test_nulls();
        test_emptyList();
        test_shortList();
        test_fullList();
    }

    public static void test_nulls() {
        assert findUniqueValues(null).size() == 0;
    }

    public static void test_emptyList() {
        assert findUniqueValues(Collections.emptyList()).size() == 0;
    }

    public static void test_shortList() {
        final var idealList = new LinkedList<>(Arrays.asList(50, 100));
        final var checkedList = findUniqueValues(List.of(100, 50));
        Collections.sort(checkedList);
        assert checkedList.equals(idealList);
    }

    public static void test_fullList() {
        final var idealList = new LinkedList<>(Arrays.asList(20, 100));
        final var checkedList = findUniqueValues(List.of(200, 50, 300, 30, 800, 100, 20, 200, 50, 300, 30, 800));
        Collections.sort(checkedList);
        assert checkedList.equals(idealList);
    }
}
