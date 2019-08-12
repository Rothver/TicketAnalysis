/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Artemis
 */
public class baseTicket {
    private String ticketID; //Ticket ID
    private String dateOpened; //When the ticket was opened
    private String assignedContact; //User that came into the desk
    private String assignedTo; //The consultant assigned to the Ticket

    public baseTicket() {
    }

    public baseTicket(String ticketID, String dateOpened, String assignedContact, String assignedTo) {
        this.ticketID = ticketID;
        this.dateOpened = dateOpened;
        this.assignedContact = assignedContact;
        this.assignedTo = assignedTo;
    }
    
    @Override
    public String toString() {
        return "baseTicket{" + "ticketID=" + ticketID + ", dateOpened=" + dateOpened + ", assignedContact=" + assignedContact + ", assignedTo=" + assignedTo + '}';
    }
    
    /**
     * 
     * @return formatted String for saving to CSV file
     */
    public String toSave(){
        return ticketID + "," + dateOpened + "," + assignedContact + "," + assignedTo;
    }
    
    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(String dateOpened) {
        this.dateOpened = dateOpened;
    }

    public String getAssignedContact() {
        return assignedContact;
    }

    public void setAssignedContact(String assignedContact) {
        this.assignedContact = assignedContact;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
}
