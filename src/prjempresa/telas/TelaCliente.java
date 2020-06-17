/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prjempresa.telas;

import java.sql.*;
import javax.swing.JOptionPane;
import prjempresa.dal.ModuloConexao;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author felip
 */
public class TelaCliente extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaCliente
     */
    public TelaCliente() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    private void adicionar() {
        String sql = "insert into tbcliente (nome, fone, endereco, email )"
                + "value (?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, jTextFieldNomeCliente.getText());
            pst.setString(2, jTextFieldTelefoneCliente.getText());
            pst.setString(3, jTextFieldEndCliente.getText());
            pst.setString(4, jTextFieldEmailCliente.getText());

            if ((jTextFieldTelefoneCliente.getText().isEmpty()) || (jTextFieldEmailCliente.getText().isEmpty())
                    || (jTextFieldNomeCliente.getText().isEmpty()) || (jTextFieldEndCliente.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "preencha todos os campos obrigatórios!");

            } else {

                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                    jTextFieldNomeCliente.setText(null);
                    jTextFieldTelefoneCliente.setText(null);
                    jTextFieldEmailCliente.setText(null);
                    jTextFieldEndCliente.setText(null);

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void pesquisar_cliente() {
        String sql = "select * from tbcliente where nome like?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, jTextFieldBuscarCliente.getText() + "%");
            rs = pst.executeQuery();

            jTableCliente.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void setar_campos() {
        int setar = jTableCliente.getSelectedRow();
        jTextFieldIdCliente.setText(jTableCliente.getModel().getValueAt(setar, 0).toString());
        jTextFieldNomeCliente.setText(jTableCliente.getModel().getValueAt(setar, 1).toString());
        jTextFieldTelefoneCliente.setText(jTableCliente.getModel().getValueAt(setar, 2).toString());
        jTextFieldEndCliente.setText(jTableCliente.getModel().getValueAt(setar, 3).toString());
        jTextFieldEmailCliente.setText(jTableCliente.getModel().getValueAt(setar, 4).toString());

        jButtonAdicionarCliente.setEnabled(false);
    }

    private void alterar() {
        String sql = "update tbcliente set nome=?, fone=?, endereco=?, email=?  where idpessoa=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, jTextFieldNomeCliente.getText());
            pst.setString(2, jTextFieldTelefoneCliente.getText());
            pst.setString(3, jTextFieldEndCliente.getText());
            pst.setString(4, jTextFieldEmailCliente.getText());
            pst.setString(5, jTextFieldIdCliente.getText());

            if ((jTextFieldTelefoneCliente.getText().isEmpty()) || (jTextFieldEmailCliente.getText().isEmpty())
                    || (jTextFieldNomeCliente.getText().isEmpty()) || (jTextFieldEndCliente.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "preencha todos os campos obrigatórios!");

            } else {

                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do cliente atualizados com sucesso!");
                    jTextFieldNomeCliente.setText(null);
                    jTextFieldTelefoneCliente.setText(null);
                    jTextFieldEmailCliente.setText(null);
                    jTextFieldEndCliente.setText(null);
                    jButtonAdicionarCliente.setEnabled(true);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void remover() {
        int confirma = JOptionPane.showConfirmDialog(null, "tem certeza que dejesa remover este cliente?",
                "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from tbcliente where idpessoa=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, jTextFieldIdCliente.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
                    jTextFieldNomeCliente.setText(null);
                    jTextFieldTelefoneCliente.setText(null);
                    jTextFieldEmailCliente.setText(null);
                    jTextFieldEndCliente.setText(null);
                    jButtonAdicionarCliente.setEnabled(true);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldEndCliente = new javax.swing.JTextField();
        jTextFieldNomeCliente = new javax.swing.JTextField();
        jTextFieldTelefoneCliente = new javax.swing.JTextField();
        jTextFieldEmailCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCliente = new javax.swing.JTable();
        jTextFieldBuscarCliente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonAtualizarCliente = new javax.swing.JButton();
        jButtonAdicionarCliente = new javax.swing.JButton();
        jButtonDeletarCliente = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldIdCliente = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Clientes");
        setPreferredSize(new java.awt.Dimension(385, 443));

        jLabel2.setText("*Nome");

        jLabel3.setText("*Endereço");

        jLabel4.setText("* Telefone");

        jLabel5.setText("* E-mail");

        jTableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone", "Endereço", "Email"
            }
        ));
        jTableCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCliente);

        jTextFieldBuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarClienteKeyReleased(evt);
            }
        });

        jButton1.setText("Buscar");

        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("*Campos Obrigatórios");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonAtualizarCliente.setText("Atualizar");
        jButtonAtualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarClienteActionPerformed(evt);
            }
        });

        jButtonAdicionarCliente.setText("Adicionar");
        jButtonAdicionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarClienteActionPerformed(evt);
            }
        });

        jButtonDeletarCliente.setText("Deletar");
        jButtonDeletarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButtonAdicionarCliente)
                .addGap(38, 38, 38)
                .addComponent(jButtonAtualizarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jButtonDeletarCliente)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAtualizarCliente)
                    .addComponent(jButtonAdicionarCliente)
                    .addComponent(jButtonDeletarCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setText("Id Cliente");

        jTextFieldIdCliente.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldBuscarCliente)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldEndCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addComponent(jTextFieldEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldEndCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        setBounds(0, 0, 385, 453);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarClienteActionPerformed
        adicionar();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAdicionarClienteActionPerformed

    private void jTextFieldBuscarClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarClienteKeyReleased
        pesquisar_cliente();
    }//GEN-LAST:event_jTextFieldBuscarClienteKeyReleased

    private void jTableClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClienteMouseClicked
        // TODO add your handling code here:
        setar_campos();
    }//GEN-LAST:event_jTableClienteMouseClicked

    private void jButtonAtualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarClienteActionPerformed
        // TODO add your handling code here:
        alterar();
    }//GEN-LAST:event_jButtonAtualizarClienteActionPerformed

    private void jButtonDeletarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeletarClienteActionPerformed
        // TODO add your handling code here:
        remover();
    }//GEN-LAST:event_jButtonDeletarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAdicionarCliente;
    private javax.swing.JButton jButtonAtualizarCliente;
    private javax.swing.JButton jButtonDeletarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCliente;
    private javax.swing.JTextField jTextFieldBuscarCliente;
    private javax.swing.JTextField jTextFieldEmailCliente;
    private javax.swing.JTextField jTextFieldEndCliente;
    private javax.swing.JTextField jTextFieldIdCliente;
    private javax.swing.JTextField jTextFieldNomeCliente;
    private javax.swing.JTextField jTextFieldTelefoneCliente;
    // End of variables declaration//GEN-END:variables
}
