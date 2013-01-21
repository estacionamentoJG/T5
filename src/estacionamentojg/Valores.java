package estacionamentojg;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Valores {

    public Double total(Timestamp entrada, Timestamp saida) {

        return null;
    }

    public String DiaDaSemana(int ano, int mes, int dia) {

        Calendar calendario = new GregorianCalendar(ano, mes - 1, dia);
        int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);


        return null;
    }
}
