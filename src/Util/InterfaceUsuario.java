package Util;

import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner = new Scanner(System.in);

    public double pedirValorImovel() {
        double valorImovel = -1;
        do {
            System.out.print("Digite o valor do imóvel: ");
            valorImovel = scanner.nextDouble();
            if (valorImovel <= 0) {
                System.out.println("O valor do imóvel deve ser positivo.");
            }
        } while (valorImovel <= 0);
        return valorImovel;
    }

    public int pedirPrazoFinanciamento() {
        int prazo = -1;
        do {
            System.out.print("Digite o prazo do financiamento (em anos): ");
            prazo = scanner.nextInt();
            if (prazo <= 0) {
                System.out.println("O prazo deve ser positivo.");
            }
        } while (prazo <= 0);
        return prazo;
    }

    public double pedirTaxaJuros() {
        double taxa = -1;
        do {
            System.out.print("Digite a taxa de juros anual: ");
            taxa = scanner.nextDouble();
            if (taxa <= 0) {
                System.out.println("A taxa de juros deve ser positiva.");
            }
        } while (taxa <= 0);
        return taxa;
    }
}
