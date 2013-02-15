package estacionamentojg;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BD {

    private Connection pegaConexao() {
        try {
            String url = "jdbc:postgresql://localhost:5432/estacionamentojg";
            String usuario = "postgres";
            String senha = "12345";

            Connection con = DriverManager.getConnection(url, usuario, senha);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Statement conecta() {
        try {
            Class.forName("org.postgresql.Driver");
            //System.out.println("Conexão realizada com sucesso.");

            Statement s = pegaConexao().createStatement();
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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

    public Boolean Estacionado(String modelo, String placa, String cor, Timestamp entrada, String dia, Double pN, Double pH) { // insere no banco os carros que entraram no estacionamento
        try {
            ResultSet rs = conecta().executeQuery("SELECT COUNT(*) FROM estacionados WHERE placa='" + placa + "'"); // conta vezes que o veiculo foi cadastrado e não saiu do estacionamento
            int cont = 0;
            while (rs.next()) {
                cont = rs.getInt(1); // pega valor de vezes que ocorre a placa sem saida
                //System.out.println(cont);
            }
            if (cont == 0) { // se a placa ainda não foi cadastrada
                conecta().execute("INSERT INTO estacionados (placa, modelo, cor, datahora_inicial, dia, primeira_hora, preco_hora) "
                        + "VALUES ('" + placa + "', '" + modelo + "', '" + cor + "', '" + entrada + "', '" + dia + "', '" + pN + "', '" + pH + "');"); // insere carro estacionado
                pegaConexao().close();
                JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!"); // mensagem ao usuário
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "ERRO! Carro já cadastrado."); // mensagem ao usuário
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRO! Tente novamente."); // mensagem ao usuário
            return false;
        }
    }

    public Boolean Encerrado(String placa, Timestamp saida) { // insere no banco os carros que entraram no estacionamento
        try {
            ResultSet rs = conecta().executeQuery("SELECT * FROM estacionados WHERE placa='" + placa + "' "); // conta vezes que o veiculo foi cadastrado e não saiu do estacionamento
            Timestamp entrada = null;
            String diaEntrada = null;
            Double pP = null;
            Double pH = null;
            int cont = 0;

            while (rs.next()) {
                entrada = rs.getTimestamp("datahora_inicial"); // pega Timestamp de entrada da placa
                pP = rs.getDouble("primeira_hora");
                pH = rs.getDouble("preco_hora");
                System.out.println("to aqui: " + pP + "        " + pH);
                cont++; // pega valor de vezes que ocorre a placa sem saida
            }

            if (cont != 0) { // se placa está cadastrada
                Valores valor = new Valores(pP, pH);

                Double preco = valor.total(entrada, saida);
                System.out.println(preco);
                new PrecoTotal(preco); // janela de preço

                conecta().execute("INSERT INTO encerrados (placa, datahora_inicial, datahora_final, valor) VALUES ('" + placa + "', '" + entrada + "', '" + saida + "', '" + preco + "');"); // insere carro encerrado
                conecta().execute("DELETE FROM estacionados WHERE placa = '" + placa + "'"); // deleta carro estacionado
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "ERRO! Placa não cadastrada."); // mensagem ao usuário
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRO! Tente novamente."); // mensagem ao usuário
            return false;
        }
    }

    public Boolean buscaPlaca(String placa) {
        try {
            ResultSet rs = conecta().executeQuery("SELECT * FROM estacionados WHERE placa='" + placa + "'");
            String achou = null;
            while (rs.next()) {
                //System.out.println(rs.getString("modelo") + " - " + rs.getString("cor") + " - " + rs.getString("placa"));
                achou = rs.getString("placa");
            }
            //System.out.println(achou);
            pegaConexao().close();
            if (achou != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String relDiario(String diaTT) {

        getData(diaTT);

        String total = "\n\n";
        Double valorTotal = 0.0;
        Date data = new java.util.Date();
        Timestamp dia = new Timestamp(data.getTime());

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(dia);

        String dataAtual = c1.get(Calendar.DAY_OF_MONTH) + "." + (c1.get(Calendar.MONTH) + 1) + "." + c1.get(Calendar.YEAR);
        String dataBanco;
        int cont = 0;

        System.out.println(dataAtual);
        /*System.out.println(c1.get(Calendar.DAY_OF_MONTH));
         System.out.println(c1.get(Calendar.MONTH)+1); mes começa no 0
         System.out.println(c1.get(Calendar.YEAR));*/

        try {
            ResultSet rs = conecta().executeQuery("SELECT * FROM encerrados;");
            while (rs.next()) {
                c2.setTime(rs.getTimestamp("datahora_final"));
                dataBanco = c2.get(Calendar.DAY_OF_MONTH) + "." + (c2.get(Calendar.MONTH) + 1) + "." + c2.get(Calendar.YEAR);
                if (dataBanco.equals(dataAtual)) {
                    total += rs.getString("placa");
                    total += "\t\t\t\t\t\t\t\t\t\t";
                    total += rs.getTimestamp("datahora_inicial").toString();
                    total += "\t\t\t\t\t\t\t\t\t\t";
                    total += rs.getTimestamp("datahora_final").toString();
                    total += "\t\t\t\t\t\t\t\t\t\t";
                    total += "R$ " + String.format("%.2f", rs.getDouble("valor"));
                    total += "\n";
                    valorTotal += rs.getDouble("valor");
                    cont++;
                }
            }

            total += "\n\n";
            total += "total de carros: " + cont;
            total += "            ";
            total += "valor total: R$ " + String.format("%.2f", valorTotal);;

            return total;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String relMensal() {

        return null;
    }

    private String getData(String data) {
        String d = "";
        System.out.println(data.charAt(3));

        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == '/') {
                d += '.';
            } else {
                if (i == 0 || i == 3) {
                    if (data.charAt(i) != '0') {
                        d += data.charAt(i);
                    }
                } else {
                    d += data.charAt(i);
                }
            }
        }
        System.out.println("aqui> " + d);
        return d;
    }
}
