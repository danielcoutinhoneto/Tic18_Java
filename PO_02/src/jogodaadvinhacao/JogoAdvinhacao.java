package jogodaadvinhacao;

import java.util.Scanner;

public class JogoAdvinhacao {

	public static void main(String[] args) {
		int numeroSecreto = (int) (Math.random() * 100) + 1;
		int tentativas = 0;
		int palpite;

		Scanner scanner = new Scanner(System.in);

		System.out.println("[ - Jogo de Adivinhação! - ]");
		System.out.println();

		do {
			System.out.print("Digite seu palpite (entre 1 e 100): ");

			while (!scanner.hasNextInt()) {
				System.out.println("Por favor, digite um número válido.");
				scanner.next(); // Limpar o buffer
			}

			palpite = scanner.nextInt();
			tentativas++;

			if (palpite < numeroSecreto) {
				System.out.println("Muito baixo! Tente novamente.");
			} else if (palpite > numeroSecreto) {
				System.out.println("Muito alto! Tente novamente.");
			} else {
				System.out.println("Parabéns! Você acertou em " + tentativas + " tentativas.");
			}
		} while (palpite != numeroSecreto);

		scanner.close();
	}

}
