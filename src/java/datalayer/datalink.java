/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

import db.sql;
import entity.Tickets;
import nlp.WordDetector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String pwd=getPassword("admin");
        System.out.println(pwd);
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
    
    @WebMethod(operationName = "getMsg" )
    public void getMsg(@WebParam(name = "id")int cus_id,@WebParam(name = "line") String line){
        int level=WordDetector.lineParser(line);
        sql.addNewTicket(cus_id, line, level);
    }
    @WebMethod(operationName= "getCusId")
    public int getCusId(@WebParam(name = "name") String name, @WebParam(name = "company") String company){
        int id=sql.getCusId(name, company);
        return id;
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
    
}
