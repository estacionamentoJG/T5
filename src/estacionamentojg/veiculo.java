package estacionamentojg;

import java.util.ArrayList;

public class veiculo {

    private String placa;
    private String modelo;
    private String cor;
    private ArrayList<String> modelos;

    public veiculo() {
        this.modelos = new ArrayList<>(100);
    }
    
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
    
    public void setCor(){
        this.cor = cor;
    }

    public ArrayList<String> getModelos (){
        return modelos;
    }

    public void setModelos (ArrayList<String> modelos ){
        this.modelos = modelos;
    }
}


