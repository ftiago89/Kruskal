/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskal;



/**
 *
 * @author felipe
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Leitor leitor = new Leitor("dij10.txt");
        Kruskal kruskal = new Kruskal(leitor.getnVertices(), leitor.getArestas());
        kruskal.run();
    }
    
}
