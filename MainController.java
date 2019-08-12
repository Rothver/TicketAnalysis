/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artemis
 */
public class MainController {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainController start = new MainController();
    }

    private final GUIHandler frontEnd;
    private final HTMLInterpreter interpreter;
    private final ticketHolder ticketContainer;
    private final consultantLinkedList consultantData;
    private final businessAnalysis serviceSet;

    /**
     * Initializes all java files needed to run program
     */
    public MainController() {
        frontEnd = new GUIHandler(this);
        frontEnd.setVisible(true);

        interpreter = new HTMLInterpreter();
        ticketContainer = new ticketHolder();
        consultantData = new consultantLinkedList();
        
        serviceSet = new businessAnalysis();
    }

    /**
     * Tells the HTML parser to get all possible tickets from selected HTML Files and adds them to the TicketHolder Object
     * Also tells the IncidentList to update itself in the GUI
     * @param toRead 
     */
    void readHTMLFiles(simpleQueue toRead) throws IOException {
        ticketContainer.addTickets(interpreter.readHTMLFiles(toRead));
        interpreter.displayStatus();
        frontEnd.updateIncidentList(ticketContainer.getTickets());
    }

    /**
     * Passes index of Incident to be removed
     * @param indexToRemove 
     */
    void removeIncident(int indexToRemove) {
        ticketContainer.removeTicket(indexToRemove);
        frontEnd.updateIncidentList(ticketContainer.getTickets());
    }

    /**
     * passes the ticket index to the container, and gets a string with the desired information
     * @param selectedIndex
     * @return returns a string formatted 
     */
    String displayTicket(int selectedIndex) {
        return ticketContainer.displayTicketInformation(selectedIndex);
    }

    /**
     * tells the TicketHolder to load previous session
     * tells IncidentList to update in GUI
     */
    void loadLastSession() {
        ticketContainer.readTicketFile();
        frontEnd.updateIncidentList(ticketContainer.getTickets());
        System.out.println("loaded");
    }
    
    void saveCurrSession(){
        ticketContainer.writeTicketFile();
        System.out.println("saved");
    }
    
    void lookAtTickets(){
        consultantData.analyzeTickets(ticketContainer.getTickets());
        String[] hold = consultantData.readNode().split("break");
        for (String s: hold){
            String[]temp = s.split(",");
            frontEnd.addTableData(temp[0],temp[1],temp[2]);
        }
        serviceSet.examineTickets(ticketContainer.getTickets());
    }
}