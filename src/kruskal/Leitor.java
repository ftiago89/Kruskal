/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Felipe
 */
public class Leitor {
    private int nVertices;
    private ArrayList<int[]> arestas;
    private String nomeArquivo;

    public Leitor(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        leArquivo();
    }
    
    private void leArquivo() {
        arestas = new ArrayList<>();
        String linha = null;
        String[] aux = null;
        int i = 0;
        int j = 0;
        int cArestas = 0;
        int[] aresta = new int[3];

        try {
            FileReader r = new FileReader(nomeArquivo);
            BufferedReader buffer = new BufferedReader(r);

            linha = buffer.readLine();
            nVertices = Integer.parseInt(linha);
            System.out.println(linha);

            while ((linha = buffer.readLine()) != null) {
                j = i + 1;
                //System.out.println(linha);
                aux = linha.split(" ");

                for (int k = 0; k < aux.length; ++k) {
                    arestas.add(new int[3]);
                    arestas.get(cArestas)[0] = i;
                    arestas.get(cArestas)[1] = j;
                    arestas.get(cArestas)[2] = Integer.parseInt(aux[k]);
                    ++cArestas;
                    ++j;
                }
                ++i;
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Erro na leitura do arquivo.");
        } catch (IOException ex) {
            System.err.println("Erro na leitura da linha do arquivo.");
        }
    }

    public int getnVertices() {
        return nVertices;
    }

    public ArrayList<int[]> getArestas() {
        return arestas;
    }

    public void teste() {
        for(int[] array: arestas){
            for (int i = 0; i < array.length; ++i){
                System.out.print(array[i]);
                System.out.print(" ");
            }
        }
    }
}
