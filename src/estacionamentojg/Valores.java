package estacionamentojg;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Valores {

    public Double total(Timestamp ent, Timestamp sai, String diaEntrada) {
        
        Double precoTotal = 0.0;

        Calendar entrada = Calendar.getInstance();
        entrada.setTime(ent);
        
        Calendar saida = Calendar.getInstance();
        saida.setTime(sai);
        
        
        long diferenca = saida.getTimeInMillis() - entrada.getTimeInMillis();  // Calcula a diferença entre saida e da data de entrada
        int tempoHora = 1000 * 60 * 60;  // Quantidade de milissegundos em uma hora
        long totalHoras = diferenca / tempoHora;
        //System.out.println("Entre a hora inicial e final são " + totalHoras + " horas de diferença.");
        //System.out.println("hora inicial: " + entrada.get(Calendar.HOUR_OF_DAY) + " e hora final: " + saida.get(Calendar.HOUR_OF_DAY));

        if (entrada.get(Calendar.DATE) == saida.get(Calendar.DATE)) { // dia de entrada = dia de saida
            
            if (entrada.get(Calendar.DAY_OF_WEEK) == 7) { // se for domingo
                precoTotal = 3.0;
            } else {
                if (entrada.get(Calendar.DATE) == saida.get(Calendar.HOUR_OF_DAY) && entrada.get(Calendar.HOUR_OF_DAY) == saida.get(Calendar.HOUR_OF_DAY)) // entrada e saida com a mesma hora
                    totalHoras = 1; // primeira hora
                precoTotal = totalHoras + 1.5; // soma 1.5
            }
            //System.out.println("mesmo dia: " + precoTotal);

        } else {
            Double fechamentoDia = (double) 24 - entrada.get(Calendar.HOUR_OF_DAY); // calcula horas do primeiro dia
            totalHoras -= fechamentoDia; // diminui do total 

            ArrayList<Double> dias = new ArrayList();
            if (entrada.get(Calendar.DAY_OF_WEEK) == 7) { // domingo
                dias.add(3.0); // soma 3
            } else {
                dias.add(fechamentoDia + 1.5); // soma 1.5 a primeira hora de cada dia
            }

            while (true) {
                entrada.add(Calendar.DAY_OF_WEEK, +1); // proximo dia
                //System.out.println(entrada.get(Calendar.DAY_OF_WEEK));

                if (totalHoras > 24) { // mais de um dia
                    //System.out.println("to aqui. totalHoras: " + totalHoras);
                    if (entrada.get(Calendar.DAY_OF_WEEK) == 7) { // domingo
                        dias.add(3.0); // R$3,00
                    } else {
                        dias.add(24 + 1.5); // 24 horas mais 1.5
                    }
                    totalHoras -= 24; // diminui do total

                } else { // no ultimo dia
                    if (entrada.get(Calendar.DAY_OF_WEEK) == 7) { // domingo
                        dias.add(3.0); // soma 3
                    } else {
                        dias.add(totalHoras + 1.5); // total de horas
                    }
                    break;
                }
            }
            for (Double n : dias) { // percorre o vetor de horas por dia
                precoTotal += n; // soma no total
            }

            //System.out.println("dias: " + dias);
            //System.out.println("preco total: " + precoTotal);

        }

        return precoTotal; // retorna preco total
    }
}
