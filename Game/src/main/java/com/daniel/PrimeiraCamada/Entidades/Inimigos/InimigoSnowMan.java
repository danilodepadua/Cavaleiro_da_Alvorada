package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSnowMan extends Inimigo {
    public InimigoSnowMan() {
        super("Abominavel boneco das neves", "/com.daniel.Images/Inimigos/Xmas Snowman.png", 34, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, TiposElementais.Gelo, Comportamentos.padrao);
    }
}
