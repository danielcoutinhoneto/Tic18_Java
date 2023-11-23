package conversordemoedas;

import java.util.Scanner;

public class ConversorMoedas {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("--[ Conversor de Dolares Em Reais ]--");	
		System.out.println();
		
		System.out.println("Insira a taxa de câmbio: ");
		double taxCamb = scanner.nextDouble();
		System.out.println();
		
		System.out.println("Digite a quantidade de dolares: ");
        double quantDol = scanner.nextDouble();
        System.out.println();
		
        double cambio = taxCamb * quantDol;

       

        System.out.println("O valor convertido de Dólares para Real foi de : " +"R$ "+ cambio);
    }
}