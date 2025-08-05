package br.apredendo.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//Versão do java: 21

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<String> loginsCadastrados = new ArrayList<>();
		Map<String, String> usuarios = new HashMap<>();

		String login = "";
		String senha = "";
		String opcao;
		String opcaoMenuInicio = "";
		boolean finalize = false;
		boolean sairDoLoop = false;
		boolean sairDoPrograma = false;
		boolean loginCadastrado = false;

		while (!sairDoPrograma) {

			sairDoLoop = false;
			loginCadastrado = false;

			System.out.println("Olá, selecione uma opção:");
			System.out.println("1) Fazer login.");
			System.out.println("2) Fazer cadastro.");
			System.out.println("3) Finalizar");
			System.out.print("Digite a opção desejada: ");

			opcaoMenuInicio = sc.nextLine();
///LOGIN
			if (opcaoMenuInicio.trim().equals("1")) {
				login = "";
				sairDoLoop = false;
				System.out.println("");

				System.out.print("Login: ");
				login = sc.nextLine();
				if (loginsCadastrados.contains(login)) {
					System.out.print("Senha: ");
					senha = sc.nextLine();

					if (usuarios.containsKey(login)) {
						while (!sairDoLoop) {

							if (usuarios.get(login).equals(senha)) {
								System.out.println();
								System.out.println("Login realizado com sucesso. Bem-vindo, " + login);
								System.out.println();
								System.out.println("         Menu de usuário:");
								System.out.println("1) Visualizar informações de usuário.");
								System.out.println("2) Alterar informações de usuário.");
								System.out.println("3) Informações do programa.");
								System.out.println("4) Finalizar programa.");
								System.out.println("5) Efetuar logout.");
								System.out.println();
								System.out.print("         Digite a opção desejada: ");
								opcao = sc.nextLine();
								System.out.println();

								if (opcao.equals("1")) {
									System.out.println("Informações do usuário.");
									System.out.println("Login: " + login);
									System.out.println("Senha: " + senha);
								} else if (opcao.equals("2")) {
									System.out.println("Alterar informações.");
									System.out.println("Alterar login:");
									System.out.println("Alterar senha:");

									System.out.println("Opção em manutenção, volte mais tarde.");
								} else if (opcao.equals("3")) {
									System.out.println("Informações:");
									System.out.println("Login e cadastro de usuários.");
									System.out.println("Desenvolvido por Bruno em conjunto com ChatGpt.");
								} else if (opcao.equals("4")) {
									sairDoLoop = true;
									sairDoPrograma = true;
									System.out.print("Programa finalizando.");
								} else if (opcao.equals("5")) {
									sairDoLoop = true;
									System.out.println("Efetuando logout.");
								}
							} else {
								System.out.println("Usuário ou senha incorreta.");
								sairDoLoop = true;
							}
						}
					}
					loginCadastrado = true;

				} else {
					login = "";
					loginCadastrado = false;
					System.out.println("Login não encontrado.");
				}

				System.out.println();

///CADASTRO
			} else if (opcaoMenuInicio.equals("2")) {
				System.out.println();

				System.out.println("Efetuar cadastro.");
//				while (!loginCadastrado && !sairDoLoop || !loginCadastrado) {
				while (!loginCadastrado) {

					login = "";
					sairDoLoop = false;

					while ((login.length() < 4)) {
						System.out.print("Digite o login desejado (mínimo 4 caracteres): ");

						login = sc.nextLine();

						if (login.trim().isEmpty()) {
							System.out.println("Login não pode estar em branco.");
							login = "";
						} else if (login.length() < 4) {
							System.out.println("Login muito curto! Tente novamente.");
						}
					}

					if (loginsCadastrados.contains(login)) {
						System.out.println("Login existente.");
						System.out.println("Digite outro login.");
						continue;
					}

					System.out.println();
					while (!sairDoLoop) {
						System.out.print("O login desejado é: " + login + "? Digite sim ou não: ");
						opcao = sc.nextLine();

						if (opcao.trim().equalsIgnoreCase("sim")) {

							System.out.println("Senha precisa ter no mínimo 3 caracteres.");
							System.out.print("Digite a senha: ");
							senha = sc.nextLine();

							if (senha.length() > 2) {
								System.out.println();
								System.out.println("Login e senha salvos.");
							}

							usuarios.put(login, senha);

							loginsCadastrados.add(login);
							loginCadastrado = true;
							sairDoLoop = true;

							login = "";
							senha = "";

							System.out.println("Cadastro realizado.");
							System.out.println("Redirecionando para menu principal.");
							System.out.println();

						} else if (opcao.trim().equalsIgnoreCase("nao") || opcao.trim().equalsIgnoreCase("não")) {
							finalize = false;
							while (!finalize) {
								System.out.print("Deseja digitar novamente o login? ");
								opcao = null;
								opcao = sc.nextLine();

								if (opcao.trim().equalsIgnoreCase("sim")) {
									login = "";
									sairDoLoop = true;
									finalize = true;
									System.out.println("Muito bem!");
								} else if (opcao.trim().equalsIgnoreCase("nao")
										|| opcao.trim().equalsIgnoreCase("não")) {
									finalize = true;
									sairDoLoop = true;
									System.out.println();
									System.out.println("Tudo bem, redirecionando para o menu principal.");
								} else {
									System.out.println("Por favor, digite sim ou não.");
								}
							}
						} else {
							System.out.println("Por favor, digite sim ou não.");
						}
					}
				}
			} else if (opcaoMenuInicio.equalsIgnoreCase("3")) {
				System.out.println();
				System.out.print("Você selecionou a opção 3");
				sairDoPrograma = true;
			} else {
				System.out.println("Opção inválida. Tente novamente.");
			}
		}

///Finaliza programa
		sc.close();
		System.out.println();
		System.out.println("Programa finalizado.");
	}
}