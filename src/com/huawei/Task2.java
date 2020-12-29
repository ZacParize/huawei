package com.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

public class Task2 {

    /***
     * Time complexity O(n)*O(26*log26) -> O(n)
     * Extra memory using O(26)
     * @param listOfCharacters list of characters
     * @return unique list of characters
     */
    public static List<Character> findUniqueLetters(List<Character> listOfCharacters) {
        return Optional.ofNullable(listOfCharacters)
                // TreeSet here for lexicographical order
                .map(list -> (List<Character>) new ArrayList<>(new TreeSet<>(list)))
                .orElse(Collections.emptyList());
    }

    public static void main(String[] args) {
        test_nulls();
        test_emptyList();
        test_shortList();
        test_fullList();
    }

    public static void test_nulls() {
        assert findUniqueLetters(null).size() == 0;
    }

    public static void test_emptyList() {
        assert findUniqueLetters(Collections.emptyList()).size() == 0;
    }

    public static void test_shortList() {
        final var idealList = new LinkedList<>(Arrays.asList('a','s'));
        final var checkedList = findUniqueLetters(List.of('s', 'a'));
        assert checkedList.equals(idealList);
    }

    public static void test_fullList() {
        final var idealList = new LinkedList<>(Arrays.asList('a','b', 'c', 'd', 'e', 'f'));
        final var checkedList = findUniqueLetters(List.of('b', 'a', 'c', 'd', 'e', 'f', 'd', 'a', 'c', 'b'));
        assert checkedList.equals(idealList);
    }
}