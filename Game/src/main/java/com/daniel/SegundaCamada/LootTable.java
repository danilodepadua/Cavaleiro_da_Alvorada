package com.daniel.SegundaCamada;

import com.daniel.PrimeiraCamada.Itens.Item;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;

public class LootTable implements Serializable {
    ArrayList<LootEntry> itensDropaveis = new ArrayList<>();

    public void AdicionarEntrada(Item item, int Min, int Max, double Probabilidade){
        itensDropaveis.add(new LootEntry(item, Min, Max, Probabilidade));
    }
    public ArrayList<Item> drop() {
        Random rand = new Random();
        ArrayList<Item> drops = new ArrayList<>();
        for(LootEntry entrada : itensDropaveis){
            int quant = entrada.quantidade[0];
            for(int i = 0; i< entrada.quantidade[1] - entrada.quantidade[0]; i++){
                double chance = rand.nextDouble(0,1);
                if(chance< entrada.probabilidade){
                    quant++;
                }
            }
            try {
                drops.add(entrada.item.getClass().getDeclaredConstructor(int.class).newInstance(quant));
            }
            catch (Exception e) {
                e.printStackTrace(); // Trate a exceção adequadamente na prática
                return null;
            }
        }
        return drops;
    }
}

class LootEntry implements Serializable{
    protected Item item;
    protected int[] quantidade = new int[2];
    protected double probabilidade;

    protected LootEntry(Item item, int Min, int Max, double Probabilidade){
        this.item = item;
        this.quantidade[0] = Min;
        this.quantidade[1] = Max;
        this.probabilidade = Math.max(0, Math.min(1, Probabilidade));
    }
}
