package com.daniel.Model.Dados.Cidades.Vilas;

import com.daniel.Model.Dados.Cidades.Botao;
import com.daniel.Model.Dados.Cidades.Cidade;
import com.daniel.Model.Dados.Entidades.Inimigos.Bosses.BossCidadeMorta;
import com.daniel.Model.Dados.Entidades.Inimigos.CidadeMorta.*;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Armas.EspadaLuz;
import com.daniel.Model.Itens.Armas.Tridente;
import com.daniel.game.Main;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.ArrayList;

public class CidadeMorta extends Cidade {
    public CidadeMorta() throws PlayerInexistenteException {
        super("CIDADE MORTA","/com.daniel.Images/Fundos/CidadeMorta.jpg", "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg",600, new BossCidadeMorta());
        this.musicPath = "/com.daniel.audios/msc_cidadeMorta.wav";

        this.inimigos = new Inimigo[]{new InimigoAboboraCavalheira(), new InimigoArvoreMorta(), new InimigoBruxinha(), new InimigoCobraGigante(), new InimigoCogumelo(), new InimigoCorvoMorto(), new InimigoEsqueleto(),new InimigoLoboMorto(), new InimigoMosquito(), new InimigoSangueSuga(), new InimigoSapo1(), new InimigoSapo2(), new InimigoSapo3(), new InimigoSlimeDeEscuridaoNv3(), new InimigoVampiro(), new InimigoZumbi()};
        this.itens.add(new Tridente());
        this.quests = new ArrayList<>();
        this.dialogoCutscene = new TextoNode(
        "E então o guerreiro seguiu sua jornada passando por uma cidade sombria e sem vida","And then the warrior went on his journey through a dark and lifeless city").getTexto();
        this.dialogoAtivo = true;
        this.itens.add(new EspadaLuz());

        ajustarBotoes();
    }
    @Override
    public void ajustarBotoes() throws PlayerInexistenteException {
        this.botoes = new ArrayList<>();
        this.botoes.add(criarBotaoViajar());
        this.botoes.add(criarBotaoCacar());
        this.botoes.add(criarBotaoLoja());
        this.botoes.add(criarBotaoQuest());
        this.botoes.add(criarBotaoEstalagem());
        if(Player.getPlayer().getLvl()>20){
            this.botoes.add(new Botao("Caverna",()->{
                try {
                    Main.cidadeAtual = new Caverna();
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
        this.botoes.add(criarBotaoSalvar());
    }
}
