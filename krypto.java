package apcs;

import java.util.*;

public class Krypto2
{
   public static void main(String[] args)
   {
      //Scan the input and split them into arrays
      System.out.println("Input: ");
      Scanner sc = new Scanner (System.in);
      String input = sc.nextLine();
      input = input.replace(" ", "");
      String [] arr = input.split(",");
     
      //initialize every variable to zero
      int a, b, c, d, e, ans = 0;
     
      a = Integer.parseInt(arr[0]); //first element in the array is "a"
      b = Integer.parseInt(arr[1]);
      c = Integer.parseInt(arr[2]);
      d = Integer.parseInt(arr[3]);
      e = Integer.parseInt(arr[4]);
      ans = Integer.parseInt(arr[5]); //last element in the array is the answer to the equation
     
      //ArrayList for storing the operations
      //Later, I will utilize random numbers to choose random operations
      ArrayList <String> op = new ArrayList <String>();
      op.add("+");
      op.add("-");
      op.add("*");
      op.add("/");
     
      int count = 0;
      while (true)
      {
         int c1 = (int)(Math.random()*4);
         int c2 = (int)(Math.random()*4);
         int c3 = (int)(Math.random()*4);
         int c4 = (int)(Math.random()*4);
         
         //When all the operation is different, enter the if statement
         if ((c1 != c2) && (c1 != c3) && (c1 != c4) && (c2 != c3) && (c2 != c4) && (c3 != c4))
         {  
            count++; //just for counting the number of trials; not crucial to the function of the code
            System.out.println("Trial #"+count); //just for counting the number of trials; not crucial to the function of the code
           
            //Have to calculate 4 times because there are 5 numbers
            int step1 = calc(a, b, op.get(c1));
            int step2 = calc(step1, c, op.get(c2));
            int step3 = calc(step2, d, op.get(c3));
            int step4 = calc(step3, e, op.get(c4));
           
            if (step4 == ans)
            {
               count++;
               System.out.println("WORKED on trial #"+count);
               System.out.println("ANSWER: "+a+" "+op.get(c1)+" "+b+" "+op.get(c2)+" "+c+" "+op.get(c3)+" "+d+" "+op.get(c4)+" "+e+" = "+ans);
               break;
            }
         }
      }
   }
   
   //A method for calculating the randomized operation
   public static int calc (int x, int y, String op)
   {
      if (op.equals("+"))
      {
         return x+y;
      }
      else if (op.equals("-"))
      {
         return x-y;
      }
      else if (op.equals("*"))
      {
         return x*y;
      }
      else if (op.equals("/"))
      {
         return x/y;
      }
      else
      {
         return 0;
      }
   }
}
