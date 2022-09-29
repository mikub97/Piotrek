package com.company.fibonacci;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class FibTest {
    private static final String CSV_FILE_NAME = "FIB_TIMES.csv";

    @Test
    public void testFib() {
        for (int i = 0; i < 40; i++) {
            System.out.println(Fib.fib(i));
            System.out.println(Fib.fib_iter(i));
            assertEquals(Fib.fib(i), Fib.fib_iter(i));
        }
    }

    public static void writeCSV(List<String> tests, String filename){
        File csvOutputFile = new File(filename);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            tests.stream()
                    .forEach(pw::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertTrue(csvOutputFile.exists());
    }

    @Test
    public void testTimesFib(){
        ArrayList<String> tests = new ArrayList<>();
        tests.add("i,timeElapsedR,timeElapsedI");

        for (int i = 0; i < 70; i+=2) {
            long startR = System.currentTimeMillis();
            int resR = Fib.fib(i);
            long finishR = System.currentTimeMillis();
            long timeElapsedR = finishR - startR;

            long startI = System.currentTimeMillis();
            int resI = Fib.fib_iter(i);
            long finishI = System.currentTimeMillis();
            long timeElapsedI = finishI - startI;
            tests.add(i+","+timeElapsedR+","+timeElapsedI);
        }
        writeCSV(tests, CSV_FILE_NAME);

    }
    @Test
    public void testRabbit() {
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            int n = r.nextInt(5,20);
            int b = r.nextInt(1,10);
            assertEquals(Fib.fibRabbitsM(n,b),Fib.fibRabbitsP(n,b));
        }
    }

}