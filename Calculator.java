public class Calculator
{

 public static void main(String[] args)
 {
  System.out.println("Welcome to the Calculator program!");

  if (args.length < 3)
  {
   System.out.println("You need to enter three arguments to this program. Try typing 'run Calculator 5 5 1' in Dr. Java, or 'java Calculator 5 5 1 on the command line.");
   return;
  }

  int a = getIntegerNumber(args[0]);
  int b = getIntegerNumber(args[1]);
  float c = getFloatNumber(args[2]);

  System.out.println("The first argument is: " + a);
  System.out.println("The second argument is: " + b);
  System.out.println("The third argument is: " + c);

    //========================
    //Enter your code below

    //Student Name: Raymond Diamonds
    //Student Number: 260656751

  //find sum of a and b
  System.out.println("Sum of a and b: " + (a+b));
  //find product of a and b
  System.out.println("Product of a and b: " + a*b);
  //find quotient of a divide by b
  System.out.println("Dividing a by b: " + a/b);
  //find quotient of a divide by c
  System.out.println("Dividing a by c: " +  a/c);
  //find whether a is larger than b
  System.out.println("Is a larger than b: " + (a>b));
  //find if a is odd
  System.out.println("Is a odd: " + (a % 2 != 0)); 

    //Enter your code above
    //========================
 }

 public static int getIntegerNumber(String arg)
 {
  try
  {
   return Integer.parseInt(arg);
  }catch(NumberFormatException e)
  {
   System.out.println("ERROR: " + e.getMessage() + " This argument must be an integer!");
  }
             //error, return 1
  return 1;
 }

 public static float getFloatNumber(String arg)
 {
  try
  {
   return Float.parseFloat(arg);
  }catch(NumberFormatException e)
  {
   System.out.println("ERROR: " + e.getMessage() + " This argument must be a float!");
  }
             //error, return 1.0
  return 1.0f;
 }
}
