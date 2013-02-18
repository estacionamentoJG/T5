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

    public String getPlaca() { //metodo para pegar a placa
        return placa;
    }

    public void setPlaca(String placa) { //metodo para setar a placa
        this.placa = placa;
    }

    public String getModelo() { //metodo para pegar o modelo
        return modelo; 
    }

    public void setModelo(String modelo) { //metodo para setar o modelo
        this.modelo = modelo;
    }

    public String getCor() { //metodo para pegar a cor
        return cor;
    }

    public void setCor(String cor) { //metodo para setar a cor
        this.cor = cor;
    }

    public void setEntrada() { //metodo para setar a data de entrada
        dataInicial = new Date();
        timestampINICIAL = new Timestamp(dataInicial.getTime());
    }

    public void setSaida() { //metodo para setar a data de saida
        dataFinal = new Date();
        timestampFINAL = new Timestamp(dataFinal.getTime());
    }

    public Timestamp getEntrada() { // metodo para pegar a data e hora de entrada
        return timestampINICIAL;
    }

    public Timestamp getSaida() {  // metodo para pegar a data e hora de saida
        return timestampFINAL;
    }

    public String diaDaSemanaInicial() { //metodo para transformar o dia da semana em portugues
        Locale local1 = new Locale("pt", "BR"); // transforma para Português o dia da semana, Brasil
        String dia = new SimpleDateFormat("EEE", local1).format(dataInicial); // pega a string do dia da semana
        return dia;
    }
}