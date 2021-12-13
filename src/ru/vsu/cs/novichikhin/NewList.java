package ru.vsu.cs.novichikhin;

import java.util.ArrayList;
import java.util.List;

public class NewList {
    List<Integer> list1;
    List<Integer> list2;

    public NewList(List<Integer> list1, List<Integer> list2) {
        this.list1 = list1;
        this.list2 = list2;
    }

    public List<Integer> createNewList() {

        List<Integer> newList = new ArrayList<>();
        for (Integer integer : list1) {
            for (int j = 0; j < countNumberOfRepeatedElements(integer); j++) {
                newList.add(integer);
            }
        }
        if (newList.size() == 0) {
            return null;
        }
        return newList;
    }

    private int countNumberOfRepeatedElements(int value) {
        int number = 0;
        for (Integer integer : list2) {
            if (value == integer) {
                number++;
            }
        }
        return number;
    }
}
