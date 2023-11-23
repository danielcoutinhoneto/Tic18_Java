package calculadoraSimples;
import java.util.Scanner;

public class Calculadora {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("--[ Calculadora Simples ]--");	
		System.out.println();
		
		
		System.out.println("Digite o primeiro número para calcular: ");
		double num1 = scanner.nextDouble();
		System.out.println();
		
		System.out.println("Digite o segundo número para calcular: ");
		double num2 = scanner.nextDouble();
		System.out.println();
		
		System.out.print("Escolha símbolo da operação para calcular (Ex.: +, -, *, /): ");
        char operacao = scanner.next().charAt(0);
        System.out.println();
		
        double resultado = 0;

        if (operacao == '+') {
            resultado = num1 + num2;
        } else if (operacao == '-') {
            resultado = num1 - num2;
        } else if (operacao == '*') {
            resultado = num1 * num2;
        } else if (operacao == '/') {
            if (num2 != 0) {
                resultado = num1 / num2;
            } else {
                System.out.println("Erro: Divisão por zero não é permitida.");
                return;
            }
        } else {
            System.out.println("Operação inválida");
            return;
        }

        System.out.println("O resultado é: " + resultado);
    }
}


