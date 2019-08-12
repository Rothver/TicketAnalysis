/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artemis
 */
public class ticketHolder {

    private ArrayList<TicketObject> tickets;
    private final String ticketsFileName = "Tickets.ser";

    public ticketHolder() {
        tickets = new ArrayList();
    }

    /**
     * Reads the serialized file of TicketObjects, and places them into an array
     * If there are tickets in the current session, it merges the two lists together
     */
    public void readTicketFile(){
        FileInputStream input;
        ObjectInputStream reading;
        try {
            input = new FileInputStream(ticketsFileName);
            reading = new ObjectInputStream(input);
            ArrayList<TicketObject> temp = (ArrayList) reading.readObject();
            
            if (tickets.isEmpty()){
                tickets = temp;
            } else {
                tickets.addAll(temp);
            }
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ticketHolder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Saves the current session to a serialized file for later use
     */
    public void writeTicketFile() {
        FileOutputStream output;
        ObjectOutputStream saving;
        try {
            output = new FileOutputStream(ticketsFileName);
            saving = new ObjectOutputStream(output);
            saving.writeObject(tickets);
            saving.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ticketHolder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ticketHolder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Changes saved tickets as needed
     * @param newTickets 
     */
    public void setTickets(ArrayList<TicketObject> newTickets) {
        tickets = newTickets;
    }

    /**
     * @return the TicketObject ArrayList
     */
    public ArrayList getTickets() {
        return tickets;
    }

    /**
     * 
     * @param toAdd
     * @return True if the ticket was added; false if it already exists
     */
    public boolean addTicket(TicketObject toAdd) {
        for (TicketObject x : tickets) {
            if (x.getTicketID().compareTo(toAdd.getTicketID()) == 0) {
                return false;
            }
        }
        return tickets.add(toAdd);
    }

    /**
     * Allows for a fully ArrayList to be added
     * @param toAdd 
     */
    public void addTickets(ArrayList<TicketObject> toAdd) {
//        for (TicketObject t: toAdd){
//            addTicket(t);
//        }
        tickets.addAll(toAdd);
    }
    
    /**
     * Removes Ticket at the given Index
     * @param indexToRemove 
     */
    public void removeTicket(int indexToRemove) {
        tickets.remove(indexToRemove);
    }

    /**
     * @param selectedIndex
     * @return A formatted String with all information of selected ticket
     */
    String displayTicketInformation(int selectedIndex) {
        return tickets.get(selectedIndex).displayInformation();
    }
}