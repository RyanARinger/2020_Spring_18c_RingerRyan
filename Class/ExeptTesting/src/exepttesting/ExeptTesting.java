
package exepttesting;

import java.util.Scanner;

/**
 *
 * @author Ryan Ringer
 */
public class ExeptTesting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int num = 0;
        boolean done = false;
        
        
        System.out.println("Enter a number: ");
        
        while(!done){
            try{
                num = Integer.parseInt(scan.nextLine());
                done = true;
            }catch (NumberFormatException ex){
                System.out.println("Nope try again");
            }
        }
        
    }
    
}
