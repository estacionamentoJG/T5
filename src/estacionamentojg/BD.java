package estacionamentojg;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BD {
    
    private Connection pegaConexao() {
        try {
            String url = "jdbc:postgresql://localhost:5432/estacionamentojg";
            String usuario = "postgres";
            String senha = "12345";
            
            Connection con = DriverManager.getConnection(url, usuario, senha);
            return con;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private Statement conecta(){
        try {
            Class.forName("org.postgresql.Driver");
            //System.out.println("Conexão realizada com sucesso.");

            Statement s = pegaConexao().createStatement();
            return s;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void setEstacionado(String modelo, String placa, String cor) {
        try {
            ResultSet rs = conecta().executeQuery("INSERT INTO estacionados(placa, modelo, cor) VALUES " +  placa + " " + modelo + " " + cor + ";"); // pega modelos em ordem alfabética
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public ArrayList getModelos() {
        try {
            //System.out.println("listando os carros");
            ResultSet rs = conecta().executeQuery("SELECT * FROM carros ORDER BY modelo ASC;"); // pega modelos em ordem alfabética

            ArrayList<String> dados = new ArrayList<String>();
            while (rs.next()) {
                //System.out.println(rs.getInt("id") + " - " + rs.getString("modelo"));
                dados.add(rs.getString("modelo"));
            }
            pegaConexao().close();
            return dados;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
