package com.daniel.Model.Dados.Cidades.Vilas;

import com.daniel.Model.Dados.Cidades.Cidade;
import com.daniel.Model.Dados.Entidades.Inimigos.Auroraville.*;
import com.daniel.Model.Dados.Entidades.Inimigos.Desapoles.InimigoAbelha;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Armaduras.Calcas.CalcaPano;
import com.daniel.Model.Itens.Armaduras.Capacetes.CapacetePano;
import com.daniel.Model.Itens.Armaduras.Peitorais.PeitoralPano;
import com.daniel.Model.Itens.Armas.EspadaInicial;
import com.daniel.Model.Itens.Mapas.MapaDasópoles;
import com.daniel.Model.Itens.Pocoes.*;
import com.daniel.Model.Quests.*;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Quests.QuestBabySlime;


import java.util.ArrayList;

public class Auroraville extends Cidade {
    public Auroraville() throws PlayerInexistenteException {
        super("AURORAVILLE", "/com.daniel.Images/Fundos/Fundo3.jpg",
                "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg", 50,null);
        this.musicPath = "/com.daniel.audios/msc_cidadeInicial.wav";

        // Inicializa a lista de inimigos corretamente
        //this.inimigos = new Inimigo[]{new InimigoBabySlime(), new InimigoAbelha(), new InimigoLadrao()};
        this.inimigos = new Inimigo[]{new InimigoBabySlime(), new InimigoAve1(),new InimigoAve2(),new InimigoAve3(),new InimigoJavali(), new InimigoSlimeNv3()};
        // Adiciona quests à lista de quests disponíveis da cidade
        this.quests.add(new QuestBabySlime());
        this.quests.add(new QuestAbelha());
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
        this.botoes.add(criarBotaoEstalagem());
        this.botoes.add(criarBotaoSalvar());
    }
}
