package com.bandtec.projetojpa01.classes;

import com.bandtec.projetojpa01.dominio.Contratado;
import com.bandtec.projetojpa01.dominio.Contratante;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Csv {
    public static void gravaArquivoContratado (ListaObj<Contratado> lista, String nomeArq) {
        FileWriter arq = null;
        Formatter saida = null;
        Boolean deuRuim = false;
        nomeArq += ".csv";

        try {
            arq = new FileWriter(nomeArq,false);
            saida = new Formatter(arq);
        }
        catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }
        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                Contratado contratado = lista.getElemento(i);
                saida.format("%d;%s;%s;%s\n",contratado.getIdContratado(), contratado.getNome(),
                        contratado.getEmail(), contratado.getHorarioInicio());
            }
        }
        catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar no arquivo");
            deuRuim = true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }
    public static void gravaArquivoContratante(ListaObj<Contratante> lista, String nomeArq) {
        FileWriter arq = null;
        Formatter saida = null;
        Boolean deuRuim = false;
        nomeArq += ".csv";

        try {
            arq = new FileWriter(nomeArq,false);
            saida = new Formatter(arq);
        }
        catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }
        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                Contratante contratante = lista.getElemento(i);
                saida.format("%d;%s;%s;%s\n",contratante.getIdContratante(), contratante.getNome(),
                        contratante.getEmail(), contratante.getDataNascimento());
            }
        }
        catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar no arquivo");
            deuRuim = true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }
    public static void leExibeArquivoContratado (String nomeArq) {
        FileReader arq = null;  // objeto que representa o arquivo para leitura
        Scanner entrada = null; // objeto usado para ler do arquivo
        Boolean deuRuim = false;
        nomeArq += ".csv";

        // Bloco try-catch para abrir o arquivo
        try {
            arq = new FileReader(nomeArq);
            /* Cria o objeto do Scanner, informando que o delimitador é
               o ';' OU o '\n'  */
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        }
        catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }

        // Bloco try-catch para ler do arquivo
        try {
            System.out.printf("%4s %-15s %-30s %-25s\n", "ID", "NOME", "EMAIL", "DIA LIVRE");
            while (entrada.hasNext()) {  //enquanto não for final do arquivo
                Integer id = entrada.nextInt();
                String nome = entrada.next();
                String email = entrada.next();
                String data = entrada.next();
                System.out.printf("%4d %-15s %-30s %-25s\n", id, nome, email, data);
            }
        }
        catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            deuRuim = true;
        }
        catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        }
        finally {
            entrada.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }

    }

    public static void leExibeArquivoContratante (String nomeArq) {
        FileReader arq = null;  // objeto que representa o arquivo para leitura
        Scanner entrada = null; // objeto usado para ler do arquivo
        Boolean deuRuim = false;
        nomeArq += ".csv";

        // Bloco try-catch para abrir o arquivo
        try {
            arq = new FileReader(nomeArq);
            /* Cria o objeto do Scanner, informando que o delimitador é
               o ';' OU o '\n'  */
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        }
        catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }

        // Bloco try-catch para ler do arquivo
        try {
            System.out.printf("%4s %-15s %-30s %-25s\n", "ID", "NOME", "EMAIL", "DATA NASCIMENTO");
            while (entrada.hasNext()) {  //enquanto não for final do arquivo
                Integer id = entrada.nextInt();
                String nome = entrada.next();
                String email = entrada.next();
                String data = entrada.next();
                System.out.printf("%4d %-15s %-30s %-25s\n", id, nome, email, data);
            }
        }
        catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            deuRuim = true;
        }
        catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        }
        finally {
            entrada.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }

    }
}
