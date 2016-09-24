/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srs.db;

import srs.entity.Words;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import srs.entity.Customers;
import srs.entity.Users;
import srs.log.DbLogger;



/**
 *
 * @author Thinal
 */
public class sql {
    
    static Connection conn=null;
    static Statement st=null;
    static Logger logger = DbLogger.setup();
    
    public static String getpwd(String name){
        ResultSet rs = null;
        String pswd = null; 
        String sql="SELECT password FROM user_role WHERE username='"+name+"'";
        //DBConc connection = new DBConc();
        conn=DBConc.getConnection();
        try{
            
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                pswd=rs.getString("password");
            }
        }catch(SQLException e){
            logger.log(Level.SEVERE, "SQL Communication Failure", e);
            logger.log(Level.WARNING, null, e);
            logger.log(Level.INFO, null, e);
        } 
        
        
        return pswd;
    }
    
    public static List<Users> getusr(){
        ResultSet rs=null;
        //DBConc connection = new DBConc();
        
        List<Users> user = new LinkedList<>();
        conn=DBConc.getConnection();
        String sql="SELECT * FROM user_role";
        try{
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                Users users = new Users(rs.getInt("id"), rs.getString("name"), rs.getString("username"), rs.getString("email"), rs.getString("password"));
                user.add(users);
            }
                        
        }catch(SQLException e){
            logger.log(Level.SEVERE, "SQL Communication Failure", e);
            logger.log(Level.WARNING, null, e);
            logger.log(Level.INFO, null, e);
        }
        
        return user;
       
    }
    public static void addUsr(String name, String username, String email, String pswd){
        conn=DBConc.getConnection();
        String sql="INSERT INTO user_role (`name`,`username`,`email`,`password`) \n"
                +"VALUES ('"+name+"','"+username+"','"+email+"', '"+pswd+"')";
        try{
            st=conn.createStatement();
            st.executeUpdate(sql);
                        
        }catch(SQLException e){}
    }
    
    public static Set<String> getStopwords(){
        ResultSet rs=null;
        Set<String> words = new HashSet<String>();
        conn=DBConc.getConnection();
        String sql="SELECT words FROM word_list";
        try{
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                words.add(rs.getString("words"));
            }
                        
        }catch(SQLException e){}
        
        
        return words;
    }
    
    public static ArrayList<Words> getNewWords(){
        ResultSet rs=null;
        ArrayList<Words> words = new ArrayList<Words>();
        conn=DBConc.getConnection();
        Words word = new Words();
        String sql="SELECT words,score FROM learn_words";
        try{
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                word.setWord(rs.getString("words"));
                word.setScore(rs.getInt("score"));
                words.add(word);
            }
                        
        }catch(SQLException e){}
        
        
        return words;
    }
    
    public static Set<String> excludeList(){
        ResultSet rs=null;
        Set<String> words = new HashSet<String>();
        conn=DBConc.getConnection();
        String sql="SELECT words FROM exclude_list";
        try{
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                words.add(rs.getString("words"));
            }
                        
        }catch(SQLException e){}
        
        
        return words;
    }
    
    public static int getCusId(String name, String email){
        ResultSet rs=null;
        int id=0;
        conn=DBConc.getConnection();
        String sql="SELECT id FROM customers \n"+
                "WHERE name='"+name+"' \n" +
                "OR email='"+email+"'";
        try{
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                id=rs.getInt("id");
            }
                        
        }catch(SQLException e){}
        
        
        return id;
    }
    public static String verifyCus(int id){
        ResultSet rs=null;
        String name=null;
        conn=DBConc.getConnection();
        String sql="SELECT name FROM customers \n"+
                "WHERE id="+id;
                
        try{
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                name=rs.getString("name");
            }
                        
        }catch(SQLException e){}
        
        
        return name;
    }
    
    public static List<Customers> viewCustomers(){
        List<Customers> customers = new LinkedList<>();
        
        ResultSet rs=null;
        String name=null;
        conn=DBConc.getConnection();
        String sql="SELECT * FROM customers ";
                
        try{
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                Customers customer = new Customers(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("company"));
                customers.add(customer);
            }
                        
        }catch(SQLException e){}
        return customers;
    }
    
    public static void addNewTicket(int cus_id, String problem, int severity){
        conn=DBConc.getConnection();
        String sql="INSERT INTO tickets (cus_id, problem_area, severity) "+
                "VALUES ("+cus_id+", '"+problem+"', " +severity+")";
        try{
            st=conn.createStatement();
            st.executeUpdate(sql);
            
        }catch(SQLException e){}
        
    }
    
    public static ResultSet viewTickets(){
        conn=DBConc.getConnection();
        ResultSet rs=null;
        String sql = "SELECT t.id, c.name, c.email, t.problem_area, t.severity, t.date \n"
                +"FROM tickets AS t \n"
                +"JOIN customers AS c ON (t.cus_id=c.id)";
        try{
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            
        }catch(SQLException e){}
        return rs;
    }
    
    public static void deleteTicket(int id){
        conn=DBConc.getConnection();
        String sql = "DELETE FROM `tickets` WHERE id="+id;
        try{
            st=conn.createStatement();
            st.executeUpdate(sql);
        }catch(SQLException e){
            
        }
    }
    
    public static void deleteCustomer(int id){
        conn=DBConc.getConnection();
        String sql = "DELETE FROM `customers` WHERE id="+id;
        try{
            st=conn.createStatement();
            st.executeUpdate(sql);
        }catch(SQLException e){
            
        }
    }
    public static void deleteUser(int id){
        conn=DBConc.getConnection();
        String sql = "DELETE FROM `user_role` WHERE id="+id;
        try{
            st=conn.createStatement();
            st.executeUpdate(sql);
        }catch(SQLException e){
            
        }
    }
    
    public static int selectLastTicket(){
        int id=0;
        conn=DBConc.getConnection();
        ResultSet rs=null;
        String sql="SELECT id FROM tickets \n ORDER BY id DESC \n LIMIT 1";
        try{
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                id=rs.getInt("id");
            }
        }catch(SQLException e){}
        return id;
    }
    
    public static void addCustomer(String name, String email, String company){
        conn=DBConc.getConnection();
        String sql="INSERT INTO customers (name, email, company) \n"
                +"VALUES ('"+name+"', '"+email+"', '"+company+"')";
        try{
            st=conn.createStatement();
            st.executeUpdate(sql);
            
        }catch(SQLException e){}
    }
    
   public static ResultSet getHardware(){
       conn=DBConc.getConnection();
        ResultSet rs=null;
        String sql = "SELECT words FROM hardware";
        try{
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            
        }catch(SQLException e){}
        return rs;
   }
   
   public static ResultSet getSoftware(){
       conn=DBConc.getConnection();
        ResultSet rs=null;
        String sql = "SELECT words FROM software";
        try{
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            
        }catch(SQLException e){}
        return rs;
   }
    
}
