/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 *
 * @author Artemis
 */
public class simpleQueue implements Queue{
    class Node{
        private Object file;
        private Node next;
        
        private Node(Object FILE){
            file = FILE;
            next = null;
        }
        
        public String toString(){
            return "Object" + file + "\n Next: " + next.toString();
        }
    }
    private Node head;
    private Node tail;
    private int size;
    
    public simpleQueue(){
        head = null;
        size = 0;
    }
    
    @Override
    public boolean add(Object e) {
        if (head == null){
            head = new Node(e);
            tail = head;
            size ++;
            return true;
        } else if (tail == head){
            head.next = new Node(e);
            tail = head.next;
            size ++;
            return true;
        } else{
            tail.next = new Node(e);
            size ++;
            return true;
        }
    }

    @Override
    public boolean offer(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object remove() {
        Node temp = head;
        head = head.next;
        size --;
        return temp.file;        
    }

    @Override
    public Object poll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object element() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object peek() {
        if (head.next != null){
            return head.next;
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node temp = head;
        while (temp != null){
            temp = temp.next;
            if (temp.file == o){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Object getTail(){
        return tail.file;
    }
}
