package Pi;

//Java program to calculate the
//value of pi up to n decimal places
class Palindromo4 {
  
 // Function that prints the
 // value of pi upto N
 // decimal places
 static void printValueOfPi(int N)
 {
  
     // Find value of pi upto
     // using acos() function
     double pi = 2 * Math.acos(0.0);
  
     // Print value of pi upto
     // N decimal places
     System.out.println(pi);
 }
  
 // Driver Code
 public static void main (String[] args)
 {
     int N = 4;
  
     // Function that prints
     // the value of pi
     printValueOfPi(N);
 }
}