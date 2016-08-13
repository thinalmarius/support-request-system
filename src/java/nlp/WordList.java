/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nlp;

import db.sql;
import static db.sql.getNewWords;
import static db.sql.getStopwords;
import java.util.Set;

/**
 *
 * @author Thinal
 */
public class WordList {
    
    /* loads keywords */
    public Set<String> wordLoader(){
        Set<String> stopwords = getStopwords();
        return stopwords;
    }
    
    /* loads the words kept for learning */
    public Set<String> learnWords(){
        Set<String> newWords = getNewWords();
        return null;
    }
}
