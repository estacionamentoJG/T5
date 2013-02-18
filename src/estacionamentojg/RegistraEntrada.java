package estacionamentojg;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RegistraEntrada extends javax.swing.JFrame {

    private Double primeiraHora; 
    private Double precoHora;
    MaskFormatter mPLACA = new MaskFormatter(); //cria objeto mPLACA da classe MaskFormatter
    BD c = new BD(); //cria objeto c da classe BD
    Veiculo carro = new Veiculo(); //cria objeto carro da classe Veiculo

    public RegistraEntrada(Double pP, Double pH) {//cria construtor
        setValores(pP, pH);//chama o metodo para setar os valores das variaveis primeiraHora e preçoHora 
        initComponents();
        setLocationRelativeTo(null); // coloca janela no centro da pagina
        setVisible(true);
        try {
            mPLACA.setMask("UUU-####"); // mascara para placa
            mPLACA.setPlaceholderCharacter('_'); // caracter que fica ocupando o espaço
        } catch (ParseException e) { //controle de excecao
            e.printStackTrace();
        }
    }

    private void setValores(Double pP, Double pH) { //cria metodo para setar as variaveis primeiraHora e preçoHora
        this.primeiraHora = pP; 
        this.precoHora = pH;
    }

    @SuppressWarnings("unchecked")
    
    private JComboBox addComboBox(ArrayList x) {//cria um metodo para adicionar dados do ArrayList no combobox
        JComboBox cb = new JComboBox(); // cria objeto cb da classe JComboBox       
        String str; //declara str da classe String
        ArrayList<String> listaModelos = x; // define o tipo da variavel que  armazenara os modelos do banco e recebe a variavel passada por parametro pelo metodo
        cb.addItem("Escolha um modelo...");//adiciona a string no combobox
        for (String n : listaModelos) { //laço para adicionar os valores da lista de modelos do banco no combobox
            str = n; // pega cada item
            cb.addItem(n);  // e add no JComboBox
        }
        cb.addItem("Outro");//adiciona uma string para definir um carro inexistente no banco
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
        setTitle("Estacionamento JG - Registro de Entrada");

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

        textoPlaca.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(placa))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cor, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(modelo, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoCor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tiposModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(textoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(placa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tiposModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelo))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoCor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cor))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        tiposModelo.getAccessibleContext().setAccessibleParent(tiposModelo);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        // AÇÃO DO BOTÃO REGISTRAR

        carro.setPlaca(textoPlaca.getText());// pega valor da placa 
        carro.setModelo((String)tiposModelo.getSelectedItem()); // converte em string o item selecionado
        carro.setCor(textoCor.getText()); // pega valor da cor 
        carro.setEntrada(); // inicia data e hora da entrada
        Boolean a = true;

        for (int i = 0; i < textoPlaca.getText().length(); i++) { //laco com condicao para nao deixar registar se o usuario for registrar a placa com _
            if (textoPlaca.getText().charAt(i) == '_') {
                a = false;
            }
        }
        
        if (textoCor.getText().equals("")) { //laco com condicao para nao deixar registar se o campo cor estiver vazio
            a = false;
        }
        
        if (carro.getModelo().equals("Escolha um modelo...")) {//condicao para nao deixar registar se o usuario nao escolher um modelo
            a = false;
        }
            

        if (a == true) { //condicao para registar o carro 
            BD registra = new BD(); // cria objeto registra da classe BD
            Boolean result = registra.Estacionado(carro.getModelo(), carro.getPlaca(), carro.getCor(), carro.getEntrada(), carro.diaDaSemanaInicial(), this.primeiraHora, this.precoHora); // insere carro estacionado

            if (result == true) { //se carro for registrado passar os dados do carro registrado para o objeto ticket e o ticket eh gerado 
                Ticket ticket = new Ticket(); //cria objeto ticket da classe Ticket
                ticket.setModelo(carro.getModelo());//pega modelo do carro
                ticket.setPlaca(carro.getPlaca());//pega placa do carro
                ticket.setCor(carro.getCor());//pega cor do carro
                ticket.setDia(carro.diaDaSemanaInicial());//pega dia da semana
                ticket.setDatahora(carro.getEntrada());//pega data e hora da entrada do carro
                ticket.emite();//emite o ticket
                this.dispose();   // fechar janela
            }
        }
        else //controle de excecao para caso n registrar o carro
            JOptionPane.showMessageDialog(null, "Erro, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_registrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();//fechar a janela no botao cancelar
    }//GEN-LAST:event_jButton1ActionPerformed

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
