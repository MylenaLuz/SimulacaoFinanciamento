package Util;

import Modelo.Financiamento;

import java.io.*;
import java.util.ArrayList;

public class Persistencia {
    public static void salvarFinanciamentos(ArrayList<Financiamento> financiamentos, String arquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(financiamentos);
        }
    }
    public static void salvarTextoFinanciamento(ArrayList<Financiamento> financiamentos, String arquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
          for(Financiamento financiamento: financiamentos){
              writer.write(financiamento.toString());
              writer.newLine();
          }
        }
    }

    public static ArrayList<Financiamento> carregarFinanciamentos(String arquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (ArrayList<Financiamento>) ois.readObject();
        }
    }
}


