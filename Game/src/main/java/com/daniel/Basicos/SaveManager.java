package com.daniel.Basicos;

import com.daniel.game.Main;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
public class SaveManager {
    Path CaminhoSave;
    public SaveManager(){
        String CaminhoAppData = System.getenv("AppData");

        CaminhoSave = Paths.get(CaminhoAppData, "..","Local", "NomeProvisorio", "Saves", "Save.dat").normalize();
        System.out.println("Caminho do diretório a ser criado: " + CaminhoSave.getParent());
        try {
            Files.createDirectories(CaminhoSave.getParent());
        }
        catch (IOException e){
            System.out.println("Não foi possivel criar o diretorio");
        }
    }
    public void Salvar() {
        Save save = new Save(Player.player);
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(CaminhoSave.toFile()));
            out.writeObject(save);
            System.out.println("Arquivo criado/atualizado com sucesso");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Falha ao salvar/atualizar arquivo");
        }
    }
    public void Carregar(){
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(CaminhoSave.toFile()));
            Save save = (Save) in.readObject();
            Player.player = save.player;
            System.out.println(Player.player.getName());
            System.out.println(save.player.getName());
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println("Falha ao carregar arquivo");
        }
    }
}
