package parOuImpar;

import java.util.Scanner;

public class parOuImpar {

	public static void main(String[] args) throws InterruptedException {

		Scanner teclado = new Scanner(System.in);

		char[] rounds = new char[3];
		int roundAtual = 0;

		System.out.println("Começando PAR ou ÍMPAR melhor de 3!");

		while (roundAtual < 3) {

			System.out.println("Escolha PAR ou ÍMPAR. Digite 0 para escolher PAR ou 1 para ÍMPAR:");
			int escolha = teclado.nextInt();
			// 0 é par, 1 é ímpar. Essa variável será usada depois.

			if (escolha == 0)
				System.out.println("Você escolheu PAR.");
			else
				System.out.println("Você escolheu ÍMPAR.");

			System.out.println("Faça sua jogada. Escolha 1 ou 2:");
			int jogada1 = teclado.nextInt();
			// essa variável vai ser usada depois

			System.out.println("Agora é a vez da CPU jogar...");
			Thread.sleep(1000);
			// atrasa 1 sgeundo
			double numero = Math.random();
			// gera um número decimal aleatório entre 0 e 1
			int jogada2 = (int) (Math.ceil(numero) + 1);
			// arredonda e soma 1, (foi usado um casting) para gerar uma jogada entre 1 e 2
			System.out.println("A CPU jogou: " + jogada2);

			System.out.println("Calculando o vencedor...");
			Thread.sleep(1000);
			// atrasa 1 segundo
			int soma = jogada1 + jogada2;
			boolean resultadoPar = soma % 2 == 0;
			if (resultadoPar == true && escolha == 0) {
				System.out.println("Você ganhou este round!");
				rounds[roundAtual++] = 'j';
			} else if (resultadoPar == false && escolha == 1) {
				System.out.println("Você ganhou este round!");
				rounds[roundAtual++] = 'j';
			} else {
				System.out.println("A CPU ganhou este round!");
				rounds[roundAtual++] = 'c';
			}

			if (roundAtual == 2) {
				if (rounds[0] == 'j' && rounds[1] == 'j') {
					System.out.println("Você ganhou duas em sequência!");
					break;
				} else if (rounds[0] == 'c' && rounds[1] == 'c') {
					System.out.println("A CPU ganhou duas em sequência!");
					break;
				}
			} else if (roundAtual == 3) // else if adicionado para ver o vencedor do round 3
				if (rounds[2] == 'j') {
					System.out.println("Você ganhou a melhor de 3!");
					break;
				} else if (rounds[2] == 'c') {
					System.out.println("A CPU ganhou a melhor de 3!");
					break;
				}
		}

	}

}
