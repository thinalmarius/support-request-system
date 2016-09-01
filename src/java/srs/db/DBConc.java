/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srs.db;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import srs.log.DbLogger;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Thinal
 */
public class DBConc {
    
    static Connection conn=null;
    static String url;
    static String driver;
    static String username;
    static String password;
    
    static Logger logger = DbLogger.setup();
    
    /*public static void main(String args[]){
        getConnection();
    }*/
    
    public static Connection getConnection(){
        
         
        try{
            InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.xml");
            org.w3c.dom.Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(input));
            XPath xpath = XPathFactory.newInstance().newXPath();
            url = (String) xpath.compile("//config//jdbc//url").evaluate(document, XPathConstants.STRING);
            driver = (String) xpath.compile("//config//jdbc//driver").evaluate(document, XPathConstants.STRING);
            username = (String) xpath.compile("//config//jdbc//username").evaluate(document, XPathConstants.STRING);
            password = (String) xpath.compile("//config//jdbc//password").evaluate(document, XPathConstants.STRING);
            Class.forName(driver);      
            conn = DriverManager.getConnection(url,username, password);
            
            
        }catch (IOException e){
            logger.log(Level.SEVERE, null, e);
        }catch (SAXException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "SQL Communication Failure", ex);
            
        }
        //System.out.println(url+username);
        return conn;
        
    }
    
        
}
