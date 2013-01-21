package estacionamentojg;

import java.sql.Timestamp;
import java.util.Date;

public class Veiculo {

    private String placa;
    private String modelo;
    private String cor;
    private Timestamp datahoraINICIAL;
    private Timestamp datahoraFINAL;
    
    public String getPlaca(){
        return placa;
    }
    
    public void setPlaca(String placa){
        this.placa = placa;
    }
    
    public String getModelo(){
        return modelo;
    }
    
    public void setModelo(String modelo ){
        this.modelo = modelo;
    }

    public String getCor(){
        return cor;
    }
    
    public void setCor(String cor){
        this.cor = cor;
    }
    
    public Timestamp getEntrada(){
        Date entrada = new Date();
        datahoraINICIAL = new Timestamp(entrada.getTime());
        return datahoraINICIAL;
    }
    
    public Timestamp getSaida(){
        Date saida = new Date();
        datahoraFINAL = new Timestamp(saida.getTime());
        return datahoraFINAL;
    }

}