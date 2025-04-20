package Modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    private double valorImovel;
    private int prazoFinanciamento; // em anos
    private double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public abstract double calcularPagamentoMensal();
    public abstract double calcularTotalPagamento();

    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void mostrarDados() {
        System.out.println("Valor do imóvel: R$ " + valorImovel);
        System.out.println("Prazo do financiamento: " + prazoFinanciamento + " anos");
        System.out.println("Taxa de juros anual: " + taxaJurosAnual + "%");
        System.out.println("Pagamento mensal: R$ " + calcularPagamentoMensal());
        System.out.println("Total do pagamento: R$ " + calcularTotalPagamento());
    }

    @Override
    public String toString() {
        return "Financiamento{" +
                "valorImovel=" + valorImovel +
                ", prazoFinanciamento=" + prazoFinanciamento +
                ", taxaJurosAnual=" + taxaJurosAnual +
                '}';
    }
}
