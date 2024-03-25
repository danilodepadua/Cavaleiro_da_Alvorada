package com.daniel.Model.Dados.Cidades.Vilas;

import com.daniel.Model.Dados.Cidades.Botao;
import com.daniel.Model.Dados.Cidades.Cidade;
import com.daniel.Model.Dados.Entidades.Inimigos.Bosses.BossCidadePortuaria;
import com.daniel.Model.Dados.Entidades.Inimigos.CidadePortuaria.*;
import com.daniel.Model.Dados.Entidades.Inimigos.Ilha.InimigoSlimeDeAguaNv3;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Armas.*;
import com.daniel.Model.Itens.Pocoes.PocaoCura;
import com.daniel.Model.Itens.Pocoes.PocaoMp;
import com.daniel.Model.Quests.*;
import com.daniel.game.Main;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.ArrayList;

public class CidadePortuaria extends Cidade {

    public CidadePortuaria() throws PlayerInexistenteException{
        super("CIDADE PORTUÁRIA", "/com.daniel.Images/Fundos/CidadePortuaria.jpg",
                "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg",700, new BossCidadePortuaria());
        this.musicPath = "/com.daniel.audios/msc_cidadePortuaria.wav";

        this.inimigos = new Inimigo[]{new InimigoSlimeDeAguaNv3(), new InimigoLadrao(), new InimigoSlimeDeFogoNv3(), new InimigoPirata(),new InimigoCapitao(), new InimigoAvePirata(), new InimigoMacacoPirata()};

        this.itens.add(new EspadaAperfeiçoada());
        this.itens.add(new EspadaSombriaBasica());
        this.itens.add(new EspadaDemoniaca());
        this.itens.add(new PocaoCura());
        this.itens.add(new PocaoMp());
        this.quests.add(new QuestSlimeDeAguaNv3());
        this.quests.add(new QuestSlimeDeFogoNv3());
        this.quests.add(new QuestSlimeDeEscuridaoNv3());
        this.dialogoAtivo = true;
        this.dialogoCutscene = new TextoNode(
        "\"Sou atormentado por uma coceira interminável por coisas distantes. Eu adoro navegar por mares proibidos (Moby Dick)\" - Herman Melville","\"I'm plagued by an endless itch for distant things. I love sailing the forbidden seas (Moby Dick)\" - Herman Melville").getTexto();
        ajustarBotoes();
    }

    @Override
    public void ajustarBotoes() throws PlayerInexistenteException {
        this.botoes = new ArrayList<>();
        this.botoes.add(criarBotaoViajar());
        this.botoes.add(criarBotaoCacar());
        this.botoes.add(criarBotaoLoja());
        this.botoes.add(criarBotaoEstalagem());
        if(Player.getPlayer().getLvl()>10){
            this.botoes.add(new Botao("Ilha",()->{
                try {
                    Main.cidadeAtual = new Ilha();
                } catch (PlayerInexistenteException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Main.ChangeScene(new FXMLLoader(Main.class.getResource("/com/daniel/game/TelaLoad.fxml")).load());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }));
        }
        this.botoes.add(criarBotaoQuest());
        this.botoes.add(criarBotaoSalvar());
    }
}
