package com.daniel.Model.Dados.Save;


import com.daniel.Model.Dados.Cidades.Cidade;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Exceptions.SaveInexistenteException;
import com.daniel.game.Main;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
public class SaveManager {
    Path CaminhoSave;
    String CaminhoAppData;
    public SaveManager(){
        CaminhoAppData = System.getenv("AppData");
        CaminhoSave = Paths.get(CaminhoAppData, "..","Local", "NomeProvisorio", "Saves").normalize();
        try {
            Files.createDirectories(CaminhoSave.getParent());
        }
        catch (IOException e){
            System.out.println("Não foi possivel criar o diretorio");
        }
    }
    public void Salvar(int num) throws PlayerInexistenteException {
        Save save = new Save(Player.getPlayer(), Main.cidadeAtual);
        String fileName = "Save"+ num +".dat";
        Path caminhoSave = Paths.get(CaminhoSave.toString(), fileName);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(caminhoSave.toFile()))) {
            out.writeObject(save);
            System.out.println("Arquivo criado/atualizado com sucesso");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Falha ao salvar/atualizar arquivo: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro inesperado ao salvar/atualizar arquivo: " + e.getMessage());
        }
    }
    public Save Carregar(int num) throws SaveInexistenteException {
        try{
            String fileName = "Save"+ num +".dat";
            Path caminhoSave = Paths.get(CaminhoSave.toString(), fileName);
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(caminhoSave.toFile()));
            Save save = (Save) in.readObject();
            in.close();
            return save;
        }
        catch (IOException | ClassNotFoundException e){
            throw new SaveInexistenteException();
        }
    }
    public boolean SaveExistente(int num){
        String fileName = "Save"+ num +".dat";
        Path caminhoSave = Paths.get(CaminhoSave.toString(), fileName);
        boolean existe = Files.exists(caminhoSave);
        System.out.println("Existe: " + existe);
        return existe;
    }
    public void carregarAdmin(Path filePath) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath.toFile()))) {
            // Ler o objeto do arquivo
            Save save = (Save) in.readObject();

            // Processar os dados carregados
            for (Cidade c : save.player.getCidadesConehcidas()) {
                c.ajustarBotoes();
            }
            Player.setPlayer(save.player);
            save.cidade.ajustarBotoes();
            Main.cidadeAtual = save.cidade;
            System.out.println(Player.getPlayer().getNome());
            System.out.println(save.player.getNome());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Falha ao carregar arquivo");
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
    }
    public void Delete(int Num) throws IOException {
        String fileName = "Save" + Num + ".dat";
        Path caminhoSave = Paths.get(CaminhoSave.toString(), fileName);
        File file = caminhoSave.toFile();
        System.out.println("Caminho do arquivo: " + file);

        try {
            if (file.delete()) {
                System.out.println("Arquivo excluído com sucesso.");
            } else {
                System.out.println("Falha ao excluir o arquivo.");
            }
        } catch (SecurityException e) {
            System.err.println("Erro de segurança ao excluir o arquivo: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro ao excluir o arquivo: " + e.getMessage());
        }
    }
}
