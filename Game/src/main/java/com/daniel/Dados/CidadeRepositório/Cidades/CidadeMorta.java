package com.daniel.Dados.CidadeRepositório.Cidades;

import com.daniel.Dados.CidadeRepositório.Cidade;
import com.daniel.Dados.EntidadesRepositório.Inimigos.InimigoAbelha;
import com.daniel.Dados.EntidadesRepositório.Inimigos.InimigoBabySlime;
import com.daniel.Dados.EntidadesRepositório.Inimigos.InimigoSlimeDeEscuridaoNv1;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Armas.EspadaLuz;
import com.daniel.Modelo.Itens.Armas.Tridente;
import com.daniel.Modelo.Quests.QuestSlimeDeEscuridaoNv1;

import java.util.ArrayList;

public class CidadeMorta extends Cidade {
    public CidadeMorta() throws PlayerInexistenteException {
        super("CIDADE MORTA","/com.daniel.Images/Fundos/CidadeMorta.jpg", "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg");
        this.musicPath = "/com.daniel.audios/msc_cidadeMorta.wav";

        this.inimigos = new Inimigo[]{new InimigoBabySlime(), new InimigoAbelha(), new InimigoSlimeDeEscuridaoNv1()};
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
        this.botoes.add(criarBotaoTaverna());
        this.botoes.add(criarBotaoSalvar());
    }
}
