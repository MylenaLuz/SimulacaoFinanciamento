package Modelo;

import java.io.Serializable;

public class Terreno extends Financiamento implements Serializable {
    private String tipoZona;

    // Construtor para inicializar os atributos específicos do terreno
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
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
        // Adiciona 2% ao valor da parcela
        return pagamentoMensal * 1.02;
    }

    @Override
    public double calcularTotalPagamento() {
        // Calcula o total do pagamento multiplicando o pagamento mensal pelo prazo em meses
        return calcularPagamentoMensal() * getPrazoFinanciamento() * 12;
    }

    public String getTipoZona() {
        return tipoZona;
    }

    public void setTipoZona(String tipoZona) {
        this.tipoZona = tipoZona;
    }

    @Override
    public String toString() {
        return "Terreno{" +
                "tipoZona='" + tipoZona + '\'' +
                ", Valor total do imóvel =" + this.getValorImovel() +
                ", Valor total do Financiamento =" + this.calcularTotalPagamento() +
                ", Taxa de Juros =" + this.getTaxaJurosAnual() +
                '}';
    }
}
