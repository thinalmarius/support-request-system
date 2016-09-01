/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srs.log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;



/**
 *
 * @author Thinal
 */
public class DbLogger {
    
    static private FileHandler fileTxt;
    static private SimpleFormatter formatterTxt;

    static public Logger setup() {

    // get the global logger to configure it
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        // suppress the logging output to the console
        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();

        logger.setLevel(Level.INFO);
        try {
            fileTxt = new FileHandler("db_log.txt");
        } catch (IOException | SecurityException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        // create a TXT formatter
        formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);
        return logger;
    }
}
