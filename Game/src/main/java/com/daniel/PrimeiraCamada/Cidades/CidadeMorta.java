package com.daniel.PrimeiraCamada.Cidades;

import com.daniel.PrimeiraCamada.Cidade;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoAbelha;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoBabySlime;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoSlimeDeEscuridaoNv1;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Armas.EspadaLuz;
import com.daniel.PrimeiraCamada.Itens.Armas.Tridente;
import com.daniel.PrimeiraCamada.Quests.QuestSlimeDeEscuridaoNv1;

import java.util.ArrayList;

public class CidadeMorta extends Cidade {
    public CidadeMorta() throws PlayerInexistenteException {
        super("Cidade morta","/com.daniel.Images/Fundos/Montanha do norte.jpg", "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg");
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
