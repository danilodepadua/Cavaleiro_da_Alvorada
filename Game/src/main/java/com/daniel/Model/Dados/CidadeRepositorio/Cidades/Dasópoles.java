package com.daniel.Model.Dados.CidadeRepositorio.Cidades;

import com.daniel.Model.Dados.CidadeRepositorio.Cidade;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Dados.Entidades.Inimigos.Viloes.*;
import com.daniel.Model.Dados.Itens.Armaduras.Calcas.CalcaCouro;
import com.daniel.Model.Dados.Itens.Armaduras.Capacetes.CapaceteCouro;
import com.daniel.Model.Dados.Itens.Armaduras.Peitorais.PeitoralCouro;
import com.daniel.Model.Dados.Itens.Armas.*;
import com.daniel.Model.Dados.Itens.Mapas.MapaMonteClaro;
import com.daniel.Model.Dados.Itens.Pocoes.PocaoCura;
import com.daniel.Model.Dados.Itens.Pocoes.PocaoMp;
import com.daniel.Model.Dados.Itens.Pocoes.TonicoDeForca;
import com.daniel.Model.Dados.Quests.*;

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
