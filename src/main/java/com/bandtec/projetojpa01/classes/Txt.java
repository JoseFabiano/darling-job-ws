package com.bandtec.projetojpa01.classes;

import com.bandtec.projetojpa01.dominio.Contratado;
import com.bandtec.projetojpa01.dominio.Contrato;
import com.bandtec.projetojpa01.dominio.Endereco;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Txt {
    public void gravaRegistro(String nomeArq, String registro) {
        BufferedWriter saida = null;
        // Abre o arquivo
        try {
            saida = new BufferedWriter (new FileWriter(nomeArq, true));
        }
        catch (IOException erro) {
            System.out.println("Erro na abertura do arquivo: " +
                    erro.getMessage());
        }

        // Grava o registro e finaliza
        try {
            saida.append(registro + "\n");
            saida.close();
        }
        catch (IOException erro) {
            System.out.println("Erro na gravação do arquivo: " +
                    erro.getMessage());
        }

    }

    public void gravaArquivoTxt(List<Contrato> lista, String nomeArq) {

        int contaRegistro = 0;

        // Monta o registro de header
        String header = "00PROPOSTAS2021";
        Date dataDeHoje = new Date();
        SimpleDateFormat formataData =
                new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        header += formataData.format(dataDeHoje);
        header += "01";

        // Grava o registro do header
        gravaRegistro(nomeArq, header);

        // Monta e grava o corpo
        String corpo;
        for (Contrato c : lista) {
            corpo = "02";
            corpo += String.format("%03d",c.getId());
            corpo += String.format("%03d", c.getIdContratada());
            corpo += String.format("%03d", c.getIdContratante());
            corpo += String.format("%-15.15s", c.getCategoria());
            corpo += String.format("%-30.30s", c.getEndereco());
            corpo += String.format("%-15.15s", c.getData());
            corpo += String.format("%-10.10s", c.getHora());
            corpo += String.format("%-10.10s", c.getValor());

            gravaRegistro(nomeArq,corpo);
            contaRegistro++;
        }

        // Monta e grava o trailer
        String trailer = "01";
        trailer += String.format("%010d", contaRegistro);
        gravaRegistro(nomeArq,trailer);

    }

    public List<Contrato> leArquivoTxt(String nomeArq) {
        BufferedReader entrada = null;

        String registro, tipoRegistro, categoria, endereco, data, hora, valor;
        int id, idContratada, idContratante, qtdRegGravados, contaRegDados = 0;

        List<Contrato> listaLida = new ArrayList<>();

        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        }
        catch (IOException erro) {
            System.out.println("Erro na abertura do arquivo: " +
                    erro.getMessage());
        }

        try {
            assert entrada != null;
            registro = entrada.readLine();

            while (registro != null) {

                tipoRegistro = registro.substring(0,2);

                if (tipoRegistro.equals("00")) {
                    System.out.println("Eh um header");
                    System.out.println("Tipo do arquivo: " + registro.substring(2,6));
                    System.out.println("Ano/semestre: " + registro.substring(6,11));
                    System.out.println("Data e hora de gravação: " + registro.substring(11,30));
                    System.out.println("Versão do documento: " + registro.substring(30,32));
                }
                else if (tipoRegistro.equals("01")) {
                    System.out.println("Eh um trailer");

                    qtdRegGravados = Integer.parseInt(registro.substring(2,12));

                    if (qtdRegGravados == contaRegDados) {
                        System.out.println("Quantidade de registros lidos compatível com quantidade de registros gravados");
                    }
                    else {
                        System.out.println("Quantidade de registros lidos incompatível com quantidade de registros gravados");
                    }
                }
                else if (tipoRegistro.equals("02")) {
                    System.out.println("Eh um registro de corpo");

                    idContratada = Integer.parseInt(registro.substring(5, 8));
                    idContratante = Integer.parseInt(registro.substring(8, 11));
                    categoria = registro.substring(11, 26).trim();
                    endereco = registro.substring(26, 56).trim();
                    data = registro.substring(56, 71).trim();
                    hora = registro.substring(71, 81).trim();
                    valor = registro.substring(81, 91).trim();

                    Contrato contrato = new Contrato(null, idContratada, idContratante, categoria, endereco, data, hora, valor);

                    listaLida.add(contrato);

                    contaRegDados++;
                }
                else {
                    System.out.println("Tipo de registro inválido");
                }

                registro = entrada.readLine();
            }

            entrada.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao ler arquivo: " + erro.getMessage());
        }

        System.out.println("\nConteúdo lido do arquivo:");
        for (Contrato a : listaLida) {
            System.out.println(a);
        }

        return listaLida;
    }
}
