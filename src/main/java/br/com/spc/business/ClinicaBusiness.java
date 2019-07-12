package br.com.spc.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.spc.model.VPaciente;

public class ClinicaBusiness {

	/**
	 * Registra pacientes na clínica enquanto <b><i>fim</i></b> não for 
	 * digitado no lugar do nome do paciente
	 * @return lista de pacientes registrados
	 */
	public List<VPaciente> registrarPacientes() {
		System.out.println("Iniciando leitura de paciêntes\n");
		List<VPaciente> lstPacientes = new ArrayList<VPaciente>();
		
		Scanner in = new Scanner(System.in);
		VPaciente paciente;
		
		Boolean ehUltimoPaciente = false;
		
		do {
			paciente = new VPaciente();
			
			System.out.print("Digite o nome do paciente: ");
			paciente.setNome(in.next());
			
			if (!"fim".equalsIgnoreCase(paciente.getNome())) { 
				System.out.print("Digite o sexo do paciente: ");
				paciente.setSexo(in.next());
				
				System.out.print("Digite a idade do paciente: ");
				paciente.setIdade(in.nextInt());
				
				System.out.print("Digite a altura do paciente: ");
				paciente.setAltura(in.nextDouble());
				
				System.out.print("Digite o peso do paciente: ");
				paciente.setPeso(in.nextDouble());
				
				System.out.println("");
				
				lstPacientes.add(paciente);
			} else {
				ehUltimoPaciente = true;
			}
		} while(!ehUltimoPaciente);
		in.close();
		
		return lstPacientes;
	}
	
	/**
	 * Retorna a quantidade de pacientes registrados no total
	 * @param lstPacientes
	 * @return tamanho da lista de pacientes
	 */
	public int mostrarQuantidadePacientes(List<VPaciente> lstPacientes) {
		return lstPacientes.size();
	}
	
	/**
	 * Calcula a média de idade baseada no gênero do paciente
	 * @param lstPacientes
	 * @param sexo
	 * @return média de idade
	 */
	public int calcularMediaIdadePorSexo(List<VPaciente> lstPacientes, String sexo) {
		int mediaIdade = 0;
		int qtdPacientes = 0;
		for (VPaciente vPaciente : lstPacientes) {
			if (sexo.equalsIgnoreCase(vPaciente.getSexo())) {
				mediaIdade += vPaciente.getIdade();
				qtdPacientes++;
			}
		}
		int mediaFinal = mediaIdade / qtdPacientes;
		
		return mediaFinal;
	}
	
	/**
	 * Calcula a quantidade de pacientes de acordo com o <b>gênero</b> informado, range de <b>altura</b> e <b>peso</b> 
	 * @param lstPacientes
	 * @param alturaMin
	 * @param alturaMax
	 * @param peso
	 * @param genero
	 * @return quantidade de pacientes
	 */
	public int calcularQtdPacientes(List<VPaciente> lstPacientes, double alturaMin, double alturaMax, double peso, String genero) {
		int qtdPacientes = 0;
		for (VPaciente vPaciente : lstPacientes) {
			if ((vPaciente.getAltura() >= alturaMin && vPaciente.getAltura() <= alturaMax) && vPaciente.getPeso() > peso) {
				if (genero.equalsIgnoreCase(vPaciente.getSexo())) {
					qtdPacientes++;
				}
			}
		}
		return qtdPacientes;
	}
	
	/**
	 * Calcula a quantidade de pacientes registrados de acordo com o range de idade
	 * @param lstPacientes
	 * @param idadeMinima
	 * @param idadeMaxima
	 * @return quantidade de pacientes
	 */
	public int calculaQtdPacientes(List<VPaciente> lstPacientes, int idadeMinima, int idadeMaxima) {
		int qtdPacientes = 0;
		for (VPaciente vPaciente : lstPacientes) {
			if (vPaciente.getIdade() >= 18 && vPaciente.getIdade() <= 25) {
				qtdPacientes++;
			}
		}
		return qtdPacientes;
	}
	
	/**
	 * Exibe o nome do paciente mais velho
	 * @param lstPacientes
	 * @return nome do paciente mais velho
	 */
	public String exibirNomePacienteMaisVelho(List<VPaciente> lstPacientes) {
		String auxNome = null;
		int auxIdade = 0;
		for (VPaciente vPaciente : lstPacientes) {
			if (vPaciente.getIdade() > auxIdade) {
				auxIdade = vPaciente.getIdade();
				auxNome = vPaciente.getNome();
			}
		}
		return auxNome;
	}
	
	/**
	 * Exibe o nome do paciente mais baixo pelo gênero passado como argumento
	 * @param lstPacientes
	 * @param genero
	 * @return nome do paciente mais baixo
	 */
	public String exibirNomePacienteMaisBaixo(List<VPaciente> lstPacientes, String genero) {
		String auxNome = null;
		double auxAltura = 0;
		Boolean ehPrimeiroPaciente = true;
		for (VPaciente vPaciente : lstPacientes) {
			if (ehPrimeiroPaciente && genero.equalsIgnoreCase(vPaciente.getSexo())) {
				auxAltura = vPaciente.getAltura();
				auxNome = vPaciente.getNome();
				ehPrimeiroPaciente = false;
			} else if (genero.equalsIgnoreCase(vPaciente.getSexo()) && vPaciente.getAltura() < auxAltura) {
				auxAltura = vPaciente.getAltura();
				auxNome = vPaciente.getNome();
			}
		}
		return auxNome;
	}
	
	/**
	 * Verifica o IMC de cada um dos pacientes
	 * @param lstPacientes
	 */
	public void verificarIMC(List<VPaciente> lstPacientes) {
		for (VPaciente vPaciente : lstPacientes) {
			vPaciente.setNumIMC(calcularIMC(vPaciente.getAltura(), vPaciente.getPeso()));
			if (vPaciente.getNumIMC() >= 18.5 && vPaciente.getNumIMC() < 25) {
				vPaciente.setDsIMC("Peso normal");
			} else if (vPaciente.getNumIMC() >= 25 && vPaciente.getNumIMC() < 30) {
				vPaciente.setDsIMC("Acima do peso");
			} else if (vPaciente.getNumIMC() >= 30 && vPaciente.getNumIMC() < 35) {
				vPaciente.setDsIMC("Obesidade I");
			} else if (vPaciente.getNumIMC() >= 35 && vPaciente.getNumIMC() < 40) {
				vPaciente.setDsIMC("Obesidade II (severa)");
			} else if (vPaciente.getNumIMC() >= 40) {
				vPaciente.setDsIMC("Obesidade III (mórbida)");
			}
		}
	}
	
	/**
	 * Calcula IMC
	 * @param altura
	 * @param peso
	 * @return IMC
	 */
	private double calcularIMC(double altura, double peso) {
		return peso / Math.pow(altura, 2);
	}
}
