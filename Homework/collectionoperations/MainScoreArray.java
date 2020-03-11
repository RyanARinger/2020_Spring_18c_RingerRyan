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
public class MainScoreArray {
    
private HighScore[] scores;
    private int size;
    
    public MainScoreArray(int s){
        this.size = s;
        this.scores = new HighScore[s];
        
        for (int i = 0; i < s; i++) {
            this.scores[i] = new HighScore();            
        }
    }
    
    public void insertElementAt(int e, HighScore h){
        
        HighScore temp1 = new HighScore(this.scores[e]);
        HighScore temp2 = new HighScore();
        boolean able = false;   // boolean flag if last element is empty
                                // if last element is empty, do not expand
                                
        
        if(this.scores[e].getName().isEmpty()){ // if empty, don't shift array
            this.scores[e].HighScore(h);
        }
        else{                                   // if not empty, shift array
            if(this.scores[this.size-1].getName().isEmpty() && e < this.size){
                able = true;
            }
            if(able){
                this.scores[e].HighScore(h);
                for (int i = e+1; i < this.size; i++) {
                    temp2.HighScore(this.scores[i]);
                    this.scores[i].HighScore(temp1);
                    temp1.HighScore(temp2);
                }
            }
            else{
                System.out.println("NOT ABLE");
            }
        }
        
    }
    
    public void removeElementAt(int e){
        for (int i = e; i < this.size-1; i++) {
            this.scores[i].HighScore(this.scores[i+1]);
        }
        this.scores[this.size-1] = new HighScore();
    }
    
    public int findScoreByName(String n){
        
        for (int i = 0; i < this.size; i++) {
            if(this.scores[i].getName().equals(n)){
                return this.scores[i].getScore();
            }
        }
        return 0;
    }
            
    public void pushOnEnd(HighScore h){
        HighScore[] tempArr = new HighScore[this.size+1];
        for (int i = 0; i < this.size; i++) {
            tempArr[i] = new HighScore(this.scores[i]);
        }
        tempArr[this.size] = new HighScore(h);
        this.size++;
        this.scores = tempArr;
    }
    
    public void pushOnBeginning(HighScore h){
        HighScore[] tempArr = new HighScore[this.size+1];
        tempArr[0] = new HighScore(h);
        for (int i = 0; i < this.size; i++) {
            tempArr[i+1] = new HighScore(this.scores[i]);
        }
        this.size++;
        this.scores = tempArr;
    }
    
    public void printElementAt(int i){
        if(!this.scores[i].getName().isEmpty()){
            System.out.println(this.scores[i].getName() + ": "
                           + this.scores[i].getScore());
        }
    }
}
