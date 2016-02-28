/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

/**
 * A Linked List class implemented by singly-linked nodes
 * @author Marie Danenhower
 * @param <E> The element type being stored in the list
 */
public class MyLinkedList<E> {
    
    private Node first;
    
    /**
     * Counts the size of the list iteratively
     * @return the size of the list
     */
    public int size(){
        Node n = first;
        int position = 0;
        while (n != null){
            position++;
            n = n.next;
        }
        return position;
    }
    
    /**
     * Counts the size of the list recursively
     * @return the size of the list
     */
    public int recursiveSize(){
        Node n = first;
        int position = 0;
        if( n != null )
            position = recursiveSize(n);
        return position;
    }
    
    /**
     * Helper method to count the size of the list recursively
     * @param n the starting node which we know is not null
     * @return the size of the list
     */
    private int recursiveSize(Node n){
        int position = 1;
        if( n.next != null ){
            position += recursiveSize(n.next);
        }
        return position;
    }
    
    /**
     * Prints the list iteratively
     */
    public void print(){
        Node n = first;
        if( n == null )
            System.out.println("List is empty.");
        else while( n != null ){
            System.out.println( n.data );
            n = n.next;
        }
    }
    
    /**
     * Prints the list using recursion
     */
    public void recursivePrint(){
        Node n = first;
        if( n == null )
            System.out.println("List is empty.");
        else
            recursivePrint(n);
    }
    
    /**
     * Recursive helper method to print the list.
     * @param n the starting node
     */
    private void recursivePrint(Node n){
        if( n != null ){
            System.out.println( n.data );
            recursivePrint(n.next);
        }
    }
    
    /**
     * Searches the list for an Element iteratively
     * @param elt Element we are searching for
     * @return True only if the list contains the Element
     */
    public boolean contains(E elt){
        Node n = first;
        while( n != null ){
            if( n.data == elt )
                return true;
            else
                n = n.next;
        }
        return false;
    }
    
    /**
     * Searches the list for an Element recursively
     * @param elt the Element we are searching for
     * @return True only if the list contains the Element
     */
    public boolean recursiveContains(E elt){
        Node n = first;
        if( n == null )
            return false;
        else
            return recursiveContains(elt, n);
    }
    
    /**
     * Helper method to recursively search the list for an Element
     * @param elt the Element we are searching for
     * @param n a non-null Node
     * @return True only if the list contains Element
     */
    private boolean recursiveContains(E elt, Node n){
        if( n != null ){
            if( n.data == elt )
                return true;
            else
                return recursiveContains(elt, n.next);
        }
        else return false;
    }
    
    /**
     * Iterates through the list to add an Element to the end of the list
     * @param elt the Element to be added to the end of the list
     */
    public void addLast(E elt){
        if( first == null ){
            first = new Node(elt, null);
            return;
        }
        Node n = first;
        while( n.next != null )
            n = n.next;
        n.next = new Node(elt, null);       
    }
    
    /**
     * Recursively finds the end of the list and adds an Element to the end
     * @param elt the Element to be added to the end of the list
     */
    public void recursiveAddLast(E elt){
        if( first != null ){
            recursiveAddLast(first, elt);
        }
        else
            first = new Node(elt, null);
    }
    
    /**
     * Helper method to find the end of the list and add an Element
     * @param elt the Element to be added to the end of the list
     * @param n a non-null Node
     */
    private void recursiveAddLast(Node n, E elt){
        if( n.next == null )
            n.next = new Node(elt, null);
        else
            recursiveAddLast(n.next, elt);
    }
    
    /**
     * Iterates through the list to get the last Element and remove it
     * @return the last Element 
     */
    public E removeLast(){
        if( first == null )
            return null;
        if( first.next == null ){
            E last = (E) first.data;
            first = null;
            return last;
        }
        Node n = first; //We already know first.next is not null
        while(n.next.next != null)
            n = n.next;
        E last = (E) n.next.data;
        n.next = null;
        return last;
    }
    
    /**
     * Recursively find the last Element in the list and removes it
     * @return the last Element
     */
    public E recursiveRemoveLast(){
        if( first == null )
            return null;
        if( first.next == null ){
            E last = (E) first.data;
            first = null;
            return last;
        }
        Node n = first; //We already know first.next is not null
        return recursiveRemoveLast(n);
    }
    
    /**
     * Helper method to recursively find the last element and remove it.
     * This method is only activated when the list has at least two elements.
     * @param n a non-null Node, where n.next is not null
     * @return the last Element
     */
    private E recursiveRemoveLast(Node n){
        if(n.next.next != null)
            return recursiveRemoveLast(n.next);
        else{ //if n.next.next is null, remove n.next
            E last = (E) n.next.data;
            n.next = null;
            return last;
        }
    }
    
    /**
     * MyLinkedList is made up of singly-linked Nodes.
     * The Node contains an Element data, and points to the next node.
     * @param <E> The element being stored in the Node
     */
    private class Node<E>{
        E data;
        Node next;
        
        Node(E data, Node next){
            this.data = data;
            this.next = next;
        }
    }
}
