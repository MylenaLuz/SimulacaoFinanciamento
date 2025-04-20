package Main;

import Modelo.*;
import Util.*;

import java.io.IOException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        // Solicita os dados do financiamento ao usuário
        double valorImovel = interfaceUsuario.pedirValorImovel();
        int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
        double taxaJurosAnual = interfaceUsuario.pedirTaxaJuros();

        // Cria um financiamento com os dados inseridos pelo usuário
        Financiamento financiamentoUsuario = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, 100, 200);

        // Cria financiamentos predefinidos
        Financiamento casa1 = new Casa(200000, 30, 5, 120, 300);
        Financiamento apartamento1 = new Apartamento(300000, 25, 4, 2, 5);
        Financiamento apartamento2 = new Apartamento(150000, 20, 3.5, 1, 10);
        Financiamento terreno1 = new Terreno(250000, 15, 6, "Residencial");

        // Adiciona os financiamentos a uma lista
        ArrayList<Financiamento> financiamentos = new ArrayList<>();
        financiamentos.add(financiamentoUsuario);
        financiamentos.add(casa1);
        financiamentos.add(apartamento1);
        financiamentos.add(apartamento2);
        financiamentos.add(terreno1);

        try {
            // Salva os financiamentos em um arquivo
            Persistencia.salvarFinanciamentos(financiamentos, "C:/arquivos/financiamentos.dat");

            // Carrega os financiamentos do arquivo
            ArrayList<Financiamento> financiamentosCarregados = Persistencia.carregarFinanciamentos("C:/arquivos/financiamentos.dat");
            Persistencia.salvarTextoFinanciamento(financiamentos, "C:/arquivos/financiamentos.txt");

            double totalValorImovel = 0;
            double totalValorFinanciamento = 0;
            // Mostra os dados de cada financiamento e calcula os totais
            for (Financiamento f : financiamentosCarregados) {


              f.mostrarDados();
                totalValorImovel += f.getValorImovel();
                totalValorFinanciamento += f.calcularTotalPagamento();
            }


            // Metodo que salva o arquivo em texto.

            System.out.println("Total de todos os imóveis: R$ " + totalValorImovel);
            System.out.println("Total de todos os financiamentos: R$ " + totalValorFinanciamento);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar financiamentos: " + e.getMessage());
        }
    }
}
