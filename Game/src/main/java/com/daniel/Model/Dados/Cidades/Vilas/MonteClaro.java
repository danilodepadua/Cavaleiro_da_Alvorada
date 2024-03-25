package com.daniel.Model.Dados.Cidades.Vilas;

import com.daniel.Model.Dados.Cidades.Cidade;
import com.daniel.Model.Dados.Entidades.Inimigos.Bosses.BossMonteClaro;
import com.daniel.Model.Dados.Entidades.Inimigos.CidadePortuaria.InimigoLadrao;
import com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro.*;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Armaduras.Calcas.CalcaMalha;
import com.daniel.Model.Itens.Armaduras.Capacetes.CapaceteMalha;
import com.daniel.Model.Itens.Armaduras.Peitorais.PeitoralMalha;
import com.daniel.Model.Itens.Armas.*;
import com.daniel.Model.Itens.Mapas.MapaPortuaria;
import com.daniel.Model.Itens.Pocoes.PocaoCura;
import com.daniel.Model.Itens.Pocoes.PocaoMp;
import com.daniel.Model.Itens.Pocoes.TonicoDeForca;
import com.daniel.Model.Quests.*;

import java.util.ArrayList;

public class MonteClaro extends Cidade {
    public MonteClaro() throws PlayerInexistenteException {
        super("MONTE CLARO", "/com.daniel.Images/Fundos/FundoCanyon.jpg",
                "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg",500, new BossMonteClaro());
        this.musicPath = "/com.daniel.audios/msc_monteClaro.wav";

        this.inimigos = new Inimigo[]{new InimigoTigerMan(), new InimigoChimera(), new InimigoTouroDragao(), new InimigoTRex(), new InimigoWereBear(), new InimigoUrso(), new InimigoSlimeDeTerraNv3(), new InimigoSlimeDeLuzNv3(), new InimigoHarpia(), new InimigoCorvoGigante(), new InimigoDragao(), new InimigoFetero(), new InimigoGrifo(), new InimigoLobo(), new InimigoMinhocaTerra()};

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

        this.dialogoAtivo = true;
        this.dialogoCutscene = new TextoNode(
        "Você se aproxima de uma antiga cidade seca e montanhosa conhecida desde de a antiguidade, com um povo forte e sobrevivente","You approach an ancient dry and mountainous city known since antiquity, with a strong and surviving people").getTexto();
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
        this.botoes.add(criarBotaoEstalagem());
        this.botoes.add(criarBotaoSalvar());
    }
}
