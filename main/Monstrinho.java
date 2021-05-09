package main;

import java.util.ArrayList;
import java.util.List;

public class Monstrinho {
	
	private String nome;
	private String tipo;
	private double vida;
	private double forca;
	private double defesa;
	private double velocidade;
	private boolean desmaiado;
	
	public Monstrinho(String nome, String tipo, double vida, double forca, double defesa, double velocidade) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.vida = vida;
		this.forca = forca;
		this.defesa = defesa;
		this.velocidade = velocidade;
		this.desmaiado = false;
	}

	public static List<Monstrinho> getMonstrinhos() {
		
		Monstrinho m1 = new Monstrinho("Charmander", "Fire", 25000, 4000, 7000, 35);
		Monstrinho m2 = new Monstrinho("Ho-Oh", "Fire", 40000, 10000, 6000, 40);
		Monstrinho m3 = new Monstrinho("Vulpix", "Fire", 20000, 3000, 5000, 50);
		Monstrinho m4 = new Monstrinho("Magmar", "Fire", 50000, 5000, 4000, 25);
		
		Monstrinho m5 = new Monstrinho("Pikachu", "Eletric", 20000, 7000, 8000, 40);
		Monstrinho m6 = new Monstrinho("Ampharos", "Eletric", 50000, 9000, 10000, 35);
		Monstrinho m7 = new Monstrinho("Dedenne", "Eletric", 35000, 4000, 4000, 50);
		Monstrinho m8 = new Monstrinho("Jolteon", "Eletric", 45000, 5000, 5000, 50);
		
		Monstrinho m9 = new Monstrinho("Bayleef", "Grass", 50000, 9000, 6000, 20);
		Monstrinho m10 = new Monstrinho("Treecko", "Grass", 35000, 6000, 6000, 35);
		Monstrinho m11 = new Monstrinho("Shaymin", "Grass", 45000, 3000, 7000, 50);
		Monstrinho m12 = new Monstrinho("Bulbasaur", "Grass", 10000, 7000, 2000, 50);
		
		Monstrinho m13 = new Monstrinho("Totodile", "Water", 35000, 7000, 3000, 30);
		Monstrinho m14 = new Monstrinho("Squirtle", "Water", 30000, 6000, 5000, 40);
		Monstrinho m15 = new Monstrinho("Lapras", "Water", 40000, 10000, 5000, 50);
		Monstrinho m16 = new Monstrinho("Maril", "Water", 40000, 3000, 5000, 40);
		
		List<Monstrinho> monstro = new ArrayList<Monstrinho>();
		
		monstro.add(m1);
		monstro.add(m2);
		monstro.add(m3);
		monstro.add(m4);
		monstro.add(m5);
		monstro.add(m6);
		monstro.add(m7);
		monstro.add(m8);
		monstro.add(m9);
		monstro.add(m10);
		monstro.add(m11);
		monstro.add(m12);
		monstro.add(m13);
		monstro.add(m14);
		monstro.add(m15);
		monstro.add(m16);
		
		return monstro;
	}	
	
	@Override
	public String toString() {
		return "----------------------------------------------------------------------------------------" + "\n" +
				"Pokemon: " + nome + ", Tipo: " + tipo + ", Vida: " + vida + ", Força: " + forca + ", Defesa: "
				+ defesa + ", Velocidade: " + velocidade;
	}

	// Getters and Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getVida() {
		return vida;
	}
	public void setVida(double vida) {
		this.vida = vida;
	}
	public double getForca() {
		return forca;
	}
	public void setForca(double forca) {
		this.forca = forca;
	}
	public double getDefesa() {
		return defesa;
	}
	public void setDefesa(double defesa) {
		this.defesa = defesa;
	}
	public double getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(double velocidade) {
		this.velocidade = velocidade;
	}
	public boolean isDesmaiado() {
		return desmaiado;
	}
	public void setDesmaiado(boolean desmaiado) {
		this.desmaiado = desmaiado;
	}
}
