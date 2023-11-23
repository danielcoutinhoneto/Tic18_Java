package conversorTemperatura;

import java.util.Scanner;

public class Conversor {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("--[ Conversor de Temperatura ]--");	
		System.out.println();
		
		System.out.println("Digite o número da temperatura: ");
		int numTemp = scanner.nextInt();
		System.out.println();
		
		System.out.println("Escolha a unidade de origem (Celsius ou Fahrenheit) para calcular (Ex.: c ou f): ");
        char operacao = scanner.next().charAt(0);
        System.out.println();
		
        double convTemp = 0;

        if (operacao == 'c') {
        	convTemp = (numTemp * 1.8) + 32;
        } 
        else if (operacao == 'f') {
        	convTemp = (numTemp - 32) / 1.8;
        } else {
            System.out.println("Opção inválida");
            return;
        }

        System.out.println("O resultado é: " + convTemp);
    }
}