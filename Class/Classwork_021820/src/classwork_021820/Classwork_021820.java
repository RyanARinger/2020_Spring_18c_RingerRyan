/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classwork_021820;

import java.util.Scanner;
import java.util.Vector;
/**
 *
 * @author Ryan Ringer
 * 
 * Menu Driven Application
 * - at least 4 items/ selections
 * - at least one collection
 * - Sentinel Control loop
 */
public class Classwork_021820 {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int choice = 0;
        boolean done = false;
        Vector<String> manifest = new Vector();
        manifest.add("Ryan");
        manifest.add("WeeGee");
        manifest.add("John");
        manifest.add("UrBoy");
        
        while(!done){
            menu();
            choice = readNum();

            switch(choice){
                case 0:
                    System.out.println("Goodbye");
                    break;
                case 1:
                    viewMan(manifest);
                    System.out.println("Do you wish to make further alterations "
                    + "to the Manifest?");
                    System.out.println("1. Yes");
                    System.out.println("0. No");
                    choice = Integer.parseInt(scan.nextLine());
                    break;
                case 2:
                    addRes(manifest);
                    System.out.println("Do you wish to make further alterations "
                    + "to the Manifest?");
                    System.out.println("1. Yes");
                    System.out.println("0. No");
                    choice = Integer.parseInt(scan.nextLine());
                    break;
                case 3:
                    remRes(manifest);
                    System.out.println("Do you wish to make further alterations "
                    + "to the Manifest?");
                    System.out.println("1. Yes");
                    System.out.println("0. No");
                    choice = Integer.parseInt(scan.nextLine());
                    break;
                default:
                    System.out.println("Goodbye");
            }
            
            
            
            if(choice == 0){
                System.out.println("Goodbye");
                done = true;
            }
            
        }
        
    }
    
    public static void menu(){
        
        System.out.println("Airline Passenger Manifest Menu");
        System.out.println("1. View Passenger Manifest");
        System.out.println("2. Add a reservation");
        System.out.println("3. Remove a Reservation");
        System.out.println("0. Exit");
    }
    
    public static int readNum(){
        Scanner scan = new Scanner(System.in);
        
        int choice = 0;
        boolean done = false;
        
        while(!done){
            choice = Integer.parseInt(scan.nextLine());
            
            if(choice < 0 || choice > 3){
                System.out.println("Invalid Option");
            }
            else{
                done = true;
            }
        }
        
        return choice;
    }
    
    public static void viewMan(Vector<String> manifest){
        for (int i = 0; i < manifest.size(); i++) {
            System.out.print(manifest.elementAt(i));
            
            if(i != manifest.size()-1){
                System.out.print(", ");
            }
        }
        System.out.println("");
    }
    
    public static void addRes(Vector<String> man){
        Scanner scan = new Scanner(System.in);
        
        String name = null;
        
        System.out.println("Enter Passenger Name: ");
        name = scan.nextLine();
        man.add(name);
        
        System.out.println("Passenger Added");
        
        System.out.println("Manifest: ");
        viewMan(man);
    }
    
    public static void remRes(Vector<String> manifest){
        Scanner scan = new Scanner(System.in);
        
        Integer index = -1;
        String name;
        
        System.out.println("Enter Passenger Name");
        name = scan.nextLine();
        
        
        for (int i = 0; i < manifest.size(); i++) {
            if(manifest.elementAt(i).equals(name)){
                index = i;
            }
                
        }
                
        if(index.equals(-1)){
            System.out.println("No reservation found for: " + name);
        }
        else{
            manifest.removeElementAt(index);
            System.out.println("Reservation Cancelled");
        }
        
        System.out.println("Manifest: ");
        viewMan(manifest);
    }
}
