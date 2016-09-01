/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srs.mail;

import java.util.Date;
import java.util.Set;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Thinal
 */
@WebService(serviceName = "mailservice")
public class mailservice {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getMail")
    @Oneway
    public void getMail(@WebParam(name = "from") Set<String> from, @WebParam(name = "sentDate") String sentDate, @WebParam(name = "subject") String subject, @WebParam(name = "content") String content) {
        
    }
}
