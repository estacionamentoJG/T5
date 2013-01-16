package estacionamentojg;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RegistraEntrada extends javax.swing.JFrame {

    MaskFormatter mPLACA = new MaskFormatter();
    BD c = new BD();
    Veiculo carro = new Veiculo();

    public RegistraEntrada() {
        initComponents();
        setLocationRelativeTo(null); // coloca janela no centro da pagina 
        try {
            mPLACA.setMask("UUU-####"); // mascara para placa
            mPLACA.setPlaceholderCharacter('_'); // caracter que fica ocupando o espaço
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private JComboBox addComboBox(ArrayList x) {
        JComboBox cb = new JComboBox(); // cria objeto JComboBox       
        String str; // inicia string
        ArrayList<String> listaModelos = x; // cria arrayList de strings
        for (String n : listaModelos) {
            str = n; // pega cada item
            cb.addItem(n);  // e add no JComboBox
        }
        return cb; // retorna JComboBox
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        placa = new javax.swing.JLabel();
        modelo = new javax.swing.JLabel();
        cor = new javax.swing.JLabel();
        textoCor = new javax.swing.JTextField();
        registrar = new javax.swing.JButton();
        tiposModelo = addComboBox(c.getModelos());
        textoPlaca = new JFormattedTextField(mPLACA);
        jButton1 = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        placa.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        placa.setText("Placa");

        modelo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        modelo.setText("Modelo");

        cor.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        cor.setText("Cor");

        textoCor.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        registrar.setBackground(new java.awt.Color(0, 102, 255));
        registrar.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        registrar.setForeground(new java.awt.Color(255, 255, 255));
        registrar.setText("Registrar");
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        tiposModelo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tiposModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiposModeloActionPerformed(evt);
            }
        });

        textoPlaca.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        textoPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoPlacaActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(placa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modelo)
                            .addComponent(cor, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textoCor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tiposModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(24, 24, 24)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(placa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tiposModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoCor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cor))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(22, 22, 22))
        );

        tiposModelo.getAccessibleContext().setAccessibleParent(tiposModelo);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textoPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoPlacaActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        // AÇÃO DO BOTÃO REGISTRAR

        carro.setPlaca(textoPlaca.getText());// pega placa escrita
        carro.setModelo((String) tiposModelo.getSelectedItem()); // converte em string o item selecionado
        carro.setCor(textoCor.getText()); // pega cor escrita
        System.out.println(carro.getPlaca() + " " + carro.getModelo() + " " + carro.getCor());

        BD registra = new BD(); // cria objeto BD
        Boolean result = registra.setEstacionado(carro.getModelo(), carro.getPlaca(), carro.getCor(), carro.getEntrada()); // insere carro estacionado
        
        if (result == true) {
            JOptionPane.showMessageDialog(this, "Carro cadastrado com sucesso!"); // mensagem ao usuário
            this.dispose();   // fechar janela
        }
        else
            JOptionPane.showMessageDialog(this, "ERRO! Tente novamente."); // mensagem ao usuário
    }//GEN-LAST:event_registrarActionPerformed

    private void tiposModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiposModeloActionPerformed

    }//GEN-LAST:event_tiposModeloActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void principal() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistraEntrada().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cor;
    private javax.swing.JButton jButton1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel modelo;
    private javax.swing.JLabel placa;
    private javax.swing.JButton registrar;
    private javax.swing.JTextField textoCor;
    private javax.swing.JFormattedTextField textoPlaca;
    private javax.swing.JComboBox tiposModelo;
    // End of variables declaration//GEN-END:variables
}
