package com.daniel.PrimeiraCamada.Cidades;

import com.daniel.PrimeiraCamada.Cidade;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.*;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Calcas.CalcaCouro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacetes.CapaceteCouro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais.PeitoralCouro;
import com.daniel.PrimeiraCamada.Itens.Armas.EspadaInicial;
import com.daniel.PrimeiraCamada.Itens.Armas.EspadaSombria;
import com.daniel.PrimeiraCamada.Itens.Pocoes.PocaoCura;
import com.daniel.PrimeiraCamada.Itens.Pocoes.PocaoMp;
import com.daniel.PrimeiraCamada.Itens.Pocoes.TonicoDeForca;
import com.daniel.PrimeiraCamada.Quests.*;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoAbelha;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoBabySlime;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoSlimeDeEscuridaoNv1;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Quests.QuestAbelha;
import com.daniel.PrimeiraCamada.Quests.QuestBabySlime;
import com.daniel.PrimeiraCamada.Quests.QuestCobraGigante;
import com.daniel.PrimeiraCamada.Quests.QuestSnowMan;
import com.daniel.game.Main;


import java.io.Serializable;
import java.util.ArrayList;

public class CidadeInicial extends Cidade{
    public CidadeInicial() throws PlayerInexistenteException {
        super("Cidade Inicial", "/com.daniel.Images/Fundos/CidadeNoturna.jpg", "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg");

        // Inicializa a lista de inimigos corretamente
        this.inimigos = new Inimigo[]{new InimigoBabySlime(), new InimigoAbelha(), new InimigoSlimeDeEscuridaoNv1()};

        // Adiciona quests à lista de quests disponíveis da cidade
        quests.add(new QuestAbelha());
        quests.add(new QuestBabySlime());
        quests.add(new QuestCobraGigante());
        quests.add(new QuestSnowMan());
        quests.add(new QuestTigerMan());

        // Adiciona os itens da loja
        this.itens.add(new EspadaInicial());
        this.itens.add(new PocaoCura());
        this.itens.add(new EspadaSombria());
        this.itens.add(new PocaoMp());
        this.itens.add(new TonicoDeForca());
        this.itens.add(new CalcaCouro());
        this.itens.add(new CapaceteCouro());
        this.itens.add(new PeitoralCouro());

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
        this.botoes.add(criarBotaoTaverna());
        this.botoes.add(criarBotaoSalvar());
    }
}
