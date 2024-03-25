package com.daniel.Model.Dados.Cidades.Vilas;

import com.daniel.Model.Dados.Cidades.Cidade;
import com.daniel.Model.Dados.Entidades.Inimigos.Bosses.BossMontanhaDoNorte;
import com.daniel.Model.Dados.Entidades.Inimigos.Bosses.BossMonteClaro;
import com.daniel.Model.Dados.Entidades.Inimigos.Especiais.InimigoSlimeGod;
import com.daniel.Model.Dados.Entidades.Inimigos.Especiais.InimigoSlimeRei;
import com.daniel.Model.Dados.Entidades.Inimigos.MontanhaDoNorte.*;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro.InimigoTRex;
import com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro.InimigoTigerMan;
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
                "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg",800, new BossMontanhaDoNorte());
        this.inimigos = new Inimigo[]{new InimigoAveGelada(), new InimigoDragaoBranco(), new InimigoGolemDeGelo(), new InimigoGorila(), new InimigoSlimeDeGeloNv3(), new InimigoSnowMan(), new InimigoTouroDeGelo(),new InimigoSlimeRei(), new InimigoSlimeGod()};

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

        this.dialogoCutscene = new TextoNode(
        "E então o guerreiro seguiu sua jornada passando por uma cidade sombria e sem vida","And then the warrior went on his journey through a dark and lifeless city.").getTexto();
        ajustarBotoes();
    }

    @Override
    public void ajustarBotoes() throws PlayerInexistenteException {
        this.botoes = new ArrayList<>();
        this.botoes.add(criarBotaoViajar());
        this.botoes.add(criarBotaoCacar());
        this.botoes.add(criarBotaoLoja());
        this.botoes.add(criarBotaoQuest());
        this.botoes.add(criarBotaoEstalagem());
        this.botoes.add(criarBotaoSalvar());
    }
}
