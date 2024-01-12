package com.daniel.PrimeiraCamada.Cidades;

import com.daniel.PrimeiraCamada.Cidade;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoAbelha;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoBabySlime;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoTigerMan;
import com.daniel.PrimeiraCamada.Inimigo;

public class CidadeInicial extends Cidade {
    public CidadeInicial(){
        super("Cidade Inicial", "/com.daniel.Images/CidadeNoturna.jpg", "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg");
        this.inimigos = new Inimigo[]{new InimigoBabySlime(), new InimigoAbelha(), new InimigoTigerMan()};
    }
}
