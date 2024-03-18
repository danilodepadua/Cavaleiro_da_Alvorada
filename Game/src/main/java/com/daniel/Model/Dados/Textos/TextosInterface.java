package com.daniel.Model.Dados.Textos;

public class TextosInterface {
    // Tela saves
    private static final TextoNode NovoJogo = new TextoNode("Novo jogo", "New game");
    private static final TextoNode Carregar = new TextoNode("Carregar", "Load");
    private static final TextoNode Deletar = new TextoNode("Deletar", "Delete");

    //Tela inicial
    private static final TextoNode Jogar = new TextoNode("Jogar", "Play");

    //Geral
    private static final TextoNode Salvar = new TextoNode("Salvar", "Save");
    private static final TextoNode Sair = new TextoNode("Sair", "Quit");
    private static final TextoNode Creditos = new TextoNode("Creditos", "Credits");
    private static final TextoNode Titulo = new TextoNode("O cavaleiro da alvorada", "The knight of dawn");
    private static final TextoNode Equipar = new TextoNode("Equipar", "Equip");
    private static final TextoNode Desquipar = new TextoNode("Desquipar", "Unequip");
    private static final TextoNode Usar = new TextoNode("Usar", "Use");
    private static final TextoNode AtqM = new TextoNode("Ataque mágico", "Magic attack");
    private static final TextoNode AtqF = new TextoNode("Ataque físico", "Physical attack");
    private static final TextoNode DefM = new TextoNode("Defesa mágica", "Magic defense");
    private static final TextoNode DefF = new TextoNode("Defesa física", "Physical Defense");
    private static final TextoNode Cabeca = new TextoNode("Cabeça", "Head");
    private static final TextoNode Corpo = new TextoNode("Corpo", "Body");
    private static final TextoNode Pernas = new TextoNode("Pernas", "Legs");
    private static final TextoNode Armas = new TextoNode("Arma", "Weapon");
    private static final TextoNode Nivel = new TextoNode("Nivel:", "Level:");
    private static final TextoNode Fra = new TextoNode("Fraquezas", "Weaknesses");
    private static final TextoNode Res = new TextoNode("Resistências", "Resistances");
    private static final TextoNode Imu = new TextoNode("Imunidades", "Immunities");
    private static final TextoNode Abs = new TextoNode("Absorções", "Absorptions");
    private static final TextoNode Cassino = new TextoNode("Cassino", "Casino");
    private static final TextoNode Carteira = new TextoNode("Carteira: ", "Wallet: ");
    private static final TextoNode Memoria = new TextoNode("Memoria", "Memory");
    private static final TextoNode Taverna = new TextoNode("Taverna", "Inn");
    private static final TextoNode Descancar = new TextoNode("Descaçar", "Rest");
    private static final TextoNode Minerios = new TextoNode("Minérios", "Ores");
    private static final TextoNode Evoluir = new TextoNode("Evoluir", "Evolution");

    //Craft
    private static final TextoNode Criacao = new TextoNode("Criação de itens", "Items creation");

    private static final TextoNode Quantidade = new TextoNode("Quantidade", "Quantity");
    private static final TextoNode Prob = new TextoNode("Probabilidade de sucesso:", "Chance of Success:");
    private static final TextoNode Forjar = new TextoNode("Forjar", "forge");
    private static final TextoNode Forja = new TextoNode("Forja", "forge");

    //Conficurações
    private static final TextoNode Config = new TextoNode("Configurações", "Settings");
    private static final TextoNode Resolucao = new TextoNode("RESOLUÇÃO:", "RESOLUTION:");
    private static final TextoNode Idioma = new TextoNode("IDIOMA:", "LANGUAGE:");
    private static final TextoNode VelTxtBtl = new TextoNode("VEL. TEXTO BATALHA:", "BATTLE TEXT SPEED:");

    //Cidades
    private static final TextoNode Viajar = new TextoNode("Viajar", "Travel");
    private static final TextoNode Cacar = new TextoNode("Caçar", "Hunt");
    private static final TextoNode Loja = new TextoNode("Loja", "Shop");
    private static final TextoNode Vender = new TextoNode("Vender", "Sell");
    private static final TextoNode Comprar = new TextoNode("Comprar", "Buy");

    //Batalha
    private static final TextoNode Atacar = new TextoNode("Atacar", "Attack");
    private static final TextoNode Fugir = new TextoNode("Fugir", "Run");
    private static final TextoNode Magia = new TextoNode("Magia", "Magic");
    private static final TextoNode Item = new TextoNode("Itens", "Items");
    private static final TextoNode Recolher = new TextoNode("Recolher", "Colect");

    //Status

