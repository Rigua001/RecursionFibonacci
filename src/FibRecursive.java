/**
 *COPYRIGHT (C) 2016 Rijkard Igualas. All Rights Reserved.
 *Solves COP 3337 homework assignment #6
 *@author Rijkard Igualas
 *@version 1.00 2016-04-19
 * Rijkard Igualas
 * 3321856
 * COP 3337
 * section U02
 * I affirm that this program is entirely my own work and none 
 * of it is the work of any other person.
 *	___________________
 * 	(your signature)
 *
 * Class to calculate Fibonacci numbers recursively.
 */
public class FibRecursive
{
    /**
     * Calculates Fibonacci sequence using recursion
     * @param number the amount of Fibonacci numbers to calculate.
     * @return number from Fibonacci sequence.
     */
    public static long calcFib(int number)
    {
        if(number <= 2)
        {
            return 1;
        }
        else
        {
            return calcFib(number - 1) + calcFib(number - 2);
        }
    }
}
