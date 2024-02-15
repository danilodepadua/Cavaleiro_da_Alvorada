package com.daniel.Model.Taverna;


import com.daniel.game.Main;
import javafx.scene.image.Image;


public class Carta {
	//Estrutura basica das cartas de baralho do jogo
	private String nome;
	private String naipe;
	private int valor;
	private String imagem;

	public Carta(String nome, String naipe, int valor, String imagemDaCarta) {
		this.nome = nome;
		this.naipe = naipe;
		this.valor = valor;
		this.imagem = imagemDaCarta;
	}

	public String getNaipe() {
		return naipe;
	}

	public int getValor() {
		return valor;
	}

	public Image getImage(){
		return new Image (Main.class.getResource(imagem).toString());
	}

	public String getNome() {
		return nome;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

}
