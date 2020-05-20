/* 
 * Author: Ryan Ringer
 * Created on: 
 * File:
 * Purpose:
 */

package main;

public class Main {

    public static void main(String[] args) {
        // Seed random number or initialize scanner
        
        // Constant Variables
        
        // Declare all Variables Here
        LinkedList list = new LinkedList();
        
        // Input or initialize values Here
        
        // Process/Calculations Here
        // 420 get bitches
		
        // method calls on empty list
        System.out.println("Empty list operations:");
        System.out.println(list.search(new Node(8, null, null)));
        System.out.println(list.remove(new Node(8, null, null)));
        System.out.println(list.remove(3));
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        list.push_back(new Node(8, null, null));
        list.push_front(new Node(8, null, null));
        list.remove(new Node(8, null, null));
        list.remove(1);
        list.printListDown();
        list.printListUp();
        System.out.println();
        
        // populated list
        System.out.println("Populated list operations:\n");
        System.out.println("list.push_front().");
        System.out.println("First list is the size incrementation.");
        for (int i = 0; i < 10; i++) {
            list.push_front(new Node(i+1, null, null));
            System.out.println(list.size()); // size incrementation works
        }
        System.out.println();
        list.printListDown();
        list.destroyList();
        System.out.println();
        
        System.out.println("list.push_back().");
        System.out.println("First list is the size incrementation.");
        for (int i = 0; i < 10; i++) {
            list.push_back(new Node(i+1, null, null));
            System.out.println(list.size()); // size incrementation works
        }
        System.out.println();
        list.printListDown();
        list.destroyList();
        System.out.println();
        
        // Here, using an index of 5, will show the ability of the add method
        // to place objects both out of bounds and within bounds.
        // Items placed before the fifth spot will be simply placed at the end
        // until the list reaches size = 5, then the nodes will be placed in the
        // fifth spot.
        System.out.println("list.add().");
        System.out.println("First list is the size incrementation.");
        for (int i = 0; i < 10; i++) {
            list.add(new Node(i+1, null, null), 5); 
            System.out.println(list.size()); 
        }
        System.out.println();
        list.printListDown();
        System.out.println();
        
        // search method
        System.out.println("list.search().");
        System.out.println("The node holding 3 is in spot #: "+ 
                list.search(new Node(3, null, null)));
        System.out.println();
        
        // Nodes are generic
        System.out.println("Nodes are generic.");
        list.add(new Node("Ryan", null, null), 4);
        list.add(new Node("Weegee", null, null), 8);
        list.add(new Node("John", null, null), 2);
        
        list.printListDown();
        // Output Located Here
        
        // Exit
    }

}
