/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;

/**
 *
 * @author apn5163
 */
public class consultantLinkedList {

    class Node {

        String name;
        int numTicketsAssigned;
        int numTicketsClosed;
        Node next;

        private Node() {
            name = null;
            numTicketsAssigned = 0;
            numTicketsClosed = 0;
            next = null;
        }

        private Node(String Name, Node Next) {
            name = Name;
            numTicketsAssigned = 0;
            numTicketsClosed = 0;
            next = Next;
        }

        public String nodeToString() {
            return "Name: " + name + "; Num Tickets Assigned: " + numTicketsAssigned + "; Num Tickets Closed: " + numTicketsClosed;
        }
        
        public String displayNode(){
            return name + "," + numTicketsAssigned + "," + numTicketsClosed;
        }
    }

    private Node head;
    private int size;

    public consultantLinkedList() {
        size = 0;
    }

    @Override
    public String toString() {
        String toReturn = "";
        Node temp = head;
        for (int i = 1; i <= size; i++) {
            toReturn = toReturn.concat(temp.nodeToString());
            toReturn += "\n";
            temp = temp.next;
        }
        return toReturn;
    }
    
    public String readNode(){
        String toReturn = "";
        Node temp = head;
        for(int i = 1;i<=this.size;i++){
            toReturn = toReturn.concat(temp.displayNode());
            toReturn += "break";
            temp = temp.next;
        }
        return toReturn;
    }

    /**
     *
     * @param Name
     * @param assigned
     * @param closed
     * @return
     */
    public boolean addItem(String Name, boolean assigned, boolean closed) {
        addNode(Name, assigned, closed);
        return true;
    }

    private void addNode(String Name, boolean assigned, boolean closed) {
        if (head == null) {
            head = new Node(Name, null);
            if (assigned) {
                head.numTicketsAssigned += 1;
            }
            if (closed) {
                head.numTicketsClosed += 1;
            }
            size += 1;
            return;
        } else if (head.name.compareTo(Name) == 0) {
            if (assigned) {
                head.numTicketsAssigned += 1;
            }
            if (closed) {
                head.numTicketsClosed += 1;
            }
        } else if (head.name.compareTo(Name) > 0) {
            Node hold = new Node(Name, head);
            head = hold;
            if (assigned) {
                head.numTicketsAssigned += 1;
            }
            if (closed) {
                head.numTicketsClosed += 1;
            }
            size += 1;
            return;
        }

        Node temp = head.next;
        Node curr = head;
        while (true) {
            if (temp == null) {
                temp = new Node(Name, null);
                curr.next = temp;
                if (assigned) {
                    temp.numTicketsAssigned += 1;
                }
                if (closed) {
                    temp.numTicketsClosed += 1;
                }
                size += 1;
                break;
            } else if (temp.name.compareTo(Name) == 0) {
                if (assigned) {
                    temp.numTicketsAssigned += 1;
                }
                if (closed) {
                    temp.numTicketsClosed += 1;
                }
                break;
            } else if (temp.name.compareTo(Name) > 0) {
                curr.next = new Node(Name, temp);
                if (assigned) {
                    curr.next.numTicketsAssigned += 1;
                }
                if (closed) {
                    curr.next.numTicketsClosed += 1;
                }
                size += 1;
                break;
            }
            curr = temp;
            temp = temp.next;
        }
    }

    public void analyzeTickets(ArrayList<TicketObject> toLook) {
        for (TicketObject t : toLook) {
            if (t.getAssignedTo().compareTo(t.getClosedBy()) == 0) {
                addItem(t.getAssignedTo(), true, true);
            } else {
                addItem(t.getAssignedTo(), true, false);
                addItem(t.getClosedBy(), false, true);
            }
        }
    }

    public boolean removeItem(String nameToRemove) {
        if (head.name.compareTo(nameToRemove) == 0) {
            head = head.next;
            size -= 1;
            return true;
        }
        Node temp = head.next;
        Node curr = head;
        while (true) {
            if (temp.name.compareTo(nameToRemove) == 0) {
                curr.next = temp.next;
                size -= 1;
                return true;
            } else if (temp == null){
                return false;
            }
            curr = temp;
            temp = temp.next;
        }
    }

    public Node getItem(String nameToAccess) {
        if (head.name.compareTo(nameToAccess) == 0) {
            return head;
        }
        Node temp = head.next;
        while (temp.next != null) {
            if (temp.name.compareTo(nameToAccess) == 0) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public Node getHead() {
        return this.head;
    }
    
    public int getSize(){
        return this.size;
    }
}
