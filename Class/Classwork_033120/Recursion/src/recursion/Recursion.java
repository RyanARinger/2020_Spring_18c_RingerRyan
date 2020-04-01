/* 
 * Author: Ryan Ringer
 * Created on: 
 * File:
 * Purpose:
 */

package recursion;

public class Recursion {

    public static void main(String[] args) {
        // Seed random number or initialize scanner


        // Constant Variables
        final int MAX = 100;
        final int PLACE = 6;
        // Declare all Variables Here
        int sum = 0;
        int recSum1 = 0;
        int recSum2 = 0;
        int fibNum = 0;
        // Input or initialize values Here
        

        // Process/Calculations Here
        for (int i = 0; i <= MAX; i++) {
            sum += i;
        }
        
        recSum1 = recursiveSum(recSum1, 0, MAX);
        
        recSum2 = recursiveSum2(recSum2, MAX);
        
//        fib(0,1,0,20);
        // Output Located Here
        System.out.println(sum);
        System.out.println(recSum1);
        System.out.println(recSum2);
        // Exit
    }
    
    public static int recursiveSum(int sum,int counter, int max){
        
        if(counter == max){
            sum += counter;
            return sum;
        }
        else{
            sum += counter;
            return recursiveSum(sum, ++counter, max);
        }
    }
    
    public static int recursiveSum2(int counter, int max){
        
        if(counter != max){
            counter += recursiveSum2(++counter, max);
        }
        return counter;
        
    }
    
    public static void fib(int a, int b, int counter, int place){
        if(counter == 0){
            System.out.println(a);
        }
        if(counter < place){
            System.out.println(a+b);
            fib(b, a+b, ++counter, place);
        }
    }
    
}
