/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer;

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
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.Oneway;
import srs.entity.Customers;
import srs.entity.Users;
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
        List<Users> user=sql.getusr();
        ArrayList<String> username = new ArrayList<String>();
        
        for(Users users: user){
            username.add(users.getUsername());
        }
            
        //System.out.println(pswd);
        return username;
    }
    
    
    @WebMethod(operationName= "getCusId")
    public int getCusId(@WebParam(name = "name") String name, @WebParam(name = "email") String email){
        int id=sql.getCusId(name, email);
        return id;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addTicket")
    public int addTicket(@WebParam(name = "cus_id")int cus_id,@WebParam(name = "line") String line,@WebParam(name = "level")int level){
        sql.addNewTicket(cus_id, line, level);
        int id=sql.selectLastTicket();
        return id;
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "viewTickets")
    public List<Tickets> viewTickets() {
        ResultSet rs=sql.viewTickets();
        List<Tickets> tickets = new LinkedList<>(); 
        try{
            while(rs.next()){
                Tickets ticket = new Tickets(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("problem_area"),
                rs.getString("severity"),rs.getString("date"));
                tickets.add(ticket);
                
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
    public void addUser(@WebParam(name = "name") String name, String username, @WebParam(name = "email") String email, @WebParam(name = "pswd") String pswd){
        sql.addUsr(name, username, email, pswd);
    }

    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "verifyCustomer")
    public String verifyCustomer(@WebParam(name = "id") int id) {
        String name = sql.verifyCus(id);
        return name;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getHardwareCategory")
    public ArrayList<String> getHardwareCategory() {
        ArrayList<String> hardware = new ArrayList<String>();
        ResultSet result=sql.getHardware();
        try {
            while(result.next()){
                hardware.add(result.getString("words"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(datalink.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hardware;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getSoftwareCategory")
    public ArrayList<String> getSoftwareCategory() {
        ArrayList<String> software = new ArrayList<String>();
        ResultSet result=sql.getSoftware();
        try {
            while(result.next()){
                software.add(result.getString("words"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(datalink.class.getName()).log(Level.SEVERE, null, ex);
        }
        return software;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteTicket")
    @Oneway
    public void deleteTicket(@WebParam(name = "id") int id) {
        sql.deleteTicket(id);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "viewCustomers")
    public List<Customers> viewCustomers() {
        List<Customers> cus = new LinkedList<>();
        cus= sql.viewCustomers();
        return cus;
        
    }
    @WebMethod(operationName = "deleteCustomer")
    public void deleteCustomer(int id){
        sql.deleteCustomer(id);
    }
    
    @WebMethod(operationName = "deleteUser")
    public void deleteUser(int id){
        sql.deleteUser(id);
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "viewUsers")
    public List<Users> viewUsers() {
        return sql.getusr();
    }
}
