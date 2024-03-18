package com.daniel.Model.Dados.Cidades.Vilas;

import com.daniel.Model.Dados.Cidades.Cidade;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Dados.Entidades.Inimigos.Viloes.InimigoSlimeDeGeloNv3;
import com.daniel.Model.Dados.Entidades.Inimigos.Viloes.InimigoSnowMan;
import com.daniel.Model.Dados.Entidades.Inimigos.Viloes.InimigoTRex;
import com.daniel.Model.Dados.Entidades.Inimigos.Viloes.InimigoTigerMan;
import com.daniel.Model.Itens.Armaduras.Calcas.CalcaFerro;
import com.daniel.Model.Itens.Armaduras.Capacetes.CapaceteFerro;
import com.daniel.Model.Itens.Armaduras.Peitorais.PeitoralFerro;
import com.daniel.Model.Itens.Armas.EspadaGeloAperfeicoada;
import com.daniel.Model.Itens.Armas.EspadaGeloBasica;
import com.daniel.Model.Itens.Mapas.MapaCidadeMorta;
import com.daniel.Model.Quests.*;

import java.util.ArrayList;

public class MontanhaDoNorte extends Cidade {

    public MontanhaDoNorte() throws PlayerInexistenteException {
        super("MONTANHA DO NORTE","/com.daniel.Images/Fundos/Montanha do norte.jpg",
                "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg");
        this.inimigos = new Inimigo[]{new InimigoSnowMan(), new InimigoTRex(),
                new InimigoTigerMan(), new InimigoSlimeDeGeloNv3()};

        this.musicPath = "/com.daniel.audios/msc_montanhaDoNorte.wav";

        // Adiciona quests à lista de quests disponíveis da cidade
        this.itens.add(new EspadaGeloBasica());
        this.itens.add(new EspadaGeloAperfeicoada());
        this.itens.add(new CapaceteFerro());
        this.itens.add(new PeitoralFerro());
        this.itens.add(new CalcaFerro());
        this.itens.add(new MapaCidadeMorta());
        this.quests.add(new QuestSnowMan());
        this.quests.add(new QuestTRex());
        this.quests.add(new QuestTigerMan());
        this.quests.add(new QuestSlimeDeGeloNv3());

        quests.add(new QuestSlimeDeEscuridaoNv1());
        this.dialogoCutscene = "E então o guerreiro seguiu sua jornada passando por uma cidade sombria e sem vida";
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
