/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionoperations;

/**
 *
 * @author Norco College
 */
public class HighScore {
    // Create a class called "HighScore" that has two fields:  
    // A string "Name",
    // and an integer "score".
    
    private String name;
    private Integer score;
    HighScore next; // This field is only utilized in the List implementation
    
    public HighScore(){
        this.name = "";
        this.score = 0;
        this.next = null;
    }
    // Copy constructor
    public HighScore(HighScore h){
        this.name = h.getName();
        this.score = h.getScore();
    }    
    public HighScore(String n, int s){
        this.name = n;
        this.score = s;
    }
    
    // copy method        
    public void HighScore(HighScore h){
        this.name = h.getName();
        this.score = h.getScore();
    } 
    public void setName(String n){
        this.name = n;
    }
    public void setScore(int s){
        this.score = s;
    }
    
    public String getName(){
        return this.name;
    }
    public int getScore(){
        return this.score;
    }
    
    public void printScore(){
        System.out.println(this.name + ": " + this.score);
    }
}
