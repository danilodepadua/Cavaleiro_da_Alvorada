package com.daniel.Dados.CidadeRepositório.Cidades;

import com.daniel.Dados.CidadeRepositório.Cidade;
import com.daniel.Dados.EntidadesRepositório.Inimigos.InimigoAbelha;
import com.daniel.Dados.EntidadesRepositório.Inimigos.InimigoBabySlime;
import com.daniel.Dados.EntidadesRepositório.Inimigos.InimigoSlimeDeEscuridaoNv1;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Armas.EspadaFogoBasica;
import com.daniel.Modelo.Itens.Armas.EspadaSombriaBasica;
import com.daniel.Modelo.Quests.QuestSlimeDeEscuridaoNv1;

import java.util.ArrayList;

public class Ilha extends Cidade {
    public Ilha() throws PlayerInexistenteException {
        super("ILHA","/com.daniel.Images/Fundos/Ilha.jpg",
                "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg");

        this.musicPath = "/com.daniel.audios/msc_ilha.wav";
        this.inimigos = new Inimigo[]{new InimigoBabySlime(), new InimigoAbelha(), new InimigoSlimeDeEscuridaoNv1()};
        // Adiciona quests à lista de quests disponíveis da cidade
        this.quests = new ArrayList<>();
        this.itens.add(new EspadaFogoBasica());
        this.itens.add(new EspadaSombriaBasica());

        quests.add(new QuestSlimeDeEscuridaoNv1());
        ajustarBotoes();
    }
    @Override
    public void ajustarBotoes() throws PlayerInexistenteException {
        this.botoes = new ArrayList<>();
        this.botoes.add(criarBotaoViajar());
        this.botoes.add(criarBotaoCacar());
        this.botoes.add(criarBotaoLoja());
        this.botoes.add(criarBotaoQuest());
        this.botoes.add(criarBotaoTaverna());
        this.botoes.add(criarBotaoSalvar());
    }
}
