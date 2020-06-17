/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prjempresa.telas;

/**
 *
 * @author felip
 *
 */
import java.sql.*;
import javax.swing.JOptionPane;
import prjempresa.dal.ModuloConexao;

public class TelaUsuario extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    private void consultar() {
        //String num_id = JOptionPane.showInputDialog("ID do usuário");
        //String sql = "select * from tbuser where idpessoa=" + num_id;  
        String sql = "select * from tbuser where idpessoa=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, jTextFieldID.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                jTextFieldNomeUser.setText(rs.getString(2));
                jTextFieldLoginUser.setText(rs.getString(4));
                jTextFieldTelefoneUser.setText(rs.getString(3));
                jTextFieldSenhaUser.setText(rs.getString(5));
                jComboBoxPerfilUser.setSelectedItem(rs.getString(6));

            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
                jTextFieldNomeUser.setText(null);
                jTextFieldLoginUser.setText(null);
                jTextFieldTelefoneUser.setText(null);
                jTextFieldSenhaUser.setText(null);
                jComboBoxPerfilUser.setSelectedItem(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void adicionar() {
        String sql = "insert into tbuser (nome, fone, login, senha, perfil)"
                + "value (?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, jTextFieldNomeUser.getText());
            pst.setString(2, jTextFieldTelefoneUser.getText());
            pst.setString(3, jTextFieldLoginUser.getText());
            pst.setString(4, jTextFieldSenhaUser.getText());
            pst.setString(5, jComboBoxPerfilUser.getSelectedItem().toString());

            if ((jTextFieldNomeUser.getText().isEmpty())
                    || (jTextFieldLoginUser.getText().isEmpty()) || (jTextFieldSenhaUser.getText().isEmpty())
                    || (jTextFieldTelefoneUser.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "preencha todos os campos obrigatórios!");

            } else {

                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                    jTextFieldID.setText(null);
                    jTextFieldNomeUser.setText(null);
                    jTextFieldLoginUser.setText(null);
                    jTextFieldTelefoneUser.setText(null);
                    jTextFieldSenhaUser.setText(null);
                    jComboBoxPerfilUser.setSelectedItem(null);

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void alterar() {
        String sql = "update tbuser set nome=?, fone=?, login=?, senha=?, perfil=? where idpessoa=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, jTextFieldNomeUser.getText());
            pst.setString(2, jTextFieldTelefoneUser.getText());
            pst.setString(3, jTextFieldLoginUser.getText());
            pst.setString(4, jTextFieldSenhaUser.getText());
            pst.setString(5, jComboBoxPerfilUser.getSelectedItem().toString());
            pst.setString(6, jTextFieldID.getText());

            if ( (jTextFieldNomeUser.getText().isEmpty())
                    || (jTextFieldLoginUser.getText().isEmpty()) || (jTextFieldSenhaUser.getText().isEmpty())
                    || (jTextFieldTelefoneUser.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "preencha todos os campos obrigatórios!");

            } else {

                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do usuário atualizados com sucesso!");
                    jTextFieldID.setText(null);
                    jTextFieldNomeUser.setText(null);
                    jTextFieldLoginUser.setText(null);
                    jTextFieldTelefoneUser.setText(null);
                    jTextFieldSenhaUser.setText(null);
                    jComboBoxPerfilUser.setSelectedItem(null);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void remover() {
        int confirma = JOptionPane.showConfirmDialog(null, "tem certeza que dejesa remover este usuário?",
                "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from tbuser where idpessoa=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, jTextFieldID.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
                    jTextFieldID.setText(null);
                    jTextFieldNomeUser.setText(null);
                    jTextFieldLoginUser.setText(null);
                    jTextFieldTelefoneUser.setText(null);
                    jTextFieldSenhaUser.setText(null);
                    jComboBoxPerfilUser.setSelectedItem(null);
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

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jTextFieldNomeUser = new javax.swing.JTextField();
        jTextFieldLoginUser = new javax.swing.JTextField();
        jTextFieldSenhaUser = new javax.swing.JTextField();
        jComboBoxPerfilUser = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldTelefoneUser = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonCreateUser = new javax.swing.JButton();
        jButtonReadUser = new javax.swing.JButton();
        jButtonUptadeUser = new javax.swing.JButton();
        jButtonDeleteUser = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuários");
        setPreferredSize(new java.awt.Dimension(450, 350));

        jLabel1.setText("*ID");

        jLabel2.setText("*Nome");

        jLabel3.setText("*Login");

        jLabel4.setText("*Senha");

        jLabel5.setText("*Perfil");

        jTextFieldLoginUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLoginUserActionPerformed(evt);
            }
        });

        jTextFieldSenhaUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSenhaUserActionPerformed(evt);
            }
        });

        jComboBoxPerfilUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "admin\t", "usuario" }));

        jLabel6.setText("*Telefone ");

        jTextFieldTelefoneUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTelefoneUserActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("* Campos Obrigátorios");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonCreateUser.setText("Adicionar");
        jButtonCreateUser.setToolTipText("Adicionar");
        jButtonCreateUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCreateUser.setPreferredSize(new java.awt.Dimension(80, 80));
        jButtonCreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateUserActionPerformed(evt);
            }
        });

        jButtonReadUser.setText("Buscar");
        jButtonReadUser.setToolTipText("Buscar");
        jButtonReadUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonReadUser.setPreferredSize(new java.awt.Dimension(80, 80));
        jButtonReadUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReadUserActionPerformed(evt);
            }
        });

        jButtonUptadeUser.setText("Alterar");
        jButtonUptadeUser.setToolTipText("Alterar");
        jButtonUptadeUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonUptadeUser.setPreferredSize(new java.awt.Dimension(80, 80));
        jButtonUptadeUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUptadeUserActionPerformed(evt);
            }
        });

        jButtonDeleteUser.setText("Deletar");
        jButtonDeleteUser.setToolTipText("Deletar");
        jButtonDeleteUser.setPreferredSize(new java.awt.Dimension(80, 80));
        jButtonDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButtonCreateUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonReadUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonUptadeUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jButtonDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCreateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReadUser, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUptadeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldTelefoneUser, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldSenhaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldLoginUser, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBoxPerfilUser, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldNomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLoginUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldTelefoneUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldSenhaUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxPerfilUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        setBounds(0, 0, 430, 322);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldSenhaUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSenhaUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSenhaUserActionPerformed

    private void jTextFieldLoginUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLoginUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLoginUserActionPerformed

    private void jButtonDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteUserActionPerformed
        // TODO add your handling code here:
        remover();
    }//GEN-LAST:event_jButtonDeleteUserActionPerformed

    private void jTextFieldTelefoneUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelefoneUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelefoneUserActionPerformed

    private void jButtonReadUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReadUserActionPerformed
        // TODO add your handling code here:
        consultar();
    }//GEN-LAST:event_jButtonReadUserActionPerformed

    private void jButtonCreateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateUserActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_jButtonCreateUserActionPerformed

    private void jButtonUptadeUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUptadeUserActionPerformed
        // TODO add your handling code here:
        alterar();
    }//GEN-LAST:event_jButtonUptadeUserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreateUser;
    private javax.swing.JButton jButtonDeleteUser;
    private javax.swing.JButton jButtonReadUser;
    private javax.swing.JButton jButtonUptadeUser;
    private javax.swing.JComboBox jComboBoxPerfilUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldLoginUser;
    private javax.swing.JTextField jTextFieldNomeUser;
    private javax.swing.JTextField jTextFieldSenhaUser;
    private javax.swing.JTextField jTextFieldTelefoneUser;
    // End of variables declaration//GEN-END:variables
}
