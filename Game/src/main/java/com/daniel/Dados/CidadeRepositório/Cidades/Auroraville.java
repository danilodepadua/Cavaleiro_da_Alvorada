package com.daniel.Dados.CidadeRepositório.Cidades;

import com.daniel.Dados.CidadeRepositório.Cidade;
import com.daniel.Dados.EntidadesRepositório.Inimigos.*;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Armaduras.Calcas.CalcaPano;
import com.daniel.Modelo.Itens.Armaduras.Capacetes.CapacetePano;
import com.daniel.Modelo.Itens.Armaduras.Peitorais.PeitoralPano;
import com.daniel.Modelo.Itens.Armas.EspadaInicial;
import com.daniel.Modelo.Itens.Mapas.MapaDasópoles;
import com.daniel.Modelo.Itens.Pocoes.*;
import com.daniel.Modelo.Quests.*;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Modelo.Quests.QuestBabySlime;


import java.util.ArrayList;

public class Auroraville extends Cidade{
    public Auroraville() throws PlayerInexistenteException {
        super("AURORAVILLE", "/com.daniel.Images/Fundos/Fundo3.jpg",
                "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg");
        this.musicPath = "/com.daniel.audios/msc_cidadeInicial.wav";

        // Inicializa a lista de inimigos corretamente
        this.inimigos = new Inimigo[]{new InimigoBabySlime(), new InimigoAbelha(), new InimigoSlimeDeAguaNv1(), new InimigoSlimeDeEscuridaoNv1(), new InimigoSlimeDeRaioNv1(), new InimigoLadrao()};

        // Adiciona quests à lista de quests disponíveis da cidade
        this.quests.add(new QuestBabySlime());
        this.quests.add(new QuestAbelha());
        this.quests.add(new QuestSlimeDeAguaNv1());
        this.quests.add(new QuestSlimeDeEscuridaoNv1());
        this.quests.add(new QuestSlimeDeRaioNv1());
        // Adiciona os itens da loja
        this.itens.add(new EspadaInicial());
        this.itens.add(new PocaoCura());
        this.itens.add(new PocaoMp());
        this.itens.add(new TonicoDeForca());
        this.itens.add(new CapacetePano());
        this.itens.add(new PeitoralPano());
        this.itens.add(new CalcaPano());
        this.itens.add(new MapaDasópoles());



        ajustarBotoes();
    }

    @Override
    public void ajustarBotoes() throws PlayerInexistenteException {

        this.botoes = new ArrayList<>();
        // Adiciona botões específicos da Auroraville
        this.botoes.add(criarBotaoViajar());
        this.botoes.add(criarBotaoCacar());
        this.botoes.add(criarBotaoLoja());
        this.botoes.add(criarBotaoQuest());
        this.botoes.add(criarBotaoSalvar());
        this.botoes.add(criarBotaoAnciao());
    }
}
