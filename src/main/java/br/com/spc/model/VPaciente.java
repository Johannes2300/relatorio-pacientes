package br.com.spc.model;

public class VPaciente {

	private String nome;
	private String sexo;
	private int idade;
	private double altura;
	private double peso;
	private double numIMC;
	private String dsIMC;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getNumIMC() {
		return numIMC;
	}
	public void setNumIMC(double numIMC) {
		this.numIMC = numIMC;
	}
	public String getDsIMC() {
		return dsIMC;
	}
	public void setDsIMC(String dsIMC) {
		this.dsIMC = dsIMC;
	}
	
}
