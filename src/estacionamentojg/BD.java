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

    private Connection pegaConexao() { //metodo para criar uma conexao com o banco
        try {
            String url = "jdbc:postgresql://localhost:5432/estacionamentojg";  //define o caminho
            String usuario = "postgres"; //define o usuario
            String senha = "12345"; //define a senha

            Connection con = DriverManager.getConnection(url, usuario, senha); //cria conexao com banco atraves de um driver passando a url,usuario,senha
            return con; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Statement conecta() { //metodo para conectar no banco
        try {
            Class.forName("org.postgresql.Driver");
            Statement s = pegaConexao().createStatement(); 
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList getModelos() { //pega modelos de carros do banco 
        try {
            ResultSet rs = conecta().executeQuery("SELECT * FROM carros ORDER BY modelo ASC;"); //consulta para pegar modelos em ordem alfabética
            ArrayList<String> dados = new ArrayList<>();//cria um objeto dados da classe arraylist

            while (rs.next()) { //consulta para navegar no banco enquanto tiver dados para serem adicionados
                dados.add(rs.getString("modelo"));//add o modelo 
            }
            pegaConexao().close();//termina conexao
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
                cont = rs.getInt(1); // pega valor de vezes que a placa esta presente na tabela estacionados
            }
            if (cont == 0) { // se a placa ainda não foi cadastrada
                conecta().execute("INSERT INTO estacionados (placa, modelo, cor, datahora_inicial, dia, primeira_hora, preco_hora) "
                        + "VALUES ('" + placa + "', '" + modelo + "', '" + cor + "', '" + entrada + "', '" + dia + "', '" + pN + "', '" + pH + "');"); // insere carro estacionado
                pegaConexao().close();
                JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!"); // mensagem ao usuário
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "ERRO! Carro já cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE); // mensagem ao usuário
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRO! Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE); // mensagem ao usuário
            return false;
        }
    }

    public Boolean Encerrado(String placa, Timestamp saida) { // insere no banco os carros que sairam do estacionamento
        try {
            ResultSet rs = conecta().executeQuery("SELECT * FROM estacionados WHERE placa='" + placa + "' "); // busca a placa que ira sair dentro da tabela estacionados
            Timestamp entrada = null;
            String diaEntrada = null;
            Double pP = null;
            Double pH = null;
            int cont = 0;

            while (rs.next()) {
                entrada = rs.getTimestamp("datahora_inicial"); // pega Timestamp de entrada da placa
                pP = rs.getDouble("primeira_hora");//pega valor da primeira hora definido
                pH = rs.getDouble("preco_hora");//pega valor do preço da hora definido
                cont++; // pega valor de vezes que a placa esta registrada
            }

            if (cont != 0) { // se placa está cadastrada
                Valores valor = new Valores(pP, pH); //cria um objeto valor da classe valores recebendo os preço da primeira hora e o preco da hora definidos
                Double preco = valor.total(entrada, saida);//recebe o preco total
                new PrecoTotal(preco); // janela de preço

                conecta().execute("INSERT INTO encerrados (placa, datahora_inicial, datahora_final, valor) VALUES ('" + placa + "', '" + entrada + "', '" + saida + "', '" + preco + "');"); // insere carro encerrado
                conecta().execute("DELETE FROM estacionados WHERE placa = '" + placa + "'"); // deleta carro da tabela estacionado
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "ERRO! Placa não cadastrada.", "Erro", JOptionPane.ERROR_MESSAGE); // mensagem ao usuário
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO! Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE); // mensagem ao usuário
            return false;
        }
    }

    public Boolean buscaPlaca(String placa) { //metodo para buscar a placa dentro da tabela estacionados
        try {
            ResultSet rs = conecta().executeQuery("SELECT * FROM estacionados WHERE placa='" + placa + "'");//consulta para buscar a placa desejada dentro da tabela estacionados
            String achou = null;
            while (rs.next()) { //laço para buscar a placa desejada
                achou = rs.getString("placa");
            }
            pegaConexao().close();
            if (achou != null) { //condicao para verificar se achou ou nao a placa
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public String relDiario(String dataAtual) { //metodo para gerar o relatorio diario

        String total = "";
        Double valorTotal = 0.0;
        int cont = 0;
        Calendar c = Calendar.getInstance(); // cria um objeto da classe calendar
        String dataBanco;
        try {
            ResultSet rs = conecta().executeQuery("SELECT * FROM encerrados;"); //busca todos valores da tabela encerrados
            while (rs.next()) {//laço para passar os valores para o relatorio diario
                c.setTime(rs.getTimestamp("datahora_final"));//para o valor da data e hora da saida
                dataBanco = c.get(Calendar.DAY_OF_MONTH) + "." + (c.get(Calendar.MONTH) + 1) + "." + c.get(Calendar.YEAR);//pega o dia.mes.ano
                if (dataBanco.equals(dataAtual)) {//condicao para verificar se a data requisitada é igual a data do banco
                    total += rs.getString("placa");//pega placa
                    total += "\t\t\t\t\t\t\t\t\t\t";
                    total += rs.getTimestamp("datahora_inicial").toString();//pega datahora inicial
                    total += "\t\t\t\t\t\t\t\t\t\t";
                    total += rs.getTimestamp("datahora_final").toString();//pega data e hora final
                    total += "\t\t\t\t\t\t\t\t\t\t";
                    total += "R$ " + String.format("%.2f", rs.getDouble("valor")); //pega valor gasto pelo carro
                    total += "\n";
                    valorTotal += rs.getDouble("valor"); // pega valor do carro e adiciona no total
                    cont++;
                }
            }
            total += "\n\n";
            total += "total de carros: " + cont; //informa o numero de carros
            total += "            ";
            total += "valor total: R$ " + String.format("%.2f", valorTotal);;//informa o valor total recebido no dia
            if (cont == 0) {//condicao para data nao encontrada
                JOptionPane.showMessageDialog(null, "Data não encontrada", "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            return total;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String relMensal(String dataAtual) {//metodo para gerar o relatorio mensal
        String total = "";
        Double valorTotal = 0.0;
        Calendar c = Calendar.getInstance();//cria um objeto da classe calendar
        String dataBanco;
        int cont = 0;
        try {
            ResultSet rs = conecta().executeQuery("SELECT * FROM encerrados;");//consulta para buscar todos valores da tabela encerrados
            while (rs.next()) {
                c.setTime(rs.getTimestamp("datahora_final"));//pega data e hora final
                dataBanco = (c.get(Calendar.MONTH) + 1) + "." + c.get(Calendar.YEAR);//pega o mes.ano
                if (dataBanco.equals(dataAtual)) { //se a data requisitada é igual a data do banco
                    total += rs.getString("placa");//pega placa
                    total += "\t\t\t\t\t\t\t\t\t\t";
                    total += rs.getTimestamp("datahora_inicial").toString();//pega data e hora que entrou o carro
                    total += "\t\t\t\t\t\t\t\t\t\t";
                    total += rs.getTimestamp("datahora_final").toString();//pega data e hora que saiu o carro
                    total += "\t\t\t\t\t\t\t\t\t\t";
                    total += "R$ " + String.format("%.2f", rs.getDouble("valor"));//pega o valor gasto pelo carro
                    total += "\n";
                    valorTotal += rs.getDouble("valor"); //acumula o valor gasto no total gasto 
                    cont++;
                }
            }
            total += "\n\n";
            total += "total de carros: " + cont;//informa o numero de carros
            total += "            ";
            total += "valor total: R$ " + String.format("%.2f", valorTotal);;//informa o valor total

            if (cont == 0) {
                JOptionPane.showMessageDialog(null, "Data não encontrada", "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            return total;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
