package Modelo;

import java.io.Serializable;

public class Apartamento extends Financiamento implements Serializable {
    public int numVagasGaragem;
    public int numAndar;

    // Construtor para inicializar os atributos específicos do apartamento
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numVagasGaragem, int numAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numVagasGaragem = numVagasGaragem;
        this.numAndar = numAndar;
    }

    @Override
    public double calcularPagamentoMensal() {
        // Calcula a taxa mensal de juros
        double taxaMensal = getTaxaJurosAnual() / 12 / 100;
        // Calcula o prazo em meses
        double meses = getPrazoFinanciamento() * 12;
        // Calcula o pagamento mensal usando a fórmula fornecida
        return (getValorImovel() * taxaMensal * Math.pow(1 + taxaMensal, meses)) /
                (Math.pow(1 + taxaMensal, meses) - 1);
    }

    @Override
    public double calcularTotalPagamento() {
        // Calcula o total do pagamento multiplicando o pagamento mensal pelo prazo em meses
        return calcularPagamentoMensal() * getPrazoFinanciamento() * 12;
    }

    public int getNumVagasGaragem() {
        return numVagasGaragem;
    }

    public void setNumVagasGaragem(int numVagasGaragem) {
        this.numVagasGaragem = numVagasGaragem;
    }

    public int getNumAndar() {
        return numAndar;
    }

    public void setNumAndar(int numAndar) {
        this.numAndar = numAndar;
    }


    @Override
    public String toString() {
        return "Apartamento{" +
                "Número de garagens=" + numVagasGaragem +
                ", Número de Andar =" + numAndar +
                ", Valor total do imóvel =" + this.getValorImovel() +
                ", Valor total do Financiamento =" + this.calcularTotalPagamento() +
                ", Taxa de Juros =" + this.getTaxaJurosAnual() +
                '}';
    }
}
