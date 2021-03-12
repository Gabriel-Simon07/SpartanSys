package SpartanSys;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
//import java.awt.List;

public class SpartanSys {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in); // input para selecionar cadastrar ou consultar novo cliente
		Calendar data = Calendar.getInstance();

		int cadastrarNovamente = 0;
		int hora = data.get(Calendar.HOUR_OF_DAY);

		if (hora >= 6 && hora <= 12) {
			System.out.println("+---------------------+");
			System.out.println("|                     |");
			System.out.println("|       BOM DIA       |");
			System.out.println("|                     |");
			System.out.println("+---------------------+");
			System.out.println();
		} else if (hora > 12 && hora <= 18) {
			System.out.println("+---------------------+");
			System.out.println("|                     |");
			System.out.println("|      BOA TARDE      |");
			System.out.println("|                     |");
			System.out.println("+---------------------+");
			System.out.println();
		} else {
			System.out.println("+---------------------+");
			System.out.println("|                     |");
			System.out.println("|      BOA NOITE      |");
			System.out.println("|                     |");
			System.out.println("+---------------------+");
			System.out.println();
		}

		// -------------------------------------
		// V�RIAVEIS E COISAS �TEIS DO C�DIGO
		// -------------------------------------
		String nomeCompleto = "";
		ArrayList<String> arrayNomeCompleto = new ArrayList<String>();

		String CPF = "";
		ArrayList<String> arrayCPF = new ArrayList<String>();

		String RG = "";
		ArrayList<String> arrayRG = new ArrayList<String>();

		int pagamento = 0;
		ArrayList<Integer> arrayPagamento = new ArrayList<Integer>();

		// -------------------------------------

		// -------------------------------------
		long diasHospedado;
		byte inputDiaEntrada;
		byte inputMesEntrada;
		int inputAnoEntrada;
		byte inputDiaSaida;
		byte inputMesSaida;
		int inputAnoSaida;
		LocalDate dataEntrada;
		LocalDate dataSaida;
		// -------------------------------------

		// -------------------------------------
		byte quartoEconomico = 1;
		int diariaEconomico = 40;
		byte quartoExecutivo = 1;
		int diariaExecutivo = 100;
		byte suiteMaster = 1;
		int diariaSuiteMaster = 350;
		int quartosTotais = quartoEconomico + quartoExecutivo + suiteMaster;
		int quartoDesejado;
		String quarto = "Nenhum";
		ArrayList<String> arrayQuarto = new ArrayList<String>();

		// -------------------------------------

		// -------------------------------------
		String formaPagamento = "";
		ArrayList<String> arrayFormaPagamento = new ArrayList<String>();

		double desconto = 1.0;
		double valorTotal = 1.0;
		ArrayList<Double> arrayValorTotal = new ArrayList<Double>();

		double cotacaoBTC = 0.000017;
		final String hotelNome = "Quality Hotel";
		// -------------------------------------
		// CASE 2

		byte numeroCadastro = 0;
		byte novaConsulta = 0;

		// -------------------------------------

		// NOME, CPF, RG, FORMA DE PAGAMENTO

		while (cadastrarNovamente == 0) {
			if (quartosTotais > 0) {
				System.out.print("\nInsira seu nome completo: ");
				nomeCompleto = input.nextLine();
				arrayNomeCompleto.add(nomeCompleto);

				System.out.print("Insira seu CPF: ");
				CPF = input.nextLine();
				arrayCPF.add(CPF);

				System.out.print("Insira seu RG: ");
				RG = input.nextLine();
				arrayRG.add(RG);

				System.out.print("\nInsira a forma de pagamento:" + "\n............................"
						+ "\n [0] = Cart�o de Cr�dito" + "\n [1] = Cart�o de D�bito" + "\n [2] = Dinheiro"
						+ "\n [3] = Bitcoin" + "\n.............................\n-> ");
				pagamento = input.nextInt();
				System.out.println();

				while (pagamento != 0 && pagamento != 1 && pagamento != 2 && pagamento != 3) {
					System.out.print("\nInforme uma forma de pagamento v�lida!\n\n -> ");
					pagamento = input.nextInt();
					System.out.println();
				}

				// PAGAMENTOS EM DINHEIRO E EM BITCOIN

				switch (pagamento) {
				case 0:
					desconto = 0.0;
					formaPagamento = "Cart�o de Cr�dito";
					arrayFormaPagamento.add(formaPagamento);
					arrayPagamento.add(pagamento);
					break;
				case 1:
					desconto = 0.0;
					formaPagamento = "Cart�o de D�bito";
					arrayFormaPagamento.add(formaPagamento);
					arrayPagamento.add(pagamento);
					break;
				case 2:
					desconto = 0.1;
					formaPagamento = "Dinheiro";
					arrayFormaPagamento.add(formaPagamento);
					arrayPagamento.add(pagamento);
					break;
				case 3:
					desconto = 0.15;
					formaPagamento = "Bitcoin";
					arrayFormaPagamento.add(formaPagamento);
					arrayPagamento.add(pagamento);
					break;
				}

				// QUARTOS DISPONIVEIS
				System.out.println("+-----------------------------------+");
				System.out.println("+ Quantidade de Quartos Dispon�veis +");
				System.out.println("+-----------------------------------+");
				System.out.println("\nQuartos Econ�micos = [ " + quartoEconomico + " ]\n" + "\nQuartos Executivos = [ "
						+ quartoExecutivo + " ]\n" + "\nSu�tes Master      = [ " + suiteMaster + " ]");

				System.out.println(
						"\n\nPor gentileza Sr(a). " + nomeCompleto + " selecione o quarto que deseja se hospedar:\n");
				System.out.println(".........................");
				System.out
						.print("[ 1 ] - Quarto Econ�mico\n" + "[ 2 ] - Quarto Executivo\n" + "[ 3 ] - Su�te Master\n");
				System.out.println(".........................");
				System.out.print("\n-> ");
				quartoDesejado = input.nextInt();

				while (quartoDesejado != 1 && quartoDesejado != 2 && quartoDesejado != 3) {
					System.out.print("Informe uma op��o de quarto v�lida!\n\n -> ");
					quartoDesejado = input.nextInt();
				}

				while ((quartoDesejado == 1 && quartoEconomico <= 0) || (quartoDesejado == 2 && quartoExecutivo <= 0)
						|| (quartoDesejado == 3 && suiteMaster <= 0)) {
					System.out.println("Sem vagas no quarto selecionado, por favor, selecione outro quarto!");
					System.out.println(".........................");
					System.out.print(
							"[ 1 ] - Quarto Econ�mico\n" + "[ 2 ] - Quarto Executivo\n" + "[ 3 ] - Su�te Master\n");
					System.out.println(".........................");
					System.out.print("\n-> ");
					quartoDesejado = input.nextInt();
				}

				System.out.println("....................");

				System.out.print("Dia da entrada: ");
				inputDiaEntrada = input.nextByte();

				System.out.print("M�s da entrada: ");
				inputMesEntrada = input.nextByte();

				System.out.print("Ano da entrada: ");
				inputAnoEntrada = input.nextInt();

				System.out.println();

				System.out.print("Dia da sa�da: ");
				inputDiaSaida = input.nextByte();

				System.out.print("M�s da sa�da: ");
				inputMesSaida = input.nextByte();

				System.out.print("Ano da sa�da: ");
				inputAnoSaida = input.nextInt();

				while (inputDiaEntrada <= 0 || inputDiaEntrada > 31 || inputMesEntrada <= 0 || inputMesEntrada > 12
						|| inputDiaSaida <= 0 // 31
						|| inputDiaSaida > 31 || inputMesSaida <= 0 || inputMesSaida > 12
						|| inputAnoEntrada > inputAnoSaida || inputAnoEntrada < 2020) {

					System.out.println("....................");

					System.out.println("\nInforme uma data v�lida!\n");

					System.out.print("Dia da entrada: ");
					inputDiaEntrada = input.nextByte();

					System.out.print("M�s da entrada: ");
					inputMesEntrada = input.nextByte();

					System.out.print("Ano da entrada: ");
					inputAnoEntrada = input.nextInt();

					System.out.println();

					System.out.print("Dia da sa�da: ");
					inputDiaSaida = input.nextByte();

					System.out.print("M�s da sa�da: ");
					inputMesSaida = input.nextByte();

					System.out.print("Ano da sa�da: ");
					inputAnoSaida = input.nextInt();

					System.out.println("....................");
				}

				dataEntrada = LocalDate.of(inputAnoEntrada, inputMesEntrada, inputDiaEntrada);
				dataSaida = LocalDate.of(inputAnoSaida, inputMesSaida, inputDiaSaida);

				diasHospedado = ChronoUnit.DAYS.between(dataEntrada, dataSaida);

				System.out.println();

				switch (quartoDesejado) {
				case 1:
					valorTotal = diasHospedado * diariaEconomico;
					quartoEconomico--;
					quartosTotais--;
					quarto = "Quarto Econ�mico";
					arrayQuarto.add(quarto);
					break;
				case 2:
					valorTotal = diasHospedado * diariaExecutivo;
					quartoExecutivo--;
					quartosTotais--;
					quarto = "Quarto Executivo";
					arrayQuarto.add(quarto);
					break;
				case 3:
					valorTotal = diasHospedado * diariaSuiteMaster;
					quarto = "Su�te Master";
					quartosTotais--;
					arrayQuarto.add(quarto);
					suiteMaster--;
					break;
				}

				valorTotal = valorTotal - (valorTotal * desconto);

				//
				if (pagamento == 3) {
					valorTotal *= cotacaoBTC;
					arrayValorTotal.add(valorTotal);
				} else {
					arrayValorTotal.add(valorTotal);
				}
				//

				System.out.println("-------------------------------------------------------------------------");
				System.out.println("Voc� ficar� " + diasHospedado + " dias hospedado no " + hotelNome
						+ " e pagar� um total de " + ((pagamento == 3) ? valorTotal + "BTC" : "R$" + valorTotal));
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("\n............................");
				System.out.print("Deseja fazer outro cadastro: \n[0] = Sim" + "\n[1] = N�o\n\n -> ");
				cadastrarNovamente = input.nextInt();

				while (cadastrarNovamente < 0 || cadastrarNovamente > 1) {
					System.out.print("Informe uma op��o v�lida!\n\n -> ");
					cadastrarNovamente = input.nextInt();
				}
				input.nextLine();
			} else {
				System.out.print("Sr(a)." + nomeCompleto + ", sinto-lhe informar que a " + hotelNome
						+ " est� sem quartos dispon�veis.\n");
				cadastrarNovamente = 1;
			}

			if (cadastrarNovamente == 1) {
				while (novaConsulta == 0) {
					System.out.print("\nConsultar algum cadastro: \n\n[0] = Sim" + "\n[1] = N�o\n\n -> ");
					novaConsulta = input.nextByte();
					while (novaConsulta < 0 || novaConsulta > 1) {
						System.out.println("\nInforme uma op�a� V�lida! \n -> ");
						novaConsulta = input.nextByte();
					}
					if (novaConsulta == 1) {
						System.out.println("Programa finalizado!");
						System.out.println("\n" + hotelNome + " Agradece pela prefer�ncia, volte sempre!!");
					} else {
						System.out.print("Qual o n�mero do cadastro voc� quer consultar: \n -> ");
						if (input.hasNext()) {
							numeroCadastro = input.nextByte();
						}

						System.out.println("+-----------------------------+");
						System.out.println("| NOME " + arrayNomeCompleto.get(numeroCadastro));
						System.out.println("| CPF " + arrayCPF.get(numeroCadastro));
						System.out.println("| RG " + arrayRG.get(numeroCadastro));
						System.out.println("| QUARTO " + arrayQuarto.get(numeroCadastro));
						if ((int) (arrayPagamento.get(numeroCadastro)) == 3) {
							System.out.println("| FORMA DE PAGAMENTO " + arrayFormaPagamento.get(numeroCadastro)
									+ " | R$1.00 = 0.00002 BTC |");

							System.out.println("| TOTAL " + arrayValorTotal.get(numeroCadastro) + "BTC");
						} else {
							System.out.println("| FORMA DE PAGAMENTO " + arrayFormaPagamento.get(numeroCadastro));
							System.out.println("| TOTAL R$" + arrayValorTotal.get(numeroCadastro));

						}
						System.out.println("+-----------------------------+");
						System.out.println();
					}
				}
			}
		}

		input.close();

	}
}