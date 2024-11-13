package com.tercero.controller.tda.list;

//datos genéricos T E, K , V
//E significa que es un valor  genérico que se va a utilizar en la lista
public class Node <E>{
    private E data;
    private Node<E> next;

    public Node(E data) {
        this.data = data;
        this.next = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

}