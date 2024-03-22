package com.daniel.Model.Dados.Cidades.Vilas;

import com.daniel.Model.Dados.Cidades.Cidade;
import com.daniel.Model.Dados.Entidades.Inimigos.CidadeMorta.InimigoSlimeDeEscuridaoNv3;
import com.daniel.Model.Dados.Entidades.Inimigos.CidadePortuaria.InimigoLadrao;
import com.daniel.Model.Dados.Entidades.Inimigos.CidadePortuaria.InimigoSlimeDeFogoNv3;
import com.daniel.Model.Dados.Entidades.Inimigos.Ilha.InimigoSlimeDeAguaNv3;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Armas.*;
import com.daniel.Model.Itens.Mapas.MapaIlha;
import com.daniel.Model.Itens.Mapas.MapaPedraveira;
import com.daniel.Model.Itens.Pocoes.PocaoCura;
import com.daniel.Model.Itens.Pocoes.PocaoMp;
import com.daniel.Model.Quests.*;

import java.util.ArrayList;

public class CidadePortuaria extends Cidade {

    public CidadePortuaria() throws PlayerInexistenteException{
        super("CIDADE PORTUÁRIA", "/com.daniel.Images/Fundos/CidadePortuaria.jpg",
                "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg",700);
        this.musicPath = "/com.daniel.audios/msc_cidadePortuaria.wav";

        this.inimigos = new Inimigo[]{new InimigoSlimeDeAguaNv3(), new InimigoLadrao(), new InimigoSlimeDeFogoNv3(), new InimigoSlimeDeEscuridaoNv3()};

        this.itens.add(new FoiceMagica());
        this.itens.add(new Machado());
        this.itens.add(new EspadaAperfeiçoada());
        this.itens.add(new EspadaSombriaBasica());
        this.itens.add(new EspadaDemoniaca());
        this.itens.add(new PocaoCura());
        this.itens.add(new PocaoMp());
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
    }
}
