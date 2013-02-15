package estacionamentojg;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeraRelatorio {

    private String r = "Relatorios";
    private String d = "Relatorios/Relatorios Diarios";
    private String m = "Relatorios/Relatorios Mensais";

    GeraRelatorio(Character tipo) throws Exception {

        switch (tipo) {
            case 'D':
                diario();
                break;
            case 'M':
                mensal();
                break;
        }
    }

    public void diario() throws Exception {
        criaDiretorio(r);
        criaDiretorio(d);
        BD bd = new BD();
        
        String dados = "";
        
        geraPDF(d);
    }

    public void mensal() throws Exception {
        criaDiretorio(r);
        criaDiretorio(m);
        geraPDF(m);
    }

    public void geraPDF(String pasta) throws Exception {
        Document doc = null;
        OutputStream os = null;
        String a = null;

        try {
            doc = new Document(PageSize.A4, 72, 72, 72, 72); //cria o documento tamanho A4, margens de 2,54cm

            if (pasta.equals(d)) {
                os = new FileOutputStream(pasta + "/RD" + data() + ".pdf"); //cria a stream de saída
                a = "Arquivo PDF de relatorio Diario.";
            } else if (pasta.equals(m)) {
                os = new FileOutputStream(pasta + "/RM" + data() + ".pdf"); //cria a stream de saída
                a = "Arquivo PDF de relatorio Mensal.";
            }


            PdfWriter.getInstance(doc, os); //associa a stream de saída ao
            doc.open(); //abre o documento



            Paragraph p = new Paragraph(a);
            doc.add(p);

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

    public static void main(String[] args) throws Exception {
        new GeraRelatorio('D');
        new GeraRelatorio('M');
    }
}
