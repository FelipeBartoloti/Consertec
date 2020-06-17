/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prjempresa.telas;

import javax.swing.JOptionPane;
import java.sql.*;
import java.text.DateFormat;
import static mondrian.olap.fun.vba.Vba.date;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import static org.joda.time.format.ISODateTimeFormat.date;
import prjempresa.dal.ModuloConexao;
import java.util.Date;

/**
 *
 * @author felip
 */
public class TelaPrincipal extends javax.swing.JFrame {
    
    
    Connection conexao = null;
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        conexao = ModuloConexao.conector();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jDesktopPrincipal = new javax.swing.JDesktopPane();
        jLabelData = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        jMenuBarGeral = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuItemCliente = new javax.swing.JMenuItem();
        jMenuItemOs = new javax.swing.JMenuItem();
        jMenuItemUsuarios = new javax.swing.JMenuItem();
        jMenuRelatorio = new javax.swing.JMenu();
        jMenuItemCli = new javax.swing.JMenuItem();
        jMenuItemServ = new javax.swing.JMenuItem();
        jMenuOpcoes = new javax.swing.JMenu();
        jMenuItemSair = new javax.swing.JMenuItem();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consertec");
        setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jDesktopPrincipal.setPreferredSize(new java.awt.Dimension(450, 350));

        javax.swing.GroupLayout jDesktopPrincipalLayout = new javax.swing.GroupLayout(jDesktopPrincipal);
        jDesktopPrincipal.setLayout(jDesktopPrincipalLayout);
        jDesktopPrincipalLayout.setHorizontalGroup(
            jDesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );
        jDesktopPrincipalLayout.setVerticalGroup(
            jDesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabelData.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabelData.setText("Data");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prjempresa/icones/celular4.png"))); // NOI18N
        jLabel4.setText("jLabel4");

        jLabelUser.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabelUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUser.setText("user");
        jLabelUser.setToolTipText("");

        jMenuCadastro.setText("Cadastro");

        jMenuItemCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCliente.setText("Clientes ");
        jMenuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClienteActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCliente);

        jMenuItemOs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemOs.setText("Ordem Serviço");
        jMenuItemOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOsActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemOs);

        jMenuItemUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemUsuarios.setText("Usuários");
        jMenuItemUsuarios.setEnabled(false);
        jMenuItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsuariosActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemUsuarios);

        jMenuBarGeral.add(jMenuCadastro);

        jMenuRelatorio.setText("Relatório");
        jMenuRelatorio.setEnabled(false);

        jMenuItemCli.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCli.setText("Clientes");
        jMenuItemCli.setEnabled(false);
        jMenuItemCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCliActionPerformed(evt);
            }
        });
        jMenuRelatorio.add(jMenuItemCli);

        jMenuItemServ.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemServ.setText("Serviços");
        jMenuItemServ.setEnabled(false);
        jMenuItemServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemServActionPerformed(evt);
            }
        });
        jMenuRelatorio.add(jMenuItemServ);

        jMenuBarGeral.add(jMenuRelatorio);

        jMenuOpcoes.setText("Opções");
        jMenuOpcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuOpcoesActionPerformed(evt);
            }
        });

        jMenuItemSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSair.setText("Sair ");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenuOpcoes.add(jMenuItemSair);

        jMenuBarGeral.add(jMenuOpcoes);

        setJMenuBar(jMenuBarGeral);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelData)
                        .addGap(75, 75, 75))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(257, 257, 257)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelData)
                                .addGap(17, 17, 17)
                                .addComponent(jLabelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(jLabel4)))
                        .addGap(0, 38, Short.MAX_VALUE))
                    .addComponent(jDesktopPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Consertec - sistema para controle de ordem de serviço");

        setSize(new java.awt.Dimension(725, 554));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuOpcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuOpcoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuOpcoesActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        int Sair = JOptionPane.showConfirmDialog(null, "Deseja mesmo sair?", "Atenção", JOptionPane.YES_NO_OPTION );
        if (Sair == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jMenuItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsuariosActionPerformed
        TelaUsuario usuario = new TelaUsuario();
        usuario.setVisible(true);
        jDesktopPrincipal.add(usuario);
    }//GEN-LAST:event_jMenuItemUsuariosActionPerformed

    private void jMenuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClienteActionPerformed
        // TODO add your handling code here:
        TelaCliente cliente = new TelaCliente();
        cliente.setVisible(true);
        jDesktopPrincipal.add(cliente);
    }//GEN-LAST:event_jMenuItemClienteActionPerformed

    private void jMenuItemOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOsActionPerformed
        // TODO add your handling code here:
        TelaOs os = new TelaOs();
        os.setVisible(true);
        jDesktopPrincipal.add(os);
    }//GEN-LAST:event_jMenuItemOsActionPerformed

    private void jMenuItemCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCliActionPerformed
        // TODO add your handling code here:
        int confirma = JOptionPane.showConfirmDialog(null,"Confirmar Emissão de Ralatório de Clientes Cadastrados?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            try {
               
                JasperPrint imprimir = JasperFillManager.fillReport("C:/reports/clientes.jasper", null, conexao);
                JasperViewer.viewReport(imprimir, false);
                
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            
        }
        
    }//GEN-LAST:event_jMenuItemCliActionPerformed

    private void jMenuItemServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemServActionPerformed
        // TODO add your handling code here:
        int confirma = JOptionPane.showConfirmDialog(null,"Confirmar Emissão de Ralatório de Ordens de Serviço?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            try {
               
                JasperPrint imprimir = JasperFillManager.fillReport("C:/reports/ralatorioservico.jasper", null, conexao);
                JasperViewer.viewReport(imprimir, false);
                
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            
        }
        
    }//GEN-LAST:event_jMenuItemServActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
       Date data = new Date();
       DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
       jLabelData.setText(formatador.format(data));
       
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPrincipal;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelData;
    public static javax.swing.JLabel jLabelUser;
    private javax.swing.JMenuBar jMenuBarGeral;
    private javax.swing.JMenu jMenuCadastro;
    public static javax.swing.JMenuItem jMenuItemCli;
    private javax.swing.JMenuItem jMenuItemCliente;
    private javax.swing.JMenuItem jMenuItemOs;
    private javax.swing.JMenuItem jMenuItemSair;
    public static javax.swing.JMenuItem jMenuItemServ;
    public static javax.swing.JMenuItem jMenuItemUsuarios;
    private javax.swing.JMenu jMenuOpcoes;
    public static javax.swing.JMenu jMenuRelatorio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}