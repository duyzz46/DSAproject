/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duytran.dsaproject;

/**
 *
 * @author duytran
 */
import java.util.NoSuchElementException;

public class Queue<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void offer(E element) {
        Node<E> newNode = new Node<>(element, null);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    public E poll() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E element = front.element;
        front = front.next;
        size--;
        if (isEmpty()) {
            rear = null;
        }
        return element;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return front.element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(E element) {
        Node<E> current = front;
        while (current != null) {
            if (current.element.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}