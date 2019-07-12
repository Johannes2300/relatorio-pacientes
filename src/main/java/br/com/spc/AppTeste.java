package br.com.spc;

import java.text.DecimalFormat;
import java.util.List;

import br.com.spc.business.ClinicaBusiness;
import br.com.spc.model.VPaciente;

public class AppTeste {
	
	private final static String MASCULINO = "Masculino";
	private final static String FEMININO = "Feminino";
	
	public static void main(String[] args) {
		ClinicaBusiness clinicaBusiness = new ClinicaBusiness();
		
		// Cadastra pacientes
		List<VPaciente> lstPacientes = clinicaBusiness.registrarPacientes();
		
		// Monta relatório na sequência proposta no enunciado da atividade
		System.out.println("\nRELATÓRIO DE PACIENTES\n");
		System.out.println("I - Quantidade de pacientes: " + clinicaBusiness.mostrarQuantidadePacientes(lstPacientes));
		System.out.println("II - Média de idade dos homens: " + clinicaBusiness.calcularMediaIdadePorSexo(lstPacientes, MASCULINO));
		System.out.println("III - Qtd mulheres entre 1,60m e 1,70m, acima de 70 Kg: " + clinicaBusiness.calcularQtdPacientes(lstPacientes, 1.6, 1.7, 70, FEMININO));
		System.out.println("IV - Qtd de pacientes com idade entre 18 e 25 anos: " + clinicaBusiness.calculaQtdPacientes(lstPacientes, 18, 25));
		System.out.println("V - Nome do paciente mais velho: " + clinicaBusiness.exibirNomePacienteMaisVelho(lstPacientes));
		System.out.println("VI - Nome da mulher mais baixa: " + clinicaBusiness.exibirNomePacienteMaisBaixo(lstPacientes, FEMININO));
		System.out.println("\n----------------------------------------------------------\n");
		System.out.println("VII - Listagem de IMC dos pacientes:\n");

		// Item VII do enunciado da atividade
		clinicaBusiness.verificarIMC(lstPacientes);
		DecimalFormat format = new DecimalFormat("#.00");
		for (VPaciente vPaciente : lstPacientes) {
			System.out.println("Paciente: " + vPaciente.getNome());
			System.out.println("IMC: " + format.format(vPaciente.getNumIMC()));
			System.out.println("Situação: " + vPaciente.getDsIMC() + "\n");
		}
	}

}
