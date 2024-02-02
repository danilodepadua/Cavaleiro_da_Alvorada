package com.daniel.Dados.CidadeRepositório.Cidades;

import com.daniel.Dados.CidadeRepositório.Cidade;
import com.daniel.Dados.EntidadesRepositório.Inimigos.*;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Armas.*;
import com.daniel.Modelo.Itens.Comidas.Pao;
import com.daniel.Modelo.Itens.Comidas.Soupa;
import com.daniel.Modelo.Itens.Mapas.MapaIlha;
import com.daniel.Modelo.Itens.Mapas.MapaPedraveira;
import com.daniel.Modelo.Itens.Pocoes.Cerveja;
import com.daniel.Modelo.Itens.Pocoes.PocaoCura;
import com.daniel.Modelo.Itens.Pocoes.PocaoMp;
import com.daniel.Modelo.Quests.*;

import java.util.ArrayList;

public class CidadePortuaria extends Cidade {

    public CidadePortuaria() throws PlayerInexistenteException{
        super("CIDADE PORTUÁRIA", "/com.daniel.Images/Fundos/CidadePortuaria.jpg",
                "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg");
        this.musicPath = "/com.daniel.audios/msc_cidadePortuaria.wav";

        this.inimigos = new Inimigo[]{new InimigoSlimeDeTerraNv2(), new InimigoSlimeDeRaioNv2(), new InimigoSlimeDeAguaNv3(), new InimigoLadrao(), new InimigoSlimeDeFogoNv3(), new InimigoSlimeDeEscuridaoNv3()};

        this.itens.add(new FoiceMagica());
        this.itens.add(new Machado());
        this.itens.add(new ManoplaTita());
        this.itens.add(new EspadaAperfeiçoada());
        this.itens.add(new EspadaSombriaBasica());
        this.itens.add(new EspadaDemoniaca());
        this.itens.add(new PocaoCura());
        this.itens.add(new PocaoMp());
        this.itens.add(new Pao());
        this.itens.add(new Soupa());
        this.itens.add(new Cerveja());
        this.itens.add(new MapaPedraveira());
        this.itens.add(new MapaIlha());
        this.quests.add(new QuestSlimeDeTerraNv2());
        this.quests.add(new QuestSlimeDeRaioNv2());
        this.quests.add(new QuestSlimeDeAguaNv3());
        this.quests.add(new QuestSlimeDeFogoNv3());
        this.quests.add(new QuestSlimeDeEscuridaoNv3());
        this.dialogoAtivo = true;
        this.dialogoCutscene = "\"Sou atormentado por uma coceira interminável por coisas distantes. Eu adoro navegar por mares proibidos (Moby Dick)\" - Herman Melville";
        ajustarBotoes();
    }

    @Override
    public void ajustarBotoes() throws PlayerInexistenteException {
        this.botoes = new ArrayList<>();
        this.botoes.add(criarBotaoViajar());
        this.botoes.add(criarBotaoCacar());
        this.botoes.add(criarBotaoLoja());
        this.botoes.add(criarBotaoQuest());
        this.botoes.add(criarBotaoSalvar());
        this.botoes.add(criarBotaoAnciao());
    }
}
