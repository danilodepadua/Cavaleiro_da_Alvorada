package com.daniel.Dados.CidadeRepositório.Cidades;

import com.daniel.Dados.CidadeRepositório.Cidade;
import com.daniel.Dados.EntidadesRepositório.Inimigos.*;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Armaduras.Calcas.CalcaCouro;
import com.daniel.Modelo.Itens.Armaduras.Capacetes.CapaceteCouro;
import com.daniel.Modelo.Itens.Armaduras.Peitorais.PeitoralCouro;
import com.daniel.Modelo.Itens.Armas.*;
import com.daniel.Modelo.Itens.Mapas.MapaMonteClaro;
import com.daniel.Modelo.Itens.Pocoes.PocaoCura;
import com.daniel.Modelo.Itens.Pocoes.PocaoMp;
import com.daniel.Modelo.Itens.Pocoes.TonicoDeForca;
import com.daniel.Modelo.Quests.*;

import java.util.ArrayList;

public class Dasópoles extends Cidade {
    public Dasópoles() throws PlayerInexistenteException {
        super("DASÓPOLES", "/com.daniel.Images/Fundos/Dasopoles.jpg",
                "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg");

        this.musicPath = "/com.daniel.audios/msc_dasopoles.wav";

        this.inimigos = new Inimigo[]{new InimigoSlimeDeFogoNv1(), new InimigoSlimeDeFogoNv2(), new InimigoSlimeDeGeloNv1(), new InimigoSlimeDeTerraNv1(), new InimigoSlimeDeLuzNv1(), new InimigoSlimeDeAguaNv2()};
        this.quests.add(new QuestSlimeDeFogoNv1());
        this.quests.add(new QuestSlimeDeFogoNv2());
        this.quests.add(new QuestSlimeDeGeloNv1());
        this.quests.add(new QuestSlimeDeLuzNv1());
        this.quests.add(new QuestSlimeDeAguaNv2());
        // Adiciona os itens da loja
        this.itens.add(new PocaoCura());
        this.itens.add(new EspadaAperfeiçoada());
        this.itens.add(new EspadaFogoBasica());

        this.itens.add(new PocaoMp());
        this.itens.add(new TonicoDeForca());
        this.itens.add(new MapaMonteClaro());
        this.itens.add(new CapaceteCouro());
        this.itens.add(new PeitoralCouro());
        this.itens.add(new CalcaCouro());
        this.dialogoAtivo = true;
        this.dialogoCutscene = "Saindo de sua cidade natal, você se depara com uma antiga cidade que antes costumava ser amigável";
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
