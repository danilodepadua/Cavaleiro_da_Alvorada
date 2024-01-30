package com.daniel.PrimeiraCamada.Cidades;

import com.daniel.PrimeiraCamada.Cidade;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.*;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Calcas.CalcaPano;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacetes.CapacetePano;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais.PeitoralPano;
import com.daniel.PrimeiraCamada.Itens.Armas.EspadaInicial;
import com.daniel.PrimeiraCamada.Itens.Armas.EspadaSombriaAperfeicoada;
import com.daniel.PrimeiraCamada.Itens.Mapas.MapaDasópoles;
import com.daniel.PrimeiraCamada.Itens.Pocoes.*;
import com.daniel.PrimeiraCamada.Quests.*;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Quests.QuestBabySlime;
import com.daniel.PrimeiraCamada.Quests.QuestSnowMan;


import java.util.ArrayList;

public class CidadeInicial extends Cidade{
    public CidadeInicial() throws PlayerInexistenteException {
        super("Cidade Inicial", "/com.daniel.Images/Fundos/CidadeNoturna.jpg", "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg");

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
        this.itens.add(new EspadaSombriaAperfeicoada());
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
        // Adiciona botões específicos da CidadeInicial
        this.botoes.add(criarBotaoViajar());
        this.botoes.add(criarBotaoCacar());
        this.botoes.add(criarBotaoLoja());
        this.botoes.add(criarBotaoQuest());
        this.botoes.add(criarBotaoSalvar());
        this.botoes.add(criarBotaoAnciao());
    }
}
