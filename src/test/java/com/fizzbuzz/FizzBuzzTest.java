package com.fizzbuzz;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Unit test suite for FizzBuzz.
 */
public class FizzBuzzTest
{
    private class Counts
    {
      public int luckyCount;
      public int fizzbuzzCount;
      public int fizzCount;
      public int buzzCount;
      public int numberCount;
    }

    /**
     * Base test function to execute FizzBuzz and store std out into buffer
     * @param min start of range of contiguous numbers
     * @param max end of range of contiguous numbers
     * @return string containing std out from FizzBuzz execution
     */
    public String [] getRunFizzBuzzResponseFromStdOut(int min, int max)
    {
        ByteArrayOutputStream stdOutBuffer = new ByteArrayOutputStream();
        PrintStream stdOut = System.out;
        FizzBuzz fb = new FizzBuzz();

        System.setOut(new PrintStream(stdOutBuffer));   // Point to buffer
        fb.runFizzBuzz(min, max);
        String data = stdOutBuffer.toString().replaceAll("\r", "");
        String [] dataArr = data.split("\n");
        for(int i = 0; i < dataArr.length; i++)
        {
          dataArr[i] = dataArr[i].strip();
        }
        System.setOut(stdOut);                          // Point to std out
        return (dataArr);
    }

    /**
     * Helper function to get expected string counts
     * @param min start of range of contiguous numbers
     * @param max end of range of contiguous numbers
     * @return object containing each string count
     */
    public Counts getExpectedStringCounts(int min, int max)
    {
        Counts counts = new Counts();
        for(int n = min; n < max+1; n++)
        {
            String numStr = Integer.toString(n);
            if (numStr.contains("3"))
            {
                counts.luckyCount++;
            }
            else if (n % 15 == 0)
            {
                counts.fizzbuzzCount++;
            }
            else if (n % 3 == 0)
            {
                counts.fizzCount++;
            }
            else if (n % 5 == 0)
            {
                counts.buzzCount++;
            }
            else
            {
                counts.numberCount++;
            }
        }
        return counts;
    }

    @Test
    public void test0_OutputFrom0To0()
    {
        System.out.println("TEST #0: Verify Output From 0 to 0");
        int minNum = 0;
        int maxNum = 0;
        String [] response = getRunFizzBuzzResponseFromStdOut(minNum, maxNum);
        String [] expected = {"fizzbuzz", "fizz: 0", "buzz: 0", "fizzbuzz: 1", "lucky: 0", "integer: 0"};
        assertArrayEquals(response, expected);
    }

    @Test
    public void test1_OutputFrom21To21()
    {
        System.out.println("TEST #1: Verify Output From 53 to 53");
        int minNum = 53;
        int maxNum = 53;
        String [] response = getRunFizzBuzzResponseFromStdOut(minNum, maxNum);
        String [] expected = {"lucky", "fizz: 0", "buzz: 0", "fizzbuzz: 0", "lucky: 1", "integer: 0"};
        assertArrayEquals(response, expected);
    }

    @Test
    public void test2_OutputFrom22To22()
    {
        System.out.println("TEST #2: Verify Output From 33 to 33");
        int minNum = 33;
        int maxNum = 33;
        String [] response = getRunFizzBuzzResponseFromStdOut(minNum, maxNum);
        String [] expected = {"lucky", "fizz: 0", "buzz: 0", "fizzbuzz: 0", "lucky: 1", "integer: 0"};
        assertArrayEquals(response, expected);
    }

    @Test
    public void test3_OutputFrom0To20()
    {
        System.out.println("TEST #3: Verify Output From 0 to 20");
        int minNum = 0;
        int maxNum = 20;
        String [] response = getRunFizzBuzzResponseFromStdOut(minNum, maxNum);
        String [] expected = {"fizzbuzz 1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz",
                              "fizz: 4", "buzz: 3", "fizzbuzz: 2", "lucky: 2", "integer: 10"};
        assertArrayEquals(response, expected);
    }

    @Test
    public void test4_OutputFrom45To60()
    {
        System.out.println("TEST #4: Verify Output From 29 to 49");
        int minNum = 29;
        int maxNum = 49;
        String [] response = getRunFizzBuzzResponseFromStdOut(minNum, maxNum);
        String [] expected = {"29 lucky lucky lucky lucky lucky lucky lucky lucky lucky lucky buzz 41 fizz lucky 44 fizzbuzz 46 47 fizz 49",
                              "fizz: 2", "buzz: 1", "fizzbuzz: 1", "lucky: 11", "integer: 6"};
        assertArrayEquals(response, expected);
    }

    @Test
    public void test5_AllStringCountsInOutputFrom0To30()
    {
        System.out.println("TEST #5: Verify All String Counts in Output From 0 to 30");
        int minNum = 0;
        int maxNum = 30; // A large multiple of both 3 and 5 and therefore 15
        Counts expectedCounts = getExpectedStringCounts(minNum, maxNum);
        String [] response = getRunFizzBuzzResponseFromStdOut(minNum, maxNum);
        assertEquals("fizz: " + expectedCounts.fizzCount, response[1]);
        assertEquals("buzz: " + expectedCounts.buzzCount, response[2]);
        assertEquals("fizzbuzz: " + expectedCounts.fizzbuzzCount, response[3]);
        assertEquals("lucky: " + expectedCounts.luckyCount, response[4]);
        assertEquals("integer: " + expectedCounts.numberCount, response[5]);
    }

    @Test
    public void test6_AllStringCountsInOutputFrom0To999990()
    {
        System.out.println("TEST #6: Verify All String Counts in Output From 0 to 999990");
        int minNum = 0;
        int maxNum = 999990; // A large multiple of both 3 and 5 and therefore 15
        Counts expectedCounts = getExpectedStringCounts(minNum, maxNum);
        String [] response = getRunFizzBuzzResponseFromStdOut(minNum, maxNum);
        assertEquals("fizz: " + expectedCounts.fizzCount, response[1]);
        assertEquals("buzz: " + expectedCounts.buzzCount, response[2]);
        assertEquals("fizzbuzz: " + expectedCounts.fizzbuzzCount, response[3]);
        assertEquals("lucky: " + expectedCounts.luckyCount, response[4]);
        assertEquals("integer: " + expectedCounts.numberCount, response[5]);
    }

    @Test
    public void test7_StartAndEndOutputFrom0To999990()
    {
        System.out.println("TEST #7: Get Expected Start and End Output From 0 to 999990");
        int minNum = 0;
        int maxNum = 999990; // A large multiple of both 3 and 5 and therefore 15
        String [] response = getRunFizzBuzzResponseFromStdOut(minNum, maxNum);
        String [] respArr = response[0].split(" ");
        int arrLen = respArr.length;
        String startOfStringReceived = respArr[0];
        String endOfStringReceived = respArr[arrLen-1];
        String startOfStringExpected = "fizzbuzz";
        String endOfStringExpected = "fizzbuzz";
        assertEquals(startOfStringReceived, startOfStringExpected);
        assertEquals(endOfStringReceived, endOfStringExpected);
    }
}
