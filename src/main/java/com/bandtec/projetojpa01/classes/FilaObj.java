package com.bandtec.projetojpa01.classes;

public class FilaObj<T> {

    private int tamanho;
    private T[] fila;

    public FilaObj(int capacidade) {
        tamanho = 0;
        fila = (T[]) new Object[capacidade];
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == fila.length;
    }

    public void add(T element) {
        if (isFull()) {
            System.out.println("Fila cheia.");
        }
        else {
            fila[tamanho++] = element;
        }
    }

    public T peek() {
        return fila[0];
    }

    public T poll() {
        T primeiro = fila[0];

        if (!isEmpty()) {
            for (int i = 0; i < tamanho-1; i++) {
                fila[i] = fila[i+1];
            }
            fila[tamanho-1] = null;
            tamanho--;
        }

        return primeiro;
    }

    public void exibe() {
        if (isEmpty()) {
            System.out.println("A fila está vazia");
        }
        else {
            System.out.println("\nElementos da fila:");
            for (int i = 0; i < tamanho; i++) {
                System.out.println(fila[i]);
            }
        }
    }

}
