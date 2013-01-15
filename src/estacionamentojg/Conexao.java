package estacionamentojg;

import java.sql.*;
import java.util.ArrayList;

public class Conexao {

    public static void main(String[] args) {
        try {

            String url = "jdbc:postgresql://localhost:5432/estacionamentojg";
            String usuario = "postgres";
            String senha = "12345";

            Class.forName("org.postgresql.Driver");

            Connection con;

            con = DriverManager.getConnection(url, usuario, senha);

            System.out.println("Conexão realizada com sucesso.");

            Statement s = con.createStatement();
            System.out.println("listando os carros");
            ResultSet rs = s.executeQuery("SELECT * FROM carros");

           ArrayList<String> dados = new ArrayList<String>();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("modelo"));
                dados.add(rs.getString("modelo"));
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
