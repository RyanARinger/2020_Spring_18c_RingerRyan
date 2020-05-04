package collectionoperations;

public class ScoreList {
    HighScore head;
    private int size;
    
    public ScoreList(){
        this.size = 10;
        HighScore temp1 = this.head;
        
        for (int i = 1; i < size; i++) {
            temp1.next = new HighScore();
            temp1 = temp1.next;
        }
    }
    public ScoreList(int s){
        this.size = s;
        HighScore temp1 = this.head;
        
        for (int i = 1; i < size; i++) {
            temp1.next = new HighScore();
            temp1 = temp1.next;
        }
    }
    
    public void makeList(){
        HighScore temp1 = this.head;
        
        for (int i = 1; i < this.size; i++) {
            temp1.next = new HighScore();
            temp1 = temp1.next;
        }
    }
    
    public void insertElementAt(HighScore n, int e){
        
        int count = 1;
        HighScore temp1 = this.head;        // will be used to find target
        HighScore temp2 = temp1;    // placeholder for element before target
        
        while(temp1.next != null){
            count++;
            temp1 = temp1.next;
        }
        
        
        if(e > count){ // makes new final node
            temp1.next = n;
        }
        else{ // inserts or shifts new node into place
            temp1 = this.head;
            
            for (int i = 0; i < e; i++) {
                temp2 = temp1;
                temp1 = temp1.next;
            }
            temp2.next = n;
            n.next = temp1;
        }
    }
    
    public void deleteElementByName(String n){                
        boolean done = false; // sentinel
        boolean able = false; // flag
        HighScore temp1 = this.head;
        HighScore temp2 = temp1;
        
        while(temp1.next != null){
            if(temp1.getName().equals(n)){
                able = true;
            }
            temp1 = temp1.next;
        }
        
        if(able){
            
            temp1 = this.head;
            
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
    
    public int searchByName(String n){
        
        HighScore temp1 = this.head;
        
        int loc = 0;
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
