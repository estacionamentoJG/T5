/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estacionamentojg;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Multiweb-Guilherme
 */
public class RegistraSaida extends javax.swing.JFrame {

    MaskFormatter mPLACA = new MaskFormatter();

    public RegistraSaida() {
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        placa = new JFormattedTextField(mPLACA);
        encerrar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("Placa");

        placa.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        placa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placaActionPerformed(evt);
            }
        });

        encerrar.setBackground(new java.awt.Color(51, 153, 255));
        encerrar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        encerrar.setForeground(new java.awt.Color(255, 255, 255));
        encerrar.setText("Encerrar hospedagem de veículo");
        encerrar.setToolTipText("");
        encerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encerrarActionPerformed(evt);
            }
        });

        cancelar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(placa, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(encerrar)
                        .addGap(36, 36, 36)
                        .addComponent(cancelar)
                        .addGap(53, 53, 53))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(placa, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(encerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void encerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encerrarActionPerformed
        Veiculo carro = new Veiculo();
        BD registra = new BD(); // cria objeto BD
        carro.setPlaca(placa.getText());// pega placa escrita
        
        //System.out.println(carro.getPlaca() + " " + carro.getModelo() + " " + carro.getCor());
        Boolean result = registra.setEncerrado(carro.getPlaca(),carro.getSaida()); // insere carro encerrado
        if (result == true) {
            
            this.dispose();   // fechar janela
        }
        
    }//GEN-LAST:event_encerrarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.dispose(); // fecha janela
    }//GEN-LAST:event_cancelarActionPerformed

    private void placaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_placaActionPerformed

    /**
     * @param args the command line arguments
     */
    public void principal() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistraSaida().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JButton encerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JFormattedTextField placa;
    // End of variables declaration//GEN-END:variables
}
