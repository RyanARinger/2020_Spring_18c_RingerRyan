/*
 * Author:      Ryan Ringer
 * Created on:  May 1, 2020
 * File:        Card.java
 * Purpose:     Card Class Definition
 */

package pkg4_iterableslab;

import java.lang.Object;

public class Card extends Object{
    
    static final char[] RANKS = {'A','2','3','4','5','6','7','8','9','T','J','Q','K'};
    static final char[] SUITS = {'D','S','H','C'};
    
    private char rank;
    private char suit;
    
    Card next;
    Card prev;
    
    public Card(){
        // 'n' for null
        this.rank = ' ';
        this.suit = ' '; 
        this.next = null;
        this.prev = null;
    }
    
    public Card(String rs){
        
        if(rs.length() > 2){
            throw new IllegalArgumentException();
        }
        boolean correctRank = false; // flag
        boolean correctSuit = false; // flag
        
        for(int i = 0; i < RANKS.length; i++){ // tests rank
            if(rs.charAt(0) == RANKS[i]){
                correctRank = true;
            }
        }
        for(int i = 0; i < SUITS.length; i++){ // tests suit
            if(rs.charAt(1) == SUITS[i]){
                correctSuit = true;
            }
        }
        
        if(correctRank && correctSuit){
            this.rank = rs.charAt(0);
            this.suit = rs.charAt(1);
            this.next = null;
            this.prev = null;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
    
    public Card(String rs, Card p, Card n){
        
        if(rs.length() > 2){
            throw new IllegalArgumentException();
        }
        boolean correctRank = false; // flag
        boolean correctSuit = false; // flag
        
        for(int i = 0; i < RANKS.length; i++){ // tests rank
            if(rs.charAt(0) == RANKS[i]){
                correctRank = true;
            }
        }
        for(int i = 0; i < SUITS.length; i++){ // tests suit
            if(rs.charAt(1) == SUITS[i]){
                correctSuit = true;
            }
        }
        
        if(correctRank && correctSuit){
            this.rank = rs.charAt(0);
            this.suit = rs.charAt(1);
            this.prev = p;
            this.next = n;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
    
    public Card(char r, char s){

        boolean correctRank = false; // flag
        boolean correctSuit = false; // flag
        
        for(int i = 0; i < RANKS.length; i++){ // tests rank
            if(r == RANKS[i]){
                correctRank = true;
            }
        }
        for(int i = 0; i < SUITS.length; i++){ // tests suit
            if(s == SUITS[i]){
                correctSuit = true;
            }
        }
        
        if(correctRank && correctSuit){
            this.rank = r;
            this.suit = s;
            this.next = null;
            this.prev = null;
        }
        else{
            throw new IllegalArgumentException();
        }        
    }
    
    public Card(char r, char s, Card p, Card n){

        boolean correctRank = false; // flag
        boolean correctSuit = false; // flag
        
        for(int i = 0; i < RANKS.length; i++){ // tests rank
            if(r == RANKS[i]){
                correctRank = true;
            }
        }
        for(int i = 0; i < SUITS.length; i++){ // tests suit
            if(r == SUITS[i]){
                correctSuit = true;
            }
        }
        
        if(correctRank && correctSuit){
            this.rank = r;
            this.suit = s;
            this.prev = p;
            this.next = n;

        }
        else{
            throw new IllegalArgumentException();
        }        
    }
    
    
    public void setRank(char r){
        this.rank = r;
    }
    public void setSuit(char s){
        this.suit = s;
    }
    public char getRank(){
       return this.rank;
    }
    public char getSuit(){
        return this.suit;
    }
    public boolean equals(Card c){
        if(this.rank == c.getRank() && this.suit == c.getSuit()){
            return true;
        }
        else{
            return false;
        }
    }
    
}
