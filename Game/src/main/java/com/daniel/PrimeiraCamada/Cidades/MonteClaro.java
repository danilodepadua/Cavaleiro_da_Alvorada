package com.daniel.PrimeiraCamada.Cidades;

import com.daniel.PrimeiraCamada.Cidade;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.*;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Calcas.CalcaCouro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Calcas.CalcaMalha;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacetes.CapaceteCouro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacetes.CapaceteMalha;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais.PeitoralCouro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais.PeitoralMalha;
import com.daniel.PrimeiraCamada.Itens.Armas.*;
import com.daniel.PrimeiraCamada.Itens.Mapas.MapaPortuaria;
import com.daniel.PrimeiraCamada.Itens.Pocoes.PocaoCura;
import com.daniel.PrimeiraCamada.Itens.Pocoes.PocaoMp;
import com.daniel.PrimeiraCamada.Itens.Pocoes.TonicoDeForca;
import com.daniel.PrimeiraCamada.Quests.*;

import java.util.ArrayList;

public class MonteClaro extends Cidade {
    public MonteClaro() throws PlayerInexistenteException {
        super("Monte Claro", "/com.daniel.Images/Fundos/FundoCanyon.jpg",
                "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg");
        this.musicPath = "/com.daniel.audios/msc_monteClaro.wav";

        this.inimigos = new Inimigo[]{new InimigoSlimeDeFogoNv2(), new InimigoSlimeDeAguaNv2(), new InimigoSlimeDeGeloNv2(), new InimigoLadrao(), new InimigoSlimeDeLuzNv2(), new InimigoSlimeDeVentoNv2()};

        // Adiciona os itens da loja
        this.itens.add(new EspadaEletricaBasica());
        this.itens.add(new PocaoCura());
        this.itens.add(new EspadaAperfeiçoada());
        this.itens.add(new PocaoMp());
        this.itens.add(new TonicoDeForca());
        this.itens.add(new CapaceteMalha());
        this.itens.add(new PeitoralMalha());
        this.itens.add(new CalcaMalha());
        this.itens.add(new MapaPortuaria());
        this.quests.add(new QuestSlimeDeFogoNv2());
        this.quests.add(new QuestSlimeDeAguaNv2());
        this.quests.add(new QuestSlimeDeGeloNv2());
        this.quests.add(new QuestSlimeDeLuzNv2());
        this.quests.add(new QuestSlimeDeVentoNv2());

        this.dialogoAtivo = true;
        this.dialogoCutscene = "Você se aproxima de uma antiga cidade seca e montanhosa conhecida desde de a antiguidade, com um povo forte e sobrevivente";
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
