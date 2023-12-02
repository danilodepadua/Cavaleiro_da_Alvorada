package com.mygdx.dados;

public class Dialogos {
    String[] Falas;
    public Dialogos(String[] F){
        Falas = F;
    }
    public void adicionarDialogo(String S){
        for(int i = 0; i<Falas.length; i++){
            if(Falas[i] == null) {
                Falas[i] = S;
                break;
            }
            if(i== Falas.length-1){
                System.out.println("Número maximo de falas atingido");
            }
        }
    }
}
