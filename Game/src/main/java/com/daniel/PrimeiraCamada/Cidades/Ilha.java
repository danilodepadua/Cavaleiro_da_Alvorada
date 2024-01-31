package com.daniel.PrimeiraCamada.Cidades;

import com.daniel.PrimeiraCamada.Cidade;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoAbelha;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoBabySlime;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoSlimeDeEscuridaoNv1;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Armas.EspadaFogoBasica;
import com.daniel.PrimeiraCamada.Itens.Armas.EspadaGeloAperfeicoada;
import com.daniel.PrimeiraCamada.Quests.QuestSlimeDeEscuridaoNv1;

import java.util.ArrayList;

public class Ilha extends Cidade {
    public Ilha() throws PlayerInexistenteException {
        super("Ilha","/com.daniel.Images/Fundos/Ilha.jpg", "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg");
        this.inimigos = new Inimigo[]{new InimigoBabySlime(), new InimigoAbelha(), new InimigoSlimeDeEscuridaoNv1()};
        // Adiciona quests à lista de quests disponíveis da cidade
        this.quests = new ArrayList<>();
        this.itens.add(new EspadaFogoBasica());
        this.itens.add(new EspadaGeloAperfeicoada());

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
