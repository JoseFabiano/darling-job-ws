package com.bandtec.projetojpa01.classes;

public class ListaObj <U>{
    private U[] vetor;
    private int nroElem;

    public ListaObj(int tamanho) {
        vetor = (U[]) new Object[tamanho];
        nroElem = 0;
    }


    public boolean adiciona(U elemento) {
        if (nroElem >= vetor.length) {
            System.out.println("Lista está cheia");
            return false;
        }
        vetor[nroElem++] = elemento;
        return true;
    }

    public int getTamanho() {
        return nroElem;
    }

    public U getElemento(int indice) {
        if (indice < 0 || indice >= nroElem) {
            return null;
        }
        return vetor[indice];
    }

}
