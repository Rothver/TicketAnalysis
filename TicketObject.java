/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.Serializable;

/**
 *
 * @author Artemis
 */
public class TicketObject extends baseTicket implements Serializable {

    /*
    private String ticketID; //Ticket ID
    private String dateOpened; //When the ticket was opened
    private String assignedContact; //User that came into the desk
    private String assignedTo; //The consultant assigned to the Ticket

     */
    private String service; //The service listed with the Ticket
    private String serviceOffering; //The service Offering
    private String category; //The category associated with the service

    private String shortDescription; //The short description in the ticket
    private String description; //The full description in the ticket
    
    private String closedBy;

    //TO ADD comments associated with the ticket
    //Default Constructor (does not have any data in it)
    public TicketObject() {
        super();
    }

    public TicketObject(String ticketID, String dateOpened, String assignedContact, String assignedTo, String service, String serviceOffering, String category, String shortDescription, String description, String closedBy) {
        super(ticketID, dateOpened, assignedContact, assignedTo);
        this.service = service;
        this.serviceOffering = serviceOffering;
        this.category = category;
        this.shortDescription = shortDescription;
        this.description = description;
        this.closedBy = closedBy;
    }

    /**
     * Displays the objects information
     * @return 
     */
    @Override
    public String toString() {
        return "TicketObject{" + super.toString() + "service=" + service + ", serviceOffering=" + serviceOffering + ", category=" + category + ", shortDescription=" + shortDescription + ", description=" + description + '}';
    }
    
    /**
     * 
     * @return formatted String for display in the text area
     */
    public String displayInformation(){
        return "Ticket ID: " + super.getTicketID() + "\nAssigned to: " + super.getAssignedTo()
                + "\nContact: " + super.getAssignedContact() + "\nDate Opened: " + super.getDateOpened()
                + "\nService: " + this.service + "\nService Offering: " + this.serviceOffering
                + "\nCategory: " + this.category + "\nShort Description: " + this.shortDescription
                + "\nClosed By: " + this.closedBy;
    }
    
    /**
     * @return formatted string for saving in CSV
     */
    public String toSave(){
        return super.toSave() + "," + service + "," + serviceOffering + "," + category + "," + shortDescription;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getServiceOffering() {
        return serviceOffering;
    }

    public void setServiceOffering(String serviceOffering) {
        this.serviceOffering = serviceOffering;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClosedBy() {
        return closedBy;
    }

    public void setClosedBy(String closedBy) {
        this.closedBy = closedBy;
    }
}
