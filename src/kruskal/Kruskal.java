/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author felipe
 */
public class Kruskal {
    private ArrayList<int[]> arestas;
    private ArrayList<int[]> solucao;
    private ArrayList<Set<Integer>> florestas;
    private int nVertices;

    public Kruskal(int nVertices, ArrayList<int[]> arestas){
        this.arestas = arestas;
        this.nVertices = nVertices;
        this.florestas = new ArrayList<>();
        this.solucao = new ArrayList<>();
    }
    
    public void run(){
        makeSet();
        //ordena as arestas de acordo com seu peso
        arestas.sort(Comparator.comparing(a -> a[2]));
        
        for (int[] a: arestas){
            if ((findSet(a[0])) != (findSet(a[1]))){
                unirSets(findSet(a[0]), findSet(a[1]));
                solucao.add(a);
            }
        }
        for(int[] array: solucao){
            for (int i = 0; i < array.length; ++i){
                System.out.print(array[i]);
                System.out.print(" ");
            }
            System.out.print(" -> ");
        }
        
    }
    
    private void makeSet(){
        for (int i = 0; i < nVertices; ++i){
            HashSet aux = new HashSet<>();
            florestas.add(aux);
            aux.add(i);
        }
    }
    
    private Set<Integer> findSet(int u){
        for (Set<Integer> set: florestas){
            if (set.contains(u)) return set;
        }
        return null;
    }
    
    private void unirSets(Set<Integer> u, Set<Integer> v){
        u.addAll(v);
        florestas.remove(v);
    }
    
    
}
