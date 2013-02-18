package estacionamentojg;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

public class RegistraSaida extends javax.swing.JFrame {

    MaskFormatter mPLACA = new MaskFormatter();//cria objeto mPlaca da classe MaskFormatter

    public RegistraSaida() {//cria construtor
        initComponents();
        setLocationRelativeTo(null); // coloca janela no centro da pagina 
        setVisible(true);
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
        setTitle("Estacionamento JG - Registro de Saída");

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("Placa");

        placa.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N

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
        Veiculo carro = new Veiculo(); // cria objeto carro da classe veiculo
        BD registra = new BD(); // cria objeto registra da classe bd
        carro.setPlaca(placa.getText());// pega valor da placa
        carro.setSaida();//seta o valor de saida
        carro.getSaida(); // inicia data e hora de saida
        Boolean a = true;

        for (int i = 0; i < placa.getText().length(); i++) {//laco com condicao para nao deixar registar se o usuario for registrar a placa com _ 
            if (placa.getText().charAt(i) == '_') {
                a = false;
            }
        }

        if (a == true) {//condicao registrar a saida do carro
            Boolean result = registra.Encerrado(carro.getPlaca(), carro.getSaida()); // insere carro encerrado na tabela encerrados do bd
            if (result == true) {//se foi registrado
                this.dispose();   // fechar janela
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Erro, placa inválida.", "Erro", JOptionPane.ERROR_MESSAGE);

    }//GEN-LAST:event_encerrarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.dispose(); // acao de fechar janela no botao cancelar
    }//GEN-LAST:event_cancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JButton encerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JFormattedTextField placa;
    // End of variables declaration//GEN-END:variables
}
