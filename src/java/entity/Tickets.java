/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Thinal
 */
public class Tickets {
    
    private String cusName;
    private String cusEmaill;
    private String probArea;
    private String severity;
    private String date;
    
    public void setName(String name){
        this.cusName=name;
    }
    
    public String getName(){
        return cusName;
    }
    
    public void setEmail(String email){
        this.cusEmaill=email;
    }
    
    public String getEmail(){
        return cusEmaill;
    }
    public String getSeverity(){
        return severity;
    }
    
    public void setProb(String prob){
        this.probArea=prob;
    }
    
    public String getProb(){
        return probArea;
    }
    
    public void setSeverity(String severity){
        this.severity=severity;
    }
    
        
    public void setDate(String date){
        this.date=date;
    }
    
    public String getDate(){
        return date;
    }
    
}