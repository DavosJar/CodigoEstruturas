package com.tercero.controller.tda.list;

import com.tercero.controller.excepcion.ListEmptyException;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class LinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private Integer size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * Metodo verifica si la lista esta vacia
     * 
     * @return
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Metodo que agrega un elemento header a la lista
     * 
     * @param data
     */
    public void addHeader(E data) {
        Node<E> aux = new Node<>(data);
        if (isEmpty()) {
            head = aux;
            tail = head;
        } else {
            aux.setNext(head);
            head = aux;
        }
        size++;
    }

    private void addTail(E data) {
        Node<E> aux = new Node<>(data);
        if (isEmpty()) {
            head = aux;
            tail = head;
        } else {
            tail.setNext(aux);
            tail = aux;
        }
        size++;
    }

    public void add(E data) {
        addTail(data);
    }

    /**
     * metodo que agrega un elemento en la posicion index
     * 
     * @param data
     * @param index
     * @throws ListEmptyException
     * @throws IndexOutOfBoundsException
     */
    public void add(E data, Integer index) throws ListEmptyException, IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        System.out.println("Agregando en índice: " + index + ", data: " + data);

        if (index == 0) {
            addHeader(data);
        } else if (index.intValue() == size) {
            addTail(data);
        } else {
            Node<E> search = getNode(index - 1);
            System.out.println("Nodo anterior encontrado: " + search.getData());

            Node<E> aux = new Node<>(data);
            aux.setNext(search.getNext());
            search.setNext(aux);
            size++;
        }
    }

    private Node<E> getNode(Integer index) throws ListEmptyException, IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ListEmptyException("La lista esta vacia");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        if (index == size - 1) {
            return tail;
        }
        Node<E> search = head;
        Integer count = 0;
        while (count < index) {
            search = search.getNext();
            count++;
        }
        return search;
    }

    public E get(Integer index) throws ListEmptyException, IndexOutOfBoundsException {
        return getNode(index).getData();
    }

    public void set(Integer index, E data) throws ListEmptyException, IndexOutOfBoundsException {
        getNode(index).setData(data);
    }

    public void reset() {
        head = null;
        tail = null;
        size = 0;
    }

    public E delete(Integer index) throws ListEmptyException, IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ListEmptyException("La lista esta vacia");
        } else if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        } else if (index == 0) {
            return deleteHeader();
        } else if (index == size - 1) {
            return deleteTail();
        } else {
            Node<E> prevNode = getNode(index - 1);
            Node<E> actualNode = getNode(index);
            E element = prevNode.getData();
            Node<E> nextNode = actualNode.getNext();
            actualNode = null;
            prevNode.setNext(nextNode);
            size--;
            return element;
        }
    }

    public E deleteHeader() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("La lista esta vacia");
        } else {
            E element = head.getData();
            Node<E> aux = head.getNext();
            head = aux;
            if (size == 1) {
                tail = null;
            }
            size--;
            return element;
        }
    }

    public E deleteTail() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("La lista esta vacia");
        } else {
            E element = tail.getData();
            Node<E> aux = getNode(size - 2);
            if (aux == null) {
                head = null;
                tail = null;
                if (size == 2) {
                    tail = head;
                } else {
                    head = null;
                }
            } else {
                tail = null;
                tail = aux;
                tail.setNext(null);
            }
            size--;
            return element;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> search = head;
        while (search != null) {
            sb.append(search.getData());
            if (search.getNext() != null) {
                sb.append(" => ");
            }
            search = search.getNext();
        }
        return sb.toString();
    }

    public void update(E data, Integer post) throws ListEmptyException, IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ListEmptyException("La lista esta vacia");
        }
        if (post < 0 || post >= size) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        } else if (post == 0) {
            head.setData(data);
        } else if (post == size - 1) {
            tail.setData(data);
        } else {
            Node<E> search = head;
            Integer count = 0;
            while (count < post) {
                count++;
                search = search.getNext();
            }
            search.setData(data);
        }
    }

    public LinkedList<E> order() throws Exception {
        if (!isEmpty()) {
            E data = this.head.getData();
            if (data instanceof Number || data instanceof String) {
                E[] lista = this.toArray();
                reset();
                for (int i = 1; i < lista.length; i++) {
                    E aux = lista[i];
                    int j = i - 1;
                    while (j >= 0 && compare(lista[j], aux)) {
                        lista[j + 1] = lista[j--];
                    }
                    lista[j + 1] = aux;
                }
                this.toList(lista);
            }
        }
        return this;
    }

    public LinkedList<E> mergeOrder() throws Exception {
        if (this.size > 1) {
            E[] lista = this.toArray();
            lista = mergeSort(lista);
            return this.toList(lista);
        }
        return this;
    }

    private E[] mergeSort(E[] lista) throws Exception {
        if (lista.length <= 1) {
            return lista;
        }
        int mid = lista.length / 2;
        E[] izquierda = (E[]) new Object[mid];
        E[] derecha = (E[]) new Object[lista.length - mid];

        System.arraycopy(lista, 0, izquierda, 0, mid);
        System.arraycopy(lista, mid, derecha, 0, lista.length - mid);

        izquierda = mergeSort(izquierda);
        derecha = mergeSort(derecha);
        return merge(izquierda, derecha);
    }

    private E[] merge(E[] izquierda, E[] derecha) throws Exception {
        E[] resultado = (E[]) new Object[izquierda.length + derecha.length];
        Integer indexIzquierda = 0;
        Integer indexDerecha = 0;
        Integer indexResultante = 0;

        while (indexIzquierda < izquierda.length && indexDerecha < derecha.length) {
            if (compare(izquierda[indexIzquierda], derecha[indexDerecha])) {
                resultado[indexResultante++] = izquierda[indexIzquierda++];
            } else {
                resultado[indexResultante++] = derecha[indexDerecha++];
            }
        }

        while (indexIzquierda < izquierda.length) {
            resultado[indexResultante++] = izquierda[indexIzquierda++];
        }

        while (indexDerecha < derecha.length) {
            resultado[indexResultante++] = derecha[indexDerecha++];
        }

        return resultado;
    }

    private Boolean compare(E a, E b) {
        if (a instanceof Number) {
            Number a1 = (Number) a;
            Number b1 = (Number) b;
            return a1.doubleValue() > b1.doubleValue();
        } else {
            return (a.toString()).compareTo(b.toString()) > 0;
        }
    }

    public E[] toArray() {
        E[] matrix = null;
        if (!isEmpty()) {

            Class clazz = head.getData().getClass();
            matrix = (E[]) java.lang.reflect.Array.newInstance(clazz, size);
            Node<E> aux = head;
            for (int i = 0; i < size; i++) {
                matrix[i] = aux.getData();
                aux = aux.getNext();
            }
        }
        return matrix;
    }

    public LinkedList<E> toList(E[] matrix) {
        reset();
        for (E matrix1 : matrix) {
            add(matrix1);
        }
        return this;
    }

}