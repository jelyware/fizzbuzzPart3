package com.fizzbuzz;

/**
 * FizzBuzz (Step 3)
 * Author: Jessica lynch
 */
public class FizzBuzz
{
    /**
     * Runs FizzBuzz (Part 2)
     * @param min start of range of contiguous numbers
     * @param max end of range of contiguous numbers
     */
    public void runFizzBuzz2(int min, int max)
    {
        StringBuilder sb = new StringBuilder();
        for(int n = min; n < max+1; n++)
        {
            String numStr = Integer.toString(n);
            if (numStr.contains("3"))
            {
                sb.append("lucky ");
            }
            else if (n % 15 == 0)
            {
                sb.append("fizzbuzz ");
            }
            else if (n % 3 == 0)
            {
                sb.append("fizz ");
            }
            else if (n % 5 == 0)
            {
                sb.append("buzz ");
            }
            else
            {
                sb.append(Integer.toString(n));
                sb.append(" ");
            }
        }
        String response = sb.toString().strip();
        System.out.println(response);
    }

    /**
     * Runs FizzBuzz (Part 1)
     * @param min start of range of contiguous numbers
     * @param max end of range of contiguous numbers
     */
    public void runFizzBuzz1(int min, int max)
    {
        StringBuilder sb = new StringBuilder();
        for (int i= min; i < max+1; i++)
        {
            if( i % 15 == 0 )
            {
                sb.append("fizzbuzz ");
            }
            else
            {
                if(i % 3 == 0)
                {
                    sb.append("fizz ");
                }
                else if(i % 5 == 0)
                {
                    sb.append("buzz ");
                }
                else
                {
                    sb.append(Integer.toString(i));
                    sb.append(" ");
                }
            }
        }
        String response = sb.toString().strip();
        System.out.println(response);
    }

    public static void main( String[] args )
    {
        FizzBuzz fb = new FizzBuzz();
        fb.runFizzBuzz1(0,30);
        fb.runFizzBuzz2(0,30);
    }
}
