package estacionamentojg;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Veiculo {

    private String placa;
    private String modelo;
    private String cor;
    private Timestamp timestampINICIAL;
    private Timestamp timestampFINAL;
    private Date dataInicial;
    private Date dataFinal;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setEntrada() {
        dataInicial = new Date();
        timestampINICIAL = new Timestamp(dataInicial.getTime());
    }

    public void setSaida() {
        dataFinal = new Date();
        timestampFINAL = new Timestamp(dataFinal.getTime());
    }

    public Timestamp getEntrada() {
        return timestampINICIAL;
    }

    public Timestamp getSaida() {
        return timestampFINAL;
    }

    public String diaDaSemanaInicial() {
        Locale local1 = new Locale("pt", "BR"); // transforma para Português, Brasil
        String dia = new SimpleDateFormat("EEE", local1).format(dataInicial);
        return dia;
    }

    public String diaDaSemanaFinal() {
        Locale local1 = new Locale("pt", "BR"); // transforma para Português, Brasil
        String dia = new SimpleDateFormat("EEE", local1).format(dataFinal);
        return dia;
    }
}