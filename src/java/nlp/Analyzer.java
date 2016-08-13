/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nlp;

import java.util.HashMap;
import java.util.Map;



/**
 *
 * @author Thinal
 */
public class Analyzer {
    
    public static int wordAnalyzer(TokenizedLine tL){
        
        HashMap<String, Integer> analyzer = tL.getTaggedWords();
        Map.Entry<String, Integer> maxEntry = null;
        int maxValue = 0;
        //Check the number of occurences of the tagged words in the string
        for (Map.Entry<String, Integer> entry : analyzer.entrySet())
        {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
                maxValue = maxEntry.getValue();
            }
        }
        
        return maxValue;
    }
    
}
