/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srs.entity;

/**
 *
 * @author Thinal
 */
public class Words {
    
    private String word;
    private int score;
    
    public void setWord(String word){
        this.word=word;
    }
    
    public String getWord(){
        return word;
    }
    public void setScore(int score){
        this.score=score;
    }
    public int getScore(){
        return score;
    }
    
}
