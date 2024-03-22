package com.daniel.Model.Dados.Cidades.Vilas;

import com.daniel.Model.Dados.Cidades.Cidade;
import com.daniel.Model.Dados.Entidades.Inimigos.Desapoles.InimigoAbelha;
import com.daniel.Model.Dados.Entidades.Inimigos.Auroraville.InimigoBabySlime;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Armas.EspadaLuz;
import com.daniel.Model.Itens.Armas.Tridente;
import com.daniel.Model.Quests.QuestSlimeDeEscuridaoNv1;

import java.util.ArrayList;

public class CidadeMorta extends Cidade {
    public CidadeMorta() throws PlayerInexistenteException {
        super("CIDADE MORTA","/com.daniel.Images/Fundos/CidadeMorta.jpg", "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg",600);
        this.musicPath = "/com.daniel.audios/msc_cidadeMorta.wav";

        this.inimigos = new Inimigo[]{new InimigoBabySlime(), new InimigoAbelha()};
        this.itens.add(new Tridente());
        this.quests = new ArrayList<>();
        quests.add(new QuestSlimeDeEscuridaoNv1());
        this.dialogoCutscene = "E então o guerreiro seguiu sua jornada passando por uma cidade sombria e sem vida";
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
        this.botoes.add(criarBotaoSalvar());
    }
}
