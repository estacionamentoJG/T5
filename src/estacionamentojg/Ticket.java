package estacionamentojg;

import java.awt.Color;
import java.sql.Timestamp;
import javax.swing.JLabel;

public class Ticket extends javax.swing.JFrame {

    private String modelo;
    private String placa;
    private String cor;
    private String data;
    private String dia;
    private Timestamp datahora;
    private JLabel jModelo = new javax.swing.JLabel(); //cria objeto jmodelo da classe jlabel
    private JLabel jPlaca = new javax.swing.JLabel();//cria objeto jplaca da classe jlabel
    private JLabel jCor = new javax.swing.JLabel();//cria objeto jcor da classe jlabel
    private JLabel jDatahora = new javax.swing.JLabel();//cria objeto jdatahora da classe jlabel
    
    public void setModelo(String modelo) { //metodo para setar o modelo
        this.modelo = modelo;
    }
    
    public void setPlaca(String placa){ //metodo para setar a placa
        this.placa = placa;        
    }
    
    public void setCor(String cor) { //metodo para setar a cor
        this.cor = cor;
    }
    
    public void setDia(String dia) { //metodo para setar dia
        this.dia = dia;
    }
    
    public void setDatahora(Timestamp datahora) { //metodo para setar data e  hora
        this.datahora = datahora;
    }
    
    public String timestampToString() { //metodo para transformar a data em string
        this.data = "" + this.datahora; //concatena a string com a datahora
        return this.data;
    }

    public void textoJLabel() { //metodo para configurar o modelo,placa,cor e data
        jModelo.setFont(new java.awt.Font("Calibri", 0, 18));
        jModelo.setText(modelo);

        jPlaca.setFont(new java.awt.Font("Calibri", 0, 48));
        jPlaca.setText(placa);

        jCor.setFont(new java.awt.Font("Calibri", 0, 18));
        jCor.setText(cor);

        jDatahora.setFont(new java.awt.Font("Calibri", 0, 18));
        jDatahora.setText(timestampToString() + " " + this.dia);
    }

    public void emite() { //metodo para emitir ticket
        textoJLabel(); //chama metodo para setar os dados
        initComponents();
        setLocationRelativeTo(null); //nao precisa posicionar no centro
        this.setVisible(true);
        this.setSize(300, 400);//define tamanho da janela
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = jDatahora;
        jLabel8 = jPlaca;
        jLabel9 = jModelo;
        jLabel10 = jCor;
        jLabel11 = new javax.swing.JLabel();
        fechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estacionamento JG - Ticket");
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel1.setText("Ticket comprovante de estacionamento");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel2.setText("Placa:");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel3.setText("modelo:");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel4.setText("cor:");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Estacionamento JG LTDA");
        jLabel5.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel6.setText("Data/hora de ent.:");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel11.setText("Obrigado pela preferência.");

        fechar.setText("Fechar");
        fechar.setToolTipText("");
        fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel5))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fechar)))))
                .addContainerGap(418, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(2, 2, 2)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechar))
                .addContainerGap(256, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharActionPerformed
        this.dispose();//acao de fechar para o botao fechar
    }//GEN-LAST:event_fecharActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
}
