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

    public void diario(String data) throws Exception {
        data = getData(data);

        criaDiretorio(r);
        criaDiretorio(d);
        BD bd = new BD();
        
        String dados = bd.relDiario(data);     
        if (dados != null) {
            String nomePDF = geraPDF(d, dados);
            //System.out.println(nomePDF);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(nomePDF)); // abrir pdf automaticamente
        }
    }

    public void mensal(String data) throws Exception {
        data = getData(data);

        criaDiretorio(r);
        criaDiretorio(m);
        BD bd = new BD();
        
        String dados = bd.relMensal(data);    
        if (dados != null) {
            String nomePDF = geraPDF(m, dados);
            abrePDF(nomePDF);
        }
    }
    
    private void abrePDF(String nomePDF) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(nomePDF)); // abrir pdf automaticamente
    }

    private String geraPDF(String pasta, String dados) throws Exception {

        String nomePDF = null;

        Document doc = null;
        OutputStream os = null;
        String titulo = null;
        String abas = "\n\nPlaca\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tData/hora de entrada\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"
                + "Data/hora de saída\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tValor\n";

        try {
            doc = new Document(PageSize.A4, 72, 72, 72, 72); //cria o documento tamanho A4, margens de 2,54cm

            if (pasta.equals(d)) {
                nomePDF = pasta + "/RD" + data() + ".pdf";
                os = new FileOutputStream(nomePDF); //cria a stream de saída
                titulo = "Relatorio Diario - Estacionamento JG";                
            } else if (pasta.equals(m)) {
                nomePDF = pasta + "/RM" + data() + ".pdf";
                os = new FileOutputStream(nomePDF); //cria a stream de saída
                titulo = "Relatorio Mensal - Estacionamento JG";
            }


            PdfWriter.getInstance(doc, os); //associa a stream de saída ao
            doc.open(); //abre o documento

            Paragraph p = new Paragraph(titulo);
            doc.add(p);
            
            p = new Paragraph(abas);
            doc.add(p);

            p = new Paragraph(dados);
            doc.add(p);

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

    private void criaDiretorio(String nome) {
        File diretorio = new File(nome);

        if (!diretorio.exists()) // se diretorio ainda não foi criado
        {
            diretorio.mkdir(); // cria diretorio 
        }
    }

    private String data() {
        Date data = new Date();
        Timestamp timestamp = new Timestamp(data.getTime());
        String aux = timestamp.toString();
        String sData = "";
        for (int i = 0; i < 20; i++) {
            if (i == 13) {
                sData += 'h';
            } else if (i == 16) {
                sData += 'm';
            } else if (i == 19) {
                sData += 's';
            } else {
                sData += aux.charAt(i);
            }
        }
        //System.out.println(sData);
        return sData;
    }

    private String getData(String data) {
        String d = "";
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
        return d;
    }
}