    private static final TextoNode Forca = new TextoNode("Força", "Strength");
    private static final TextoNode Resis = new TextoNode("Resistência", "Resistence");
    private static final TextoNode Inteli = new TextoNode("Inteligência", "Inteligence");
    private static final TextoNode Sorte = new TextoNode("Sorte", "Luck");
    private static final TextoNode Vel = new TextoNode("Velocidade", "Speed");
    private static final TextoNode Nome = new TextoNode("Nome", "Name");
    private static final TextoNode Criar = new TextoNode("Criar", "Create");
    private static final TextoNode CriarPerso = new TextoNode("Criação de personagem", "Character creation");
    private static final TextoNode Pontos = new TextoNode("Pontos", "Points");
    public static String getCacar() {
        return Cacar.getTexto();
    }

    public static String getAtacar() {
        return Atacar.getTexto();
    }

    public static String getCarregar() {
        return Carregar.getTexto();
    }

    public static String getComprar() {
        return Comprar.getTexto();
    }

    public static String getConfig() {
        return Config.getTexto();
    }

    public static String getDeletar() {
        return Deletar.getTexto();
    }

    public static String getIdioma() {
        return Idioma.getTexto();
    }

    public static String getJogar() {
        return Jogar.getTexto();
    }

    public static String getFugir() {
        return Fugir.getTexto();
    }

    public static String getItem() {
        return Item.getTexto();
    }

    public static String getLoja() {
        return Loja.getTexto();
    }

    public static String getMagia() {
        return Magia.getTexto();
    }

    public static String getNovoJogo() {
        return NovoJogo.getTexto();
    }

    public static String getResolucao() {
        return Resolucao.getTexto();
    }

    public static String getSalvar() {
        return Salvar.getTexto();
    }

    public static String getVelTxtBtl() {
        return VelTxtBtl.getTexto();
    }

    public static String getVender() {
        return Vender.getTexto();
    }

    public static String getViajar() {
        return Viajar.getTexto();
    }

    public static String getSair() {
        return Sair.getTexto();
    }

    public static String getCreditos() {
        return Creditos.getTexto();
    }

    public static String getTitulo() {
        return Titulo.getTexto();
    }

    public static String getCriar() {
        return Criar.getTexto();
    }

    public static String getCriarPerso() {
        return CriarPerso.getTexto();
    }

    public static String getForca() {
        return Forca.getTexto();
    }

    public static String getInteli() {
        return Inteli.getTexto();
    }

    public static String getNome() {
        return Nome.getTexto();
    }

    public static String getResis() {
        return Resis.getTexto();
    }

    public static String getSorte() {
        return Sorte.getTexto();
    }

    public static String getVel() {
        return Vel.getTexto();
    }

    public static String getPontos() {
        return Pontos.getTexto();
    }

    public static String getDesquipar() {
        return Desquipar.getTexto();
    }

    public static String getEquipar() {
        return Equipar.getTexto();
    }

    public static String getRecolher() {
        return Recolher.getTexto();
    }

    public static String getUsar() {
        return Usar.getTexto();
    }

    public static String getAtqF() {
        return AtqF.getTexto();
    }

    public static String getAtqM() {
        return AtqM.getTexto();
    }

    public static String getDefF() {
        return DefF.getTexto();
    }

    public static String getDefM() {
        return DefM.getTexto();
    }

    public static String getArmas() {
        return Armas.getTexto();
    }

    public static String getCabeca() {
        return Cabeca.getTexto();
    }

    public static String getCorpo() {
        return Corpo.getTexto();
    }

    public static String getCriacao() {
        return Criacao.getTexto();
    }

    public static String getForjar() {
        return Forjar.getTexto();
    }

    public static String getNivel() {
        return Nivel.getTexto();
    }

    public static String getPernas() {
        return Pernas.getTexto();
    }

    public static String getProb() {
        return Prob.getTexto();
    }

    public static String getQuantidade() {
        return Quantidade.getTexto();
    }

    public static String getForja() {
        return Forja.getTexto();
    }

    public static String getAbs() {
        return Abs.getTexto();
    }

    public static String getFra() {
        return Fra.getTexto();
    }

    public static String getImu() {
        return Imu.getTexto();
    }

    public static String getRes() {
        return Res.getTexto();
    }
    public static String getCassino() {
        return Cassino.getTexto();
    }
    public static String getCarteira() {
        return Carteira.getTexto();
    }
    public static String getMemoria() {
        return Memoria.getTexto();
    }
    public static String getTaverna() {
        return Taverna.getTexto();
    }
    public static String getDescancar() {
        return Descancar.getTexto();
    }
    public static String getEvolucao() {
        return Evoluir.getTexto();
    }
    public static String getMinerios() {
        return Minerios.getTexto();
    }
}

