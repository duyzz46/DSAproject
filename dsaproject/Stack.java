/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duytran.dsaproject;

/**
 *
 * @author duytran
 */
import java.util.EmptyStackException;

public class Stack<E> {
    private E[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[10];
        size = 0;
    }

    public void push(E element) {
        if (size == elements.length) {
            resize(2 * elements.length);
        }
        elements[size++] = element;
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E element = elements[--size];
        elements[size] = null;
        if (size > 0 && size == elements.length / 4) {
            resize(elements.length / 2);
        }
        return element;
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int capacity) {
        @SuppressWarnings("unchecked")
        E[] newElements = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
}
