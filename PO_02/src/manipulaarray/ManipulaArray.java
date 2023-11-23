package manipulaarray;

import java.util.Scanner;
import java.util.Random;

public class ManipulaArray {

	public static int[] criarArrayDoUsuario() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o tamanho do array: ");
		int tamanho = scanner.nextInt();

		int[] array = new int[tamanho];

		for (int i = 0; i < tamanho; i++) {
			System.out.print("Elemento " + (i + 1) + ": ");
			array[i] = scanner.nextInt();
		}

		return array;
	}

	public static int[] criarArrayAleatorio(int tamanho, int valorMaximo) {
		int[] array = new int[tamanho];
		Random random = new Random();

		for (int i = 0; i < tamanho; i++) {
			array[i] = random.nextInt(valorMaximo + 1);
		}

		return array;
	}

	public static int calcularSoma(int[] array) {
		int soma = 0;
		for (int elemento : array) {
			soma += elemento;
		}
		return soma;
	}

	public static int encontrarMaiorValor(int[] array) {
		int maior = array[0];
		for (int elemento : array) {
			maior = Math.max(maior, elemento);
		}
		return maior;
	}

	public static int encontrarMenorValor(int[] array) {
		int menor = array[0];
		for (int elemento : array) {
			menor = Math.min(menor, elemento);
		}
		return menor;
	}

	public static void main(String[] args) {
		int[] arrayUsuario = criarArrayDoUsuario();
		int[] arrayAleatorio = criarArrayAleatorio(5, 100);

		System.out.println("\nArray do Usuário: " + arrayToString(arrayUsuario));
		System.out.println("\nArray Aleatório: " + arrayToString(arrayAleatorio));

		System.out.println("\nSoma do Array do Usuário: " + calcularSoma(arrayUsuario));
		System.out.println("Maior Valor do Array Aleatório: " + encontrarMaiorValor(arrayAleatorio));
		System.out.println("Menor Valor do Array Aleatório: " + encontrarMenorValor(arrayAleatorio));
	}

	public static String arrayToString(int[] array) {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);
			if (i < array.length - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
