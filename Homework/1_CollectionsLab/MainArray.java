package collectionoperations;

import java.util.Scanner;

public class MainArray {

    public static void main(String[] args) {
        // Seed random number or initialize scanner
        Scanner scan = new Scanner(System.in);

        // Constant Variables
        final int SIZE = 10; // Starting size for the list
        
        // Declare all Variables Here
        HighScore[] scores = new HighScore[SIZE];
        boolean done = false;
        int choice = 0;
        buildArray(scores, SIZE);
        // Input or initialize values Here
        
        // Process/Calculations Here
        while(!done){
            System.out.println("Select an option");
            System.out.println("1. Add a High Score");
            System.out.println("2. Search for a High Score");
            System.out.println("3. Delete a High Score by name");
            System.out.println("4. Print the High Scores");
            System.out.println("0. Exit");
            
            choice = Integer.parseInt(scan.nextLine());
            
            switch(choice){
                case 1:
                    insertElementAt(scores, SIZE);
                    break;
                case 2:
                    findScoreByName(scores, SIZE);
                    break;
                case 3:
                    break;
                case 4:
                    printArray(scores, SIZE);
                    break;
                default:
                    done = true;
            }
        }
        // Output Located Here


        // Exit
    }
    
    public static void buildArray(HighScore[] arr, int sz){
        for (int i = 0; i < sz; i++) {
            arr[i] = new HighScore();
        }
    }
    
    public void removeElementAt(HighScore[] arr, int sz){
        Scanner scan = new Scanner(System.in);
        int e;
        
        System.out.println("Enter the index you wish to delete (start at 0): ");
        e = Integer.parseInt(scan.nextLine());
        for (int i = e; i < sz-1; i++) {
            arr[i].HighScore(arr[i+1]);
        }
        arr[sz-1] = new HighScore();
    }
    
    public static void insertElementAt(HighScore[] arr, int sz){
        Scanner scan = new Scanner(System.in);
        
        HighScore temp1;
        HighScore temp2;
        HighScore h = new HighScore();
        int e;
        
        System.out.println("Enter the Player's Name: ");
        h.setName(scan.nextLine());
        System.out.println("Enter the Player's Score: ");
        h.setScore(Integer.parseInt(scan.nextLine()));
        System.out.println("Enter the Index location (Start at 0): ");
        e = Integer.parseInt(scan.nextLine());
        
        temp1 = new HighScore(arr[e]);
        temp2 = new HighScore();
        boolean able = false;   // boolean flag if last element is empty
                                // if last element is empty, do not expand
        
        
        
        if(arr[e].getName().isEmpty()){ // if empty, don't shift array
            arr[e].HighScore(h);
        }
        else{                                   // if not empty, shift array
            if(arr[sz-1].getName().isEmpty() && e < sz){
                able = true;
            }
            if(able){
                arr[e].HighScore(h);
                for (int i = e+1; i < sz; i++) {
                    temp2.HighScore(arr[i]);
                    arr[i].HighScore(temp1);
                    temp1.HighScore(temp2);
                }
            }
            else{
                System.out.println("NOT ABLE");
            }
        }   
    }
    
    public static int findScoreByName(HighScore[] arr, int sz){
        Scanner scan = new Scanner(System.in);
        String n;
        
        System.out.println("Enter the name you wish to search for: ");
        n = scan.nextLine();
        
        for (int i = 0; i < sz; i++) {
            if(arr[i].getName().equals(n)){
                return arr[i].getScore();
            }
        }
        return 0;
    }
    
    public static void printArray(HighScore[] arr, int sz){
        for (int i = 0; i < sz; i++) {
            arr[i].printScore();
        }
    }
}
