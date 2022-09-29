package com.company.nextBiggerNumber;

public class Main {


    public static void main(String[] args) {

        System.out.println(Kata.toList(1023l));
        System.out.println(Kata.nextBiggerNumber(1023l));
        long [] inputs = {12,513,2017,414,144,10990,111};
        long [] outputs = {21,531,2071,441,414,19009,-1};
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(inputs[i]+"->");
            System.out.println(Kata.nextBiggerNumber(inputs[i]));
            System.out.println("-----");
            assert outputs[i] == Kata.nextBiggerNumber(inputs[i]);
        }
    }

}

