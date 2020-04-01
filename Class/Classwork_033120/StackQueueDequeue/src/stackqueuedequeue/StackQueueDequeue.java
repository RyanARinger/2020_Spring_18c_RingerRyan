/* 
 * Author: Ryan Ringer
 * Created on: 
 * File:
 * Purpose:
 */

package stackqueuedequeue;

public class StackQueueDequeue {

    public static void main(String[] args) {
        // Seed random number or initialize scanner


        // Constant Variables


        // Declare all Variables Here
        Stack<Integer> s = new Stack();
        Queue q = new Queue();
        // Input or initialize values Here
        

        // Process/Calculations Here
        s.push(1);
        s.push(10);
        s.push(100);
        s.push(1000);
        
        q.enqueue(1);
        q.enqueue(10);
        q.enqueue(100);
        q.enqueue(1000);
        
        // Output Located Here
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        // Exit
    }

}
