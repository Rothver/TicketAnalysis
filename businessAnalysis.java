/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Artemis
 */
public class businessAnalysis {
    private HashMap<String,Integer> tempSet;
    
    public businessAnalysis(){
        tempSet = new HashMap();
    }
    
    public Map examineTickets(ArrayList<TicketObject> ticket){
        for (TicketObject t : ticket){
            if(tempSet.putIfAbsent(t.getService(), 1) == null){
                tempSet.replace(t.getService(), tempSet.get(t.getService())+1);
            }
        }
        return tempSet;
    }
    
    public Map getMap(){
        return tempSet;
    }
}
