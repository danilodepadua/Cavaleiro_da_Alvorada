package com.daniel.Dados.CidadeRepositório.Cidades;

import com.daniel.Dados.CidadeRepositório.Cidade;
import com.daniel.Dados.EntidadesRepositório.Inimigos.*;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Armaduras.Calcas.CalcaMalha;
import com.daniel.Modelo.Itens.Armaduras.Capacetes.CapaceteMalha;
import com.daniel.Modelo.Itens.Armaduras.Peitorais.PeitoralMalha;
import com.daniel.Modelo.Itens.Armas.*;
import com.daniel.Modelo.Itens.Mapas.MapaPortuaria;
import com.daniel.Modelo.Itens.Pocoes.PocaoCura;
import com.daniel.Modelo.Itens.Pocoes.PocaoMp;
import com.daniel.Modelo.Itens.Pocoes.TonicoDeForca;
import com.daniel.Modelo.Quests.*;

import java.util.ArrayList;

public class MonteClaro extends Cidade {
    public MonteClaro() throws PlayerInexistenteException {
        super("MONTE CLARO", "/com.daniel.Images/Fundos/FundoCanyon.jpg",
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
        // Adiciona botões específicos da Auroraville
        this.botoes.add(criarBotaoViajar());
        this.botoes.add(criarBotaoCacar());
        this.botoes.add(criarBotaoLoja());
        this.botoes.add(criarBotaoQuest());
        this.botoes.add(criarBotaoSalvar());
        this.botoes.add(criarBotaoAnciao());
    }
}
