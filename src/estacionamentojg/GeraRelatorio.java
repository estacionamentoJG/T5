package estacionamentojg;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeraRelatorio {

    private String r = "Relatorios";
    private String d = "Relatorios/Relatorios Diarios";
    private String m = "Relatorios/Relatorios Mensais";

    public void diario(String data) throws Exception { //metodo que gera o relatorio diario da data solicitada
        data = getData(data);//pega a data solicitada

        criaDiretorio(r);// cria diretorio relatorios
        criaDiretorio(d);// cria diretorio relatorios/relatorios diarios
        BD bd = new BD();//cria objeto bd da classe BD
        
        String dados = bd.relDiario(data);      //passa os dados registrados no banco que tem a data desejada
        if (dados != null) {
            String nomePDF = geraPDF(d, dados);//gera o pdf  na pasta rel/rel diarios com os dados da data desejada   
            Desktop desktop = Desktop.getDesktop();//cria um objeto desktop da classe desktop para ser usado para abrir o pdf aut
            abrePDF(nomePDF);//abre pdf automaticamente
        }
    }

    public void mensal(String data) throws Exception { //metodo que gera o relatorio mensal da data solicitada
        data = getData(data); //pega a data solicitada

        criaDiretorio(r);//cria o diretorio relatorio
        criaDiretorio(m);//cria o diretorio relatorio/relatorios mensais
        BD bd = new BD();//cria um objeto bd da classe BD
        
        String dados = bd.relMensal(data);//passa os dados registrados no banco que tem a data desejada    
        if (dados != null) {//se a data for encontrada
            String nomePDF = geraPDF(m, dados); // gera o pdf na pasta rel/rel mensais com os dados da data desejada
            abrePDF(nomePDF);//abre pdf automaticamente
        }
    }
    
    private void abrePDF(String nomePDF) throws IOException {//metodo para abrir o pdf automaticamente no desktop
        Desktop desktop = Desktop.getDesktop(); // cria objeto desktop da classe Desktop
        desktop.open(new File(nomePDF)); // abrir pdf automaticamente
    }

    private String geraPDF(String pasta, String dados) throws Exception {//metodo para gerar o pdf

        String nomePDF = null;
        Document doc = null;
        OutputStream os = null;
        String titulo = null;
        String abas = "\n\nPlaca\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tData/hora de entrada\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"
                + "Data/hora de saída\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tValor\n";
        try {
            doc = new Document(PageSize.A4, 72, 72, 72, 72); //cria o documento tamanho A4, margens de 2,54cm
            if (pasta.equals(d)) {//se a pasta for de rel/rel diarios   
                nomePDF = pasta + "/RD" + data() + ".pdf";//arruma o nome do pdf para ficar dentro da pasta rd com seu nome certo
                os = new FileOutputStream(nomePDF); //cria a stream de saída
                titulo = "Relatorio Diario - Estacionamento JG";//coloca o titulo do pdf dos relatorios diarios       
            } else if (pasta.equals(m)) {//se a pasta for de rel/rel mensais
                nomePDF = pasta + "/RM" + data() + ".pdf";//arruma o nome do pdf para ficar dentro da pasta rm com seu nome certo
                os = new FileOutputStream(nomePDF); //cria a stream de saída
                titulo = "Relatorio Mensal - Estacionamento JG";//coloca o titulo do pdf nos relatorios mensais
            }


            PdfWriter.getInstance(doc, os); //associa a stream de saída ao pdfwriter
            doc.open(); //abre o documento

            Paragraph p = new Paragraph(titulo);//cria um paragrafo dentro do pdf com o titulo
            doc.add(p); //adiciona o titulo no pdf
            
            p = new Paragraph(abas);//cria um paragrafo dentro do pdf com as abas
            doc.add(p);//adiciona as abas no pdf

            p = new Paragraph(dados);//cria um paragrafo dentro do pdf com os dados
            doc.add(p);//adiciona os dados no pdf

            return nomePDF;

        } finally {
            if (doc != null) {
                doc.close(); //fechamento do documento
            }
            if (os != null) {
                os.close(); //fechamento da stream de saída
            }
        }
    }

    private void criaDiretorio(String nome) {//metodo para criar um diretorio
        File diretorio = new File(nome);//objeto diretorio da classe File com o nome passado pelo metodo

        if (!diretorio.exists()) // se diretorio ainda não foi criado
        {
            diretorio.mkdir(); // cria diretorio 
        }
    }

    private String data() {// metodo que transforma timestamp em string para titulo do pdf
        Date data = new Date(); //cria objeto data da classe date
        Timestamp timestamp = new Timestamp(data.getTime());// cria objeto timestamp da clase Timestamp passando da data desejada
        String aux = timestamp.toString();//transforma a data para string
        String sData = "";
        for (int i = 0; i < 20; i++) {//laco que percorre timestamp e para antes dos centésimos
            if (i == 13) {
                sData += 'h';
            } else if (i == 16) {
                sData += 'm';
            } else if (i == 19) {
                sData += 's';
            } else {
                sData += aux.charAt(i); // concatena todas as posições numa nova string
            }
        }
        return sData; // retorna timestamp editada como string
    }

    private String getData(String data) { //metodo para pegar a data e alterar sua estrutura
        String d = ""; 
        for (int i = 0; i < data.length(); i++) {//laco para alterar a barra por ponto e retirar o 0 do dia e do mes
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
        return d;
    }
}
