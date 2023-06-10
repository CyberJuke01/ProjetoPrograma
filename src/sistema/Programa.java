package sistema;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Produtos;

public class Programa {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Integer menu = 0;
		Produtos[] prod = new Produtos[50];
		Integer cadastrados = 0;

		do {
			System.out.println("Digite a opcao:");
			System.out.println("|--------------------------------------|");
			System.out.printf("1.Cadastrar produto%n2.Alterar quantidade do produto%n3.Lista de Produtos%n9.Sair%n");
			System.out.println("|--------------------------------------|");
			menu = sc.nextInt();
			sc.nextLine();
			switch (menu) {
			case 1:
				String nome;
				Integer quantidade;
				Double preco;
				Boolean confirma = null;
				do {
					System.out.println("Nome do produto:");
					nome = sc.nextLine();
					System.out.println("Quantidade em estoque:");
					quantidade = sc.nextInt();
					System.out.println("Preco do produto:");
					preco = sc.nextDouble();
					sc.nextLine();
					do {
						System.out.printf("Confirma a criacao do produto: %s, %d unid., R$%.2f?(S/N)? ", nome,
								quantidade, preco);
						String a = sc.nextLine();
						if (a.equalsIgnoreCase("s")) {
							confirma = true;
						}
						else if (a.equalsIgnoreCase("n")) {
							confirma = false;
						} else {
							System.out.println("Opcao invalida!\n");
						}
						System.out.println();
					} while (confirma == null);
				} while (confirma == false);
				cadastrados += 1;
				prod[cadastrados - 1] = new Produtos(cadastrados, nome, quantidade, preco);
				System.out.println("Produto cadastrado com sucesso!\n");
				break;
			case 2:
				for (Produtos i : prod) { // listar produtos cadastrados
					if (i != null) {
						System.out.println(i);
					}
				}
				Integer idPesquisa;
				Boolean confirma2 = null;
				do {
					System.out.println("Digite o id do produto: ");
					idPesquisa = sc.nextInt();
					do {
						System.out.println("Confirma o produto:(S/N)?");
						System.out.println(prod[idPesquisa - 1]);
						sc.nextLine();
						String a = sc.nextLine();
						Integer addOuRmv = null;
						if (a.equalsIgnoreCase("s")) {
							Boolean ioError = null;
							confirma2 = true;
							do { //Loop caso haja input mismatch
								try { //Teste de tratamento de exceção input mismatch
									System.out.printf("1.Adicionar quantidade%n2.Remover quantidade%n");
									addOuRmv = sc.nextInt();
									ioError = false;
								} catch (InputMismatchException e) {
									System.out.println("Opcao invalida!");
									ioError = true;
								}
							} while (ioError == true);
							if (addOuRmv == 1) {
								System.out.println("Digite a quantidade a adicionar: ");
								prod[idPesquisa-1].addQuantity(sc.nextInt()); //Finalmente adicionar quantidade
								System.out.println("Quantidade adicionada!");
							} if (addOuRmv == 2) {
								System.out.println("Digite a quantidade a remover: ");
								prod[idPesquisa-1].removeQuantity(sc.nextInt()); //Finalmente remover quantidade
								System.out.println("Quantidade removida!");
							}
						}
					} while (confirma2 == null);
				} while (confirma2 == false);
				break;

			case 3:
				System.out.println("|--------------------------------------|");
				for (Produtos i : prod) {
					if (i != null) {
						System.out.println(i);
					}
				}
				System.out.println("|--------------------------------------|");
				break;

			case 9:
				break;

			default:
				System.out.println("Opcao inexistente!");
				break;
			}
		} while (menu != 9);
		sc.close();

	}

}
