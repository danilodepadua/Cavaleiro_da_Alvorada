package com.daniel.Model.Dados.Cidades.Vilas;

import com.daniel.Model.Dados.Cidades.Cidade;
import com.daniel.Model.Dados.Entidades.Inimigos.Bosses.BossIlha;
import com.daniel.Model.Dados.Entidades.Inimigos.Ilha.*;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Armas.EspadaFogoBasica;
import com.daniel.Model.Itens.Armas.EspadaSombriaBasica;

import java.util.ArrayList;

public class Ilha extends Cidade {
    public Ilha() throws PlayerInexistenteException {
        super("ILHA","/com.daniel.Images/Fundos/Ilha.jpg",
                "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg",500, new BossIlha());

        this.musicPath = "/com.daniel.audios/msc_ilha.wav";
        this.inimigos = new Inimigo[]{new InimigoAbismo(), new InimigoCarangueijo(), new InimigoGolenTartaruga(), new InimigoSereia1(), new InimigoSereia2(), new InimigoSereia3(), new InimigoSlimeDeAguaNv3()};
        // Adiciona quests à lista de quests disponíveis da cidade
        this.quests = new ArrayList<>();
        this.itens.add(new EspadaFogoBasica());
        this.itens.add(new EspadaSombriaBasica());

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
        this.botoes.add(criarBotaoSalvar());
    }
}
