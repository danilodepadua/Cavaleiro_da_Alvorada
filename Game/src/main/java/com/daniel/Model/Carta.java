package com.daniel.Model;


import com.daniel.game.Main;
import javafx.scene.image.Image;


public class Carta {
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNaipe(String naipe) {
		this.naipe = naipe;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

}
