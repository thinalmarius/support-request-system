/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nlp;

import java.io.Serializable;
import java.util.HashMap;


/**
 *
 * @author Thinal
 */
public class TokenizedLine implements Serializable {

    private static final long serialVersionUID = 2436988496278611759L;

    private String lineTag;

    // tagged words with stop words included
    private HashMap<String, Integer> taggedWords;

	
    // not tagged words count
    private HashMap<String, Integer> notWordsCounter;

    // confusable word if there is any from the lines
    private String wordAnswer;

    public String getLineTag() {
	return lineTag;
    }

    public void setLineTag(String lineTag) {
	this.lineTag = lineTag;
    }

    public HashMap<String, Integer> getTaggedWords() {
        return taggedWords;
    }
        
    public HashMap<String, Integer> newTaggedWords() {
        this.taggedWords = new HashMap<String, Integer>();
        return taggedWords;
    }

    public void setTaggedWords(HashMap<String, Integer> taggedWords) {
        this.taggedWords = taggedWords;
    }

    public HashMap<String, Integer> newNotWordsCounter() {
	this.notWordsCounter = new HashMap<String, Integer>();
	return notWordsCounter;
    }
        
    public HashMap<String, Integer> getNotWordsCounter() {
        return notWordsCounter;
    }

    public void setNotWordsCounter(HashMap<String, Integer> notWordsCounter) {
    	this.notWordsCounter = notWordsCounter;
    }


}

