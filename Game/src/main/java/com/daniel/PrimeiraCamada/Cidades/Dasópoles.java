package com.daniel.PrimeiraCamada.Cidades;

import com.daniel.PrimeiraCamada.Cidade;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.*;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Calcas.CalcaCouro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacetes.CapaceteCouro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais.PeitoralCouro;
import com.daniel.PrimeiraCamada.Itens.Armas.*;
import com.daniel.PrimeiraCamada.Itens.Mapas.MapaMonteClaro;
import com.daniel.PrimeiraCamada.Itens.Pocoes.PocaoCura;
import com.daniel.PrimeiraCamada.Itens.Pocoes.PocaoMp;
import com.daniel.PrimeiraCamada.Itens.Pocoes.TonicoDeForca;
import com.daniel.PrimeiraCamada.Quests.*;

import java.util.ArrayList;

public class Dasópoles extends Cidade {
    public Dasópoles() throws PlayerInexistenteException {
        super("Dasópoles", "/com.daniel.Images/Fundos/Dasopoles.jpg",
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
