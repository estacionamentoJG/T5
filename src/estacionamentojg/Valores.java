package estacionamentojg;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Valores {

    public Double total(Timestamp ent, Timestamp sai, String diaEntrada, String diaSaida) {
        
        Double precoTotal = 0.0;

        Calendar entrada = Calendar.getInstance();
        entrada.setTime(ent);
        
        Calendar saida = Calendar.getInstance();
        saida.setTime(sai);
        
        
        long diferenca = saida.getTimeInMillis() - entrada.getTimeInMillis();  // Calcula a diferença entre saida e da data de entrada
        int tempoHora = 1000 * 60 * 60;  // Quantidade de milissegundos em uma hora
        long totalHoras = diferenca / tempoHora;
        System.out.println("Entre a hora inicial e final são " + totalHoras + " horas de diferença.");
        System.out.println("hora inicial: " + entrada.get(Calendar.HOUR_OF_DAY) + " e hora final: " + saida.get(Calendar.HOUR_OF_DAY));

        if (entrada.get(Calendar.DATE) == saida.get(Calendar.DATE)) {
            
            if (entrada.get(Calendar.DAY_OF_WEEK) == 7) {
                precoTotal = 3.0;
            } else {
                precoTotal = totalHoras + 1.5;
            }
            System.out.println("mesmo dia: " + precoTotal);

        } else {
            Double fechamentoDia = (double) 24 - entrada.get(Calendar.HOUR_OF_DAY);
            totalHoras -= fechamentoDia;

            int diaAtual = entrada.get(Calendar.DAY_OF_WEEK);

            ArrayList<Double> dias = new ArrayList();
            if (diaAtual == 7) {
                dias.add(3.0);
            } else {
                dias.add(fechamentoDia + 1.5);
            }

            while (true) {
                diaAtual++;
                diaAtual %= 8;
                if (totalHoras > 24) {
                    System.out.println("to aqui. totalHoras: " + totalHoras);
                    if (diaAtual == 7) {
                        dias.add(3.0);
                    } else {
                        dias.add(24 + 1.5);
                    }
                    totalHoras -= 24;

                } else {
                    if (diaAtual == 7) {
                        dias.add(3.0);
                    } else {
                        dias.add(totalHoras + 1.5);
                    }
                    break;
                }
            }
            for (Double n : dias) {
                precoTotal += n;
            }

            System.out.println("dias: " + dias);
            System.out.println("preco total: " + precoTotal);

        }

        return precoTotal;
    }
}
