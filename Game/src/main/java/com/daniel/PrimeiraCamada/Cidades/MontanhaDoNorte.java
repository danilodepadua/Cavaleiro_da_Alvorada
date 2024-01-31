package com.daniel.PrimeiraCamada.Cidades;

import com.daniel.PrimeiraCamada.Cidade;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.*;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Calcas.CalcaFerro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacetes.CapaceteFerro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais.PeitoralFerro;
import com.daniel.PrimeiraCamada.Itens.Armas.EspadaGeloAperfeicoada;
import com.daniel.PrimeiraCamada.Itens.Armas.EspadaGeloBasica;
import com.daniel.PrimeiraCamada.Itens.Mapas.MapaCidadeMorta;
import com.daniel.PrimeiraCamada.Itens.Mapas.MapaPedraveira;
import com.daniel.PrimeiraCamada.Quests.*;

import java.util.ArrayList;

public class MontanhaDoNorte extends Cidade {

    public MontanhaDoNorte() throws PlayerInexistenteException {
        super("Montanha Do Norte","/com.daniel.Images/Fundos/Montanha do norte.jpg", "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg");
        this.inimigos = new Inimigo[]{new InimigoSnowMan(), new InimigoTRex(), new InimigoTigerMan(), new InimigoSlimeDeGeloNv3()};
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
        this.botoes.add(criarBotaoTaverna());
        this.botoes.add(criarBotaoSalvar());
        this.botoes.add(criarBotaoAnciao());
    }
}
