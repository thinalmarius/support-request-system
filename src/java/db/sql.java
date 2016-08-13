/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.DBConc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;



/**
 *
 * @author Thinal
 */
public class sql {
    
    static Connection conn=null;
    static Statement st=null;
    
    public static String getpwd(String name){
        ResultSet rs = null;
        String pswd = null; 
        String sql="SELECT password FROM user_role WHERE name='"+name+"'";
        //DBConc connection = new DBConc();
        conn=DBConc.getConnection();
        try{
            
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                pswd=rs.getString("password");
            }
        }catch(SQLException e){
            //System.out.println(e);
        } 
        
        
        return pswd;
    }
    
    public static ResultSet getusr(){
        ResultSet rs=null;
        //DBConc connection = new DBConc();
        conn=DBConc.getConnection();
        String sql="SELECT name FROM user_role";
        try{
            st=conn.createStatement();
            rs=st.executeQuery(sql);
                        
        }catch(SQLException e){}
        
        return rs;
       
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
    
    public static Set<String> getNewWords(){
        ResultSet rs=null;
        Set<String> words = new HashSet<String>();
        conn=DBConc.getConnection();
        String sql="SELECT words FROM learn_words";
        try{
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                words.add(rs.getString("words"));
            }
                        
        }catch(SQLException e){}
        
        
        return words;
    }
    
    public static int getCusId(String name, String company){
        ResultSet rs=null;
        int id=0;
        conn=DBConc.getConnection();
        String sql="SELECT id FROM customers "+
                "WHERE name='"+name+"' " +
                "OR company='"+company+"'";
        try{
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                id=rs.getInt("id");
            }
                        
        }catch(SQLException e){}
        
        
        return id;
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
        String sql = "SELECT c.name, c.email, t.problem_area, t.severity, t.date \n"
                +"FROM tickets AS t \n"
                +"JOIN customers AS c ON (t.cus_id=c.id)";
        try{
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            
        }catch(SQLException e){}
        return rs;
    }
    
}
