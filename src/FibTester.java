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
 */
import java.io.File; //Allows use of files
import java.io.FileNotFoundException; // Exception if file is not available
import java.io.PrintWriter; //Writes to Files
import java.util.Scanner; //Allows input

/**
  *Class to test FibLoop and FibRecursive.
 */
public class FibTester 
{
    public static void main (String [] args)
            throws FileNotFoundException, NumberFormatException
    {   
        
        PrintWriter output = new PrintWriter("output.txt");
        try
        {
            File inputFile = new File("input.txt");
            Scanner input = new Scanner(inputFile);              
            if(!input.hasNextInt())
            {
                throw new NumberFormatException();
            }
            displayFibs(input, output);            
            input.close();
        }
        catch (NumberFormatException numFormat)
        {
            System.out.println("Integer not found!");
        }
        catch (FileNotFoundException fileNF)
        {
            System.out.println("File could not be found!");
        }
        finally
        {
            output.close(); 
        }
    }

    /**
     * Displays the calculated Fibonacci sequences
     * @param input the input text file
     * @param output the output text file
     */
    public static void displayFibs(Scanner input, PrintWriter output)
    {
        //Number to convert to milliseconds
        double convToMS = 100000000.0; 
        int iteration = input.nextInt();
        double num = Math.sqrt(iteration);        
        int columns = (int)Math.ceil(num);        
        output.println("|| FibRecursive || ");
        //Obtains start time for recursive algorithm
        long startTimeRecur = System.nanoTime();
        //Calculates Fibonacci recursivley 
        for (int counter = 1; counter <= iteration; counter++)
        {      
            long fib = FibRecursive.calcFib(counter);
            output.printf("%10s", fib);
            if ( counter % columns == 0)
            {
                output.println();
            }     
        }
        //Obtains total time for recursive algorithm
        long totalTimeRecur = System.nanoTime() - startTimeRecur;
        //Converts recursive time to milliseconds
        double recurMS = (double)totalTimeRecur / convToMS;
        //Displays recusrive time
        output.println("\nRuntime: "+ recurMS + " milliseconds");
        output.println("\n|| FibLoop || ");
        //Obtains start time for Fibloop algorithm
        long startTimeLoop = System.nanoTime();  
        //Calculate Fibonacci using Fibloop  
        for (int counter = 1; counter <= iteration; counter++)
        {      
            long fib = FibLoop.calcFib(counter);
            output.printf("%10s", fib );
            if ( counter % columns == 0)
            {
            output.println();
            }     
        }
        //Obtains total time for Fibloop algorithm
        long totalTimeLoop = System.nanoTime() - startTimeLoop;
        //Converts Fibloop time to milliseconds
        double loopMS = (double)totalTimeLoop / convToMS;
        //Displays Fibloop time
        output.println("\nRuntime: "+ loopMS + " milliseconds");
    }
}
