package Modelo;

import java.io.Serializable;

public class Casa extends Financiamento implements Serializable {
    private double areaConstruida;
    private double tamanhoTerreno;

    // Construtor para inicializar os atributos específicos da casa
    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        // Calcula o prazo em meses
        double prazoEmMeses = getPrazoFinanciamento() * 12;
        // Calcula a taxa mensal de juros
        double taxaMensal = getTaxaJurosAnual() / 12 / 100;
        // Calcula o pagamento mensal usando a fórmula fornecida
        double pagamentoMensal = (getValorImovel() * taxaMensal * Math.pow((1 + taxaMensal), prazoEmMeses)) /
                (Math.pow((1 + taxaMensal), prazoEmMeses) - 1);
        // Adiciona R$80 por parcela
        return pagamentoMensal + 80;
    }

    @Override
    public double calcularTotalPagamento() {
        // Calcula o total do pagamento multiplicando o pagamento mensal pelo prazo em meses
        return calcularPagamentoMensal() * getPrazoFinanciamento() * 12;
    }

    public double getAreaConstruida() {
        return areaConstruida;
    }

    public void setAreaConstruida(double areaConstruida) {
        this.areaConstruida = areaConstruida;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }

    public void setTamanhoTerreno(double tamanhoTerreno) {
        this.tamanhoTerreno = tamanhoTerreno;
    }

    @Override
    public String toString() {
        return "Casa{" +
                "areaConstruida=" + areaConstruida +
                ", tamanhoTerreno=" + tamanhoTerreno +
                ", Valor total do imóvel =" + this.getValorImovel() +
                ", Valor total do Financiamento =" + this.calcularTotalPagamento() +
                ", Taxa de Juros =" + this.getTaxaJurosAnual() +
                '}';
    }
}
