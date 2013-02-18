package estacionamentojg;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Valores {

    private Double precoHora;
    private Double primeiraHora;
    private Double precoDomingo = 3.0;
    private Double precoTotal = 0.0;

    Valores(Double pP, Double pH) { //construtor para receber valores da primeiraHora e precoHora definidos
        this.precoHora = pH;
        this.primeiraHora = pP;
    }

    public Double total(Timestamp ent, Timestamp sai) { //metodo para calcular os valor total
        Calendar entrada = Calendar.getInstance(); //cria um objeto da classe calendar
        entrada.setTime(ent);
        Calendar saida = Calendar.getInstance(); //cria um objeto da classe calendar
        saida.setTime(sai);
        long diferenca = saida.getTimeInMillis() - entrada.getTimeInMillis();  // Calcula a diferença de dias entre a saida e da data de entrada
        int tempoHora = 1000 * 60 * 60;  // Quantidade de milissegundos em uma hora       
        Double totalHoras = (double) diferenca / tempoHora; //calculo das horas
        totalHoras = Math.ceil(totalHoras); // arredonda horas para cima
        if (entrada.get(Calendar.DATE) == saida.get(Calendar.DATE)) { // se for o mesmo dia da entrada e da saida

            if (entrada.get(Calendar.DAY_OF_WEEK) == 1) { //se for domingo
                this.precoTotal = this.precoDomingo; //pega valor que foi definido para o domingo que é unico
            } else {
                if (entrada.get(Calendar.HOUR) == saida.get(Calendar.HOUR)) // se entrou e saiu na mesma hora cheia
                {
                    this.precoTotal = this.primeiraHora; // pega o valor da primeira hora
                } else {
                    this.precoTotal = this.primeiraHora + ((totalHoras - 1) * this.precoHora); // soma total de horas com o preco normal
                }
            }
        } else { // se for dias diferentes
            Double fechamentoDia = (double) 24 - entrada.get(Calendar.HOUR_OF_DAY); // quantia de horas do primeiro dia
            totalHoras -= fechamentoDia; // calcula o restante de horas pendentes

            ArrayList<Double> dias = new ArrayList();//cria um arraylist de dias

            if (entrada.get(Calendar.DAY_OF_WEEK) == 1) { // se a entrada for domingo
                dias.add(this.precoDomingo); // add precoDomingo no arrayList
            } else { // se não for domingo
                dias.add(((fechamentoDia - 1) * this.precoHora) + this.primeiraHora);//calcula o valor do dia  - 1 pq a primeira hora n conta
            }

            while (true) {
                entrada.add(Calendar.DATE, +1); // vai para o proximo dia
                if (totalHoras > 24) { // se faltar mais de um dia | não for ultimo dia
                    if (entrada.get(Calendar.DAY_OF_WEEK) == 1) { // se for domingo
                        dias.add(this.precoDomingo);//adiciona no array o preco de domingo
                    } else {
                        dias.add((23 * this.precoHora) + this.primeiraHora); // calcula o preco do dia inteiro
                    }
                    totalHoras -= 24; // diminuir 24 horas do total

                } else { // se for o ultimo dia

                    if (entrada.get(Calendar.DAY_OF_WEEK) == 1) { // domingo
                        dias.add(this.precoDomingo);//add o preco de domingo no array

                    } else if (entrada.get(Calendar.HOUR_OF_DAY) == saida.get(Calendar.HOUR_OF_DAY)) {//se for na mesma hora a entrada e a saida
                        dias.add(this.primeiraHora); // add a valor da primeira hora no array

                    } else if (entrada.get(Calendar.HOUR_OF_DAY) != saida.get(Calendar.HOUR_OF_DAY)) {//se n for na mesma hora
                        dias.add(((totalHoras - 1) * this.precoHora) + this.primeiraHora); // calcula o preco pelo restante de horas
                    }
                    break;
                }
            }
            for (Double n : dias) { // add todos os valores do arrrayList 
                this.precoTotal += n; // soma todos os valores do arraylist
            }
        }
        return precoTotal; // retorna preco total
    }
}
