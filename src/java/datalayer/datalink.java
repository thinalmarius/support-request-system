/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer;

import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

import srs.db.sql;
import srs.entity.Tickets;
import srs.entity.Words;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.jws.Oneway;
/**
 *
 * @author Thinal
 */
@WebService(serviceName = "datalink")
public class datalink {

    /**
     * Web service operation
     */
    /*public static void main(String args[]){
        addCustomer("name", "email", "company");
        //System.out.println();
    }*/
    
    @WebMethod(operationName = "getPassword")
    public String getPassword(@WebParam(name = "name") String name) {
        String pswd=sql.getpwd(name);
        return pswd;
    }
    
    @WebMethod(operationName = "getuser")
    public ArrayList<String> getuser() {
        ResultSet rs=sql.getusr();
        ArrayList<String> users = new ArrayList<String>();
        try{
            while(rs.next()){
                users.add(rs.getString("name"));
            }
        }catch(SQLException e){}
            
        //System.out.println(pswd);
        return users;
    }
    
    
    @WebMethod(operationName= "getCusId")
    public int getCusId(@WebParam(name = "name") String name, @WebParam(name = "company") String company){
        int id=sql.getCusId(name, company);
        return id;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addTicket")
    public void addTicket(@WebParam(name = "cus_id")int cus_id,@WebParam(name = "line") String line,@WebParam(name = "level")int level){
        sql.addNewTicket(cus_id, line, level);
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "viewTickets")
    public ArrayList<Tickets> viewTickets() {
        ResultSet rs=sql.viewTickets();
        Tickets ticket = new Tickets();
        ArrayList<Tickets> tickets = new ArrayList<Tickets>(); 
        try{
            while(rs.next()){
                Tickets ticket1 = new Tickets();
                ticket1.setName(rs.getString("name"));
                ticket1.setEmail(rs.getString("email"));
                ticket1.setProb(rs.getString("problem_area"));
                ticket1.setSeverity(rs.getString("severity"));
                ticket1.setDate(rs.getString("date"));
                tickets.add(ticket1);
                
            }
        }catch(SQLException e){}
        return tickets;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getStopWords")
    public Set<String> getStopWords() {
        
        Set<String> words= new HashSet<String>();
        words=sql.getStopwords();
        return words;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getNewWords")
    public ArrayList<Words> getNewWords() {
        ArrayList<Words> words=new ArrayList<Words>();
        words=sql.getNewWords();
        //TODO write your implementation code here:
        return words;
    }
    
    @WebMethod(operationName = "excludeList")
    public Set<String> excludeList(){
        Set<String> words=new HashSet<String>();
        words=sql.excludeList();
        //TODO write your implementation code here:
        return words;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addCustomer")
    public int addCustomer(@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "company") String company) {
        sql.addCustomer(name, email, company);
        return 1;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getLearnWords")
    @Oneway
    public void getLearnWords(@WebParam(name = "learnWords") ArrayList<Words> learnWords) {
        
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUser")
    public void addUser(@WebParam(name = "name") String name, @WebParam(name = "pswd") String pswd){
        sql.addUsr(name, pswd);
    }

    /**
     * Web service operation
     */
    
    
}
