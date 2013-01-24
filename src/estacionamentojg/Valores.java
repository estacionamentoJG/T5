package estacionamentojg;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Valores {
    
    private Double precoNormal = 1.0;
    private Double primeiraHora = 1.0;
    private Double precoDomingo = 3.0;
    private Double precoTotal = 0.0;

    public Double total(Timestamp ent, Timestamp sai) {
        
        Calendar entrada = Calendar.getInstance();
        entrada.setTime(ent);
        
        Calendar saida = Calendar.getInstance();
        saida.setTime(sai);
        
        
        long diferenca = saida.getTimeInMillis() - entrada.getTimeInMillis();  // Calcula a diferença entre saida e da data de entrada
        int tempoHora = 1000 * 60 * 60;  // Quantidade de milissegundos em uma hora       
        Double totalHoras = (double) diferenca / tempoHora;
        totalHoras = Math.ceil(totalHoras); // arredonda horas para cima
        System.out.println("Entre a hora inicial e final são " + totalHoras + " horas de diferença.");
        System.out.println("hora inicial: " + entrada.get(Calendar.HOUR_OF_DAY) + " e hora final: " + saida.get(Calendar.HOUR_OF_DAY));

        if (entrada.get(Calendar.DATE) == saida.get(Calendar.DATE)) { // se for o mesmo dia
            
            if (entrada.get(Calendar.DAY_OF_WEEK) == 7) { // domingo
                this.precoTotal = this.precoDomingo; // valor unico de domingo
            } else {
                if (entrada.get(Calendar.HOUR) == saida.get(Calendar.HOUR)) // se entrou e saiu na mesma hora cheia
                    totalHoras = this.primeiraHora; // pega primeira hora
                this.precoTotal = totalHoras + this.precoNormal; // soma total de horas com o preco normal
            }
            //System.out.println("mesmo dia: " + precoTotal);

        } else { // se for dias diferentes
            Double fechamentoDia = (double) 24 - entrada.get(Calendar.HOUR_OF_DAY); // quantia de horas do primeiro dia
            totalHoras -= fechamentoDia; // calcula o restante de horas pendentes

            ArrayList<Double> dias = new ArrayList();
            
            if (entrada.get(Calendar.DAY_OF_WEEK) == 7) { // se for domingo
                dias.add(this.precoDomingo); // add precoDomingo no arrayList
            } else {
                dias.add( (fechamentoDia * this.precoNormal) + this.primeiraHora);
            }

            while (true) {
                entrada.add(Calendar.DATE, +1); // vai para o proximo dia
                if (totalHoras > 24) { // se faltar mais de um dia | não for ultimo dia
                    //System.out.println("to aqui. totalHoras: " + totalHoras);
                    if (entrada.get(Calendar.DAY_OF_WEEK) == 7) { // se domingo
                        dias.add(this.precoDomingo);
                    } else {
                        dias.add((24 * this.precoNormal) + this.primeiraHora); // calcula o preco do dia inteiro
                    }
                    totalHoras -= 24; // diminuir 24 horas do total

                } else { // se for o ultimo dia
                    if (entrada.get(Calendar.DAY_OF_WEEK) == 7) { // domingo
                        dias.add(this.precoDomingo);
                    } else {
                        dias.add( (totalHoras * this.precoNormal) + this.primeiraHora); // calcula o preco pelo restante de horas 
                    }
                    break;
                }
            }
            for (Double n : dias) { // todos os valores do arrrayList dias
                precoTotal += n; // soma todos os valores do arraylist
            }
            //System.out.println("dias: " + dias);
            //System.out.println("preco total: " + precoTotal);
        }

        return precoTotal;
    }
}
