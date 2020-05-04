package collectionoperations;

import java.util.Scanner;

public class MainLinkedList {
    public static void main(String[] args) {
        // Seed random number or initialize scanner
        Scanner scan = new Scanner(System.in);

        // Constant Variables
        final int SIZE = 10; // Starting size for the list
        
        // Declare all Variables Here
        HighScore head = new HighScore();
        boolean done = false;
        int choice = 0;
        
        // Input or initialize values Here
        makeList(head, SIZE);
        
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
                    insertElementAt(head);
                    break;
                case 2:
                    searchByName(head);
                    break;
                case 3:
                    deleteElementByName(head);
                    break;
                case 4:
                    printList(head);
                    break;
                default:
                    done = true;
            }
        }
        // Output Located Here


        // Exit
    }
    public static void printList(HighScore h){
        HighScore temp1 = h;
        boolean done = false;
        while(!done){
            temp1.printScore();
            if(temp1.next == null){
                done = true;
            }
            else{
                temp1 = temp1.next;
            }
            
        }
    }
    
    public static void makeList(HighScore h, int s){
        HighScore temp1 = h;
        
        for (int i = 1; i < s; i++) {
            temp1.next = new HighScore();
            temp1 = temp1.next;
        }
    }
    
    public static void insertElementAt(HighScore h){
        Scanner scan = new Scanner(System.in);
        
        int count = 1;
        HighScore temp1 = h;        // will be used to find target
        HighScore temp2 = temp1;    // placeholder for element before target
        HighScore n = new HighScore();
        int e;
        
        System.out.println("Enter the Player's Name: ");
        n.setName(scan.nextLine());
        System.out.println("Enter the Player's Score: ");
        n.setScore(Integer.parseInt(scan.nextLine()));
        System.out.println("Enter the Index location (Start at 0): ");
        e = Integer.parseInt(scan.nextLine());
        
        while(temp1.next != null){
            count++;
            temp1 = temp1.next;
        }
        
        
        if(e > count){ // makes new final node
            temp1.next = n;
        }
        else{ // inserts or shifts new node into place
            temp1 = h;
            
            for (int i = 0; i < e; i++) {
                temp2 = temp1;
                temp1 = temp1.next;
            }
            temp2.next = n;
            n.next = temp1;
        }
    }
    public static void deleteElementByName(HighScore h){
        Scanner scan = new Scanner(System.in);
                
        boolean done = false; // sentinel
        boolean able = false; // flag
        HighScore temp1 = h;
        HighScore temp2 = temp1;
        String n;
        
        System.out.println("Enter the name to search for: ");
        n = scan.nextLine();
        
        while(temp1.next != null){
            if(temp1.getName().equals(n)){
                able = true;
            }
            temp1 = temp1.next;
        }
        
        if(able){
            
            temp1 = h;
            
            while(!done){
                if(temp1.getName().equals(n)){
                    done = true;
                }
                else{
                    temp2 = temp1;
                    temp1 = temp1.next;
                }
            }
            temp2.next = temp1.next;
        }
        else{
            System.out.println("No score exists for that name");
        }   
    }
    
    public static int searchByName(HighScore h){
        Scanner scan = new Scanner(System.in);
        
        HighScore temp1 = h;
        String n;
        
        System.out.println("Enter the name to search for: ");
        n = scan.nextLine();
        int loc = 1;
        while(temp1.next != null){
            if(temp1.getName().equals(n)){
                return loc;
            }
            temp1 = temp1.next;
            loc++;
        }
        return 0;
        
    }
}