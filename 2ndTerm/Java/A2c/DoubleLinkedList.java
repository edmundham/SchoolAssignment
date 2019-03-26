package ca.bcit.comp2526.a2c;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * DoubleLinkedList.java
 * Doubly Linked List class that implements linked list algorithm.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 * 
 * @param <E> can be any object
 */
public class DoubleLinkedList<E> implements Iterable<E>, Serializable {

    /**
     * generated serial version ID.
     */
    private static final long serialVersionUID = 1623876165767883229L;
    private Node head;
    private Node tail;
    private int size;
    
    /**
     * construct the doubly linked list with empty and null values.
     */
    public DoubleLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    private final class Node implements Serializable {
        
        /**
         * generated serial version ID.
         */
        private static final long serialVersionUID = 1623876165767883229L;
        private E data;
        private Node next;
        private Node previous;
        
        /**
         * constructs Node object with empty next and previous pointers.
         * 
         * @param e is used for any types
         */
        private Node(E e) {
            data = e;
            next = null;
            previous = null;
        }
    }
    
    /**
     * returns the size of doubly linked list.
     * 
     * @return size of doubly linked list
     */
    public int size() {
        return size;
    }
    
    /**
     * returns true if doubly linked list contains nothing.
     * 
     * @return boolean indicates if doubly linked lists is empty
     */
    public boolean isEmpty() {
        return (size == 0);
    }
    
    /**
     * gets the first Node in doubly linked list.
     * 
     * @return the first Node
     */
    public Node getFirst() {
        if (head == null) {
            return null;
        }
        return head;
    }
    
    /**
     * gets the last Node in doubly linked list.
     * 
     * @return the last Node
     */
    public Node getLast() {
        if (tail == null) {
            return null;
        }
        return tail;
    }
    
    /**
     * adds parameter to the doubly linked list.
     * 
     * @param e can be any types
     * @throws CouldNotAddException thrown when the parameter is null
     */
    public void addToFront(E e) throws CouldNotAddException {
        if (e == null) {
            throw new CouldNotAddException("Could not add to front");
        }
        Node temp = new Node(e);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            head.previous = temp;
            temp.next = head;
            head = temp;
        }
        size++;
    }
    
    /**
     * removes the front Node from the doubly linked list and returns the Node.
     * 
     * @return the Node that is removed and located at the front
     * @throws CouldNotRemoveException thrown 
     * when the doubly linked list is empty
     */
    public E removeFromFront() throws CouldNotRemoveException {
        if (head == null) {
            throw new CouldNotRemoveException("Could not remove from front");
        }
        Node temp = head;
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;            
        }
        size--;
        return temp.data;
    }
    
    /**
     * adds parameter to the doubly linked list.
     * 
     * @param e can be any types
     * @throws CouldNotAddException thrown when the parameter is null
     */
    public void addToEnd(E e) throws CouldNotAddException {
        if (e == null) {
            throw new CouldNotAddException("Could not add to end");
        }
        Node temp = new Node(e);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            temp.previous = tail;
            tail = temp;
        }
        size++;
    }
    
    /**
     * removes the end Node from the doubly linked list and returns the Node.
     * 
     * @return the Node that is removed and located at the end
     * @throws CouldNotRemoveException thrown 
     * when the doubly linked list is empty
     */
    public E removeFromEnd() throws CouldNotRemoveException {
        if (tail == null) {
            throw new CouldNotRemoveException("Could not remove from end");
        }
        Node temp = tail;
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;            
        }
        size--;
        return temp.data;
    }
    
    /**
     * iterates nodes in doubly linked list.
     * has 2 methods, hasNext which returns boolean 
     * and next which returns any types.
     * 
     * @return Iterator<E> of DoubleLinkedList
     */
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node current = head;
            private int index = size;
            
            public boolean hasNext() {
                return (current != null);
            }
            
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E result = current.data;
                current = current.next;
                index++;
                return result;
            }
        };
    }
}
