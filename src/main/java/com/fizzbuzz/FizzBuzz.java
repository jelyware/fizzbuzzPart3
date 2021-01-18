package com.fizzbuzz;

/**
 * FizzBuzz (Step 3) API
 * Purpose: Use to execute Step 3 FizzBuzz to produce report to std out containing
 *          entire data string and each string type count within it.
 * Example output:
 *             fizzbuzz 1 2 lucky 4
 *             fizz: 0
 *             buzz: 0
 *             fizzbuzz: 1
 *             lucky: 1
 *             integer: 3
 * Author: Jessica lynch
 */
public class FizzBuzz
{
    private class Counts
    {
      public int luckyCount;
      public int fizzbuzzCount;
      public int fizzCount;
      public int buzzCount;
      public int integerCount;
    }

    /**
     * Runs FizzBuzz (Part 3)
     * @param min start of range of contiguous numbers
     * @param max end of range of contiguous numbers
     */
    public void runFizzBuzz(int min, int max)
    {
        StringBuilder sb = new StringBuilder();
        Counts counts = new Counts();
        for(int n = min; n < max+1; n++)
        {
            String numStr = Integer.toString(n);
            if (numStr.contains("3"))
            {
                sb.append("lucky ");
                counts.luckyCount++;
            }
            else if (n % 15 == 0)
            {
                sb.append("fizzbuzz ");
                counts.fizzbuzzCount++;
            }
            else if (n % 3 == 0)
            {
                sb.append("fizz ");
                counts.fizzCount++;
            }
            else if (n % 5 == 0)
            {
                sb.append("buzz ");
                counts.buzzCount++;
            }
            else
            {
                sb.append(Integer.toString(n));
                sb.append(" ");
                counts.integerCount++;
            }
        }
        String dataString = sb.toString().strip();
        System.out.println(dataString);
        System.out.println("fizz: " + counts.fizzCount);
        System.out.println("buzz: " + counts.buzzCount);
        System.out.println("fizzbuzz: " + counts.fizzbuzzCount);
        System.out.println("lucky: " + counts.luckyCount);
        System.out.println("integer: " + counts.integerCount);
    }
}
