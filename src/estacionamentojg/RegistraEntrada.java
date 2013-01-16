package estacionamentojg;

import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;


public class RegistraEntrada extends javax.swing.JFrame {

    MaskFormatter mPLACA = new MaskFormatter();
    BD c = new BD();
    
    public RegistraEntrada() {
        initComponents();
        try {
            mPLACA.setMask("UUU-####");
            mPLACA.setPlaceholderCharacter('_');
        }
        catch(ParseException e) {
            e.printStackTrace();
        }
    }

    
    @SuppressWarnings("unchecked")
    
    private JComboBox addComboBox(ArrayList x) {
        JComboBox cb = new JComboBox(); // cria objeto JComboBox       
        String str; // inicia string
        ArrayList<String> listaModelos = x; // cria arrayList de strings
        for(String n : listaModelos) {
            str = n; // pega cada item
            cb.addItem(n);  // e add no JComboBox
        }
        return cb; // retorna JComboBox
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        placa = new javax.swing.JLabel();
        modelo = new javax.swing.JLabel();
        cor = new javax.swing.JLabel();
        textoCor = new javax.swing.JTextField();
        registrar = new javax.swing.JButton();
        tiposModelo = addComboBox(c.getModelos());
        textoPlaca = new JFormattedTextField(mPLACA);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        placa.setText("Placa");

        modelo.setText("Modelo");

        cor.setText("Cor");

        registrar.setText("Registrar");
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        tiposModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiposModeloActionPerformed(evt);
            }
        });

        textoPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoPlacaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(151, Short.MAX_VALUE)
                .addComponent(registrar)
                .addGap(159, 159, 159))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(modelo)
                        .addGap(18, 18, 18)
                        .addComponent(tiposModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(placa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cor))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(textoCor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(textoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(placa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tiposModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cor))
                .addGap(42, 42, 42)
                .addComponent(registrar)
                .addGap(51, 51, 51))
        );

        tiposModelo.getAccessibleContext().setAccessibleParent(tiposModelo);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textoPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoPlacaActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        // AÇÃO DO BOTÃO REGISTRAR
        
        String placa1 = textoPlaca.getText(); // pega placa escrita
        String modelo1 = (String) tiposModelo.getSelectedItem(); // converte em string o item selecionado
        String cor1 = textoCor.getText(); // pega cor escrita
        System.out.println(placa1+" "+modelo1+" "+cor1);
        
        BD registra = new BD (); // cria objeto BD
        registra.setEstacionado(modelo1, placa1, cor1); // insere carro estacionado
        
        //System.exit(0); // sair do programa
    }//GEN-LAST:event_registrarActionPerformed

    private void tiposModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiposModeloActionPerformed

    }//GEN-LAST:event_tiposModeloActionPerformed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistraEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistraEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistraEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistraEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistraEntrada().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cor;
    private javax.swing.JLabel modelo;
    private javax.swing.JLabel placa;
    private javax.swing.JButton registrar;
    private javax.swing.JTextField textoCor;
    private javax.swing.JFormattedTextField textoPlaca;
    private javax.swing.JComboBox tiposModelo;
    // End of variables declaration//GEN-END:variables
}
