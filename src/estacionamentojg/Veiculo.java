package estacionamentojg;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Veiculo {

    private String placa;
    private String modelo;
    private String cor;
    private Date datahoraINICIAL;
    private Date datahoraFINAL;
    private String datahoraINICIAL1;
    private String datahoraFINAL1;
    
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
    
    public String getEntrada(){
        datahoraINICIAL = new Date();
        datahoraINICIAL1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(datahoraINICIAL);
        return datahoraINICIAL1;
    }
    
    public String getSaida(){
        datahoraFINAL = new Date();
        datahoraFINAL1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(datahoraFINAL);
        return datahoraFINAL1;
    }

}