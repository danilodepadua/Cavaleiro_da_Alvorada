package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeGod extends Inimigo {
    public InimigoSlimeGod() {
        super("Slime primordial", "com.daniel.Images/Inimigos/Slime RPG King.png", 37, 45, 87, 10, 73, 4990, 49913, TiposElementais.NaoElemental, Comportamentos.padrao, 150000, 50000);this.magias.add(new Enfraquecer());
        this.magias.add(new Enfraquecer());
        this.magias.add(new Amolecer());
        this.magias.add(new Fortalecer());
        this.magias.add(new IntDown());
        this.magias.add(new Endurecer());
        this.magias.add(new IntUp());
        this.magias.add(new Silenciar());
        this.magias.add(new Dessilenciar());
        this.magias.add(new Fast());
        this.magias.add(new Slow());
        this.magias.add(new Stop());
        this.magias.add(new Veneno());
        this.magias.add(new Desenvenenar());
        this.magias.add(new Adormecer());
        this.magias.add(new Curaga());
        this.magias.add(new Cegar());
        this.magias.add(new Visao());
        this.magias.add(new Recuperar());
        this.magias.add(new Redemoinho());
        this.magias.add(new Explosao());
        this.magias.add(new Escuridao());
        this.magias.add(new Luz());
        this.magias.add(new Gelo());
        this.magias.add(new Raio());
        this.magias.add(new ParedeTerra());
        this.magias.add(new AirBlast());
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
    }
}
