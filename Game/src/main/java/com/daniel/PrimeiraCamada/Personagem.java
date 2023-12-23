package com.daniel.PrimeiraCamada;

import javafx.scene.image.Image;

import java.io.Serializable;

public abstract class Personagem implements Serializable {
    protected int HP = 0;
    protected int currentHP = 0;
    protected int MP = 0;
    protected int currentMP = 0;
    protected String Name = null;
    protected int Force = 0;
    protected int Velocity = 0;
    protected int MagicDef = 0;
    protected int Def = 0;
    protected int Inteligence = 0;
}
