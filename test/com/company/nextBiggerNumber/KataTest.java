package com.company.nextBiggerNumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class KataTest {


    @Test
    void toList() {
        List<Integer> integers = Kata.toList(10234l);
        int[] ints = {1, 0, 2, 3, 4};
        Assertions.assertEquals(5,integers.size());
        for (int i = 0; i < integers.size(); i++) {
            Assertions.assertEquals(ints[i],integers.get(i));
        }
    }

    @Test
    void toLong() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(0);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        Assertions.assertEquals(10234l,Kata.toLong(integers));
    }

    @Test
    void nextBiggerNumber() {
        long [] inputs = {12,513,2017,414,144,10990,111};
        long [] outputs = {21,531,2071,441,414,19009,-1};
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(inputs[i] + "->");
            System.out.println(Kata.nextBiggerNumber(inputs[i]));
            System.out.println("-----");
            Assertions.assertEquals(outputs[i], Kata.nextBiggerNumber(inputs[i]));
        }
    }

    @Test
    void swap() {
        List list = new ArrayList();
        list.add(32);
        list.add(54);
        list.add(34);
        list.add(100);
        Kata.swap(list,2,3);
        System.out.println(list.toString());
;    }
}