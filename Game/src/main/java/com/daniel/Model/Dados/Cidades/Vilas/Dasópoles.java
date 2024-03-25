package com.daniel.Model.Dados.Cidades.Vilas;

import com.daniel.Model.Dados.Cidades.Cidade;
import com.daniel.Model.Dados.Entidades.Inimigos.Bosses.BossDesapolis;
import com.daniel.Model.Dados.Entidades.Inimigos.Desapoles.*;
import com.daniel.Model.Dados.Entidades.Inimigos.Ilha.InimigoAbismo;
import com.daniel.Model.Dados.Entidades.Inimigos.Ilha.InimigoSereia1;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Armaduras.Calcas.CalcaCouro;
import com.daniel.Model.Itens.Armaduras.Capacetes.CapaceteCouro;
import com.daniel.Model.Itens.Armaduras.Peitorais.PeitoralCouro;
import com.daniel.Model.Itens.Armas.*;
import com.daniel.Model.Itens.Mapas.MapaMonteClaro;
import com.daniel.Model.Itens.Pocoes.PocaoCura;
import com.daniel.Model.Itens.Pocoes.PocaoMp;
import com.daniel.Model.Itens.Pocoes.TonicoDeForca;
import com.daniel.Model.Quests.*;

import java.util.ArrayList;

public class Dasópoles extends Cidade {
    public Dasópoles() throws PlayerInexistenteException {
        super("DASÓPOLES", "/com.daniel.Images/Fundos/Dasopoles.jpg",
                "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg",200, new BossDesapolis());

        this.musicPath = "/com.daniel.audios/msc_dasopoles.wav";

        this.inimigos = new Inimigo[]{new InimigoAbelha(), new InimigoCoelhoBandido(),new InimigoGoblin1(),new InimigoGoblin2(),new InimigoGoblin3(),new InimigoGoblin4(),new InimigoGoblin5(), new InimigoLobisomen(), new InimigoSlimeDeVentoNv3()};
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
        this.dialogoCutscene = new TextoNode(
        "Saindo de sua cidade natal, você se depara com uma antiga cidade que antes costumava ser amigável","Leaving your hometown, you come across an old town that used to be friendly").getTexto();
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
